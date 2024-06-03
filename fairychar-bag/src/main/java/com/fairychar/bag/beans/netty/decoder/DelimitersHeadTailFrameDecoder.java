package com.fairychar.bag.beans.netty.decoder;

import com.fairychar.bag.domain.netty.frame.HeadTailFrame;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 固定报文头与固定报文尾的协议解码器
 * <p>
 * Datetime: 2021/2/7 16:21
 *
 * @author chiyo
 * @since 1.0
 */
@Slf4j
public class DelimitersHeadTailFrameDecoder extends ByteToMessageDecoder {

    /**
     * 报文包头
     */
    private final byte[] head;
    /**
     * 报文包尾
     */
    private final byte[] tail;
    /**
     * 缓存content
     */
    private final ByteBuf cache;
    /**
     * 是否已经匹配到header
     */
    private boolean isMatchedHeader = false;

    public DelimitersHeadTailFrameDecoder(byte[] head, byte[] tail, int maxCapacity) {
        this.head = Arrays.copyOf(head, head.length);
        this.tail = Arrays.copyOf(tail, tail.length);
        this.cache = Unpooled.buffer(maxCapacity);
    }


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        HeadTailFrame decode = decode(in);
        if (decode != null) {
            out.add(decode);
        }
    }

    public final HeadTailFrame decode(ByteBuf in) throws Exception {
        validateHeader(in);
        //if in.readableBytes() less than tail.capacity() mean this
        //buff is not read complete,so this is a incomplete frame
        if (in.readableBytes() < tail.length) {
            return null;
        }
        while (in.isReadable()) {
            in.markReaderIndex();
            byte readByte = in.readByte();
            if (readByte != tail[0]) {
                this.cache.writeByte(readByte);
            } else {
                in.resetReaderIndex();
                if (isMatchedTail(in)) {
                    this.isMatchedHeader = false;
                    return wrapFrame();
                }
            }
        }
        return null;
    }

    private boolean isMatchedTail(ByteBuf in) {
        in.markReaderIndex();
        for (int i = 0; i < tail.length; i++) {
            if (in.readByte() != tail[i]) {
                in.resetReaderIndex();
                return false;
            }
        }
        return true;
    }

    private HeadTailFrame wrapFrame() {
        ByteBuf copy = this.cache.copy();
        copy.retain();
        this.cache.clear();
        return new HeadTailFrame(head, copy, tail);
    }

    private void validateHeader(ByteBuf in) throws Exception {
        if (this.isMatchedHeader) {
            return;
        }
        if (in.readableBytes() < head.length) {
            return;
        }
        if (!this.isMatchedHeader) {
            in.markReaderIndex();
            for (int i = 0; i < head.length; i++) {
                if (in.readByte() != head[i]) {
                    in.clear();
                    throw new DecoderException("head error");
                }
            }
        }
        this.isMatchedHeader = true;
    }

}
