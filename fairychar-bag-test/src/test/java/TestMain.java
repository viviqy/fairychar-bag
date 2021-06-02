import com.fairychar.bag.beans.netty.client.SimpleNettyClient;
import com.fairychar.bag.beans.netty.decoder.DelimitersHeadTailFrameDecoder;
import com.fairychar.bag.beans.netty.server.SimpleNettyServer;
import com.fairychar.bag.domain.Consts;
import com.fairychar.bag.domain.abstracts.AbstractScheduleAction;
import com.fairychar.bag.domain.netty.frame.HeadTailFrame;
import com.fairychar.bag.function.Action;
import com.fairychar.bag.template.ActionSelectorTemplate;
import com.fairychar.bag.utils.NotVeryUsefulUtil;
import com.fairychar.bag.utils.ReflectUtil;
import com.fairychar.test.web.controller.SimpleController;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections.list.PredicatedList;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * Datetime: 2020/6/2 14:47 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class TestMain {

    @Test
    public void testSwapInteger(){
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        ReflectUtil.swapInteger(a,b);
        System.out.println("a="+a+",b="+b);
    }


    @Data
    @AllArgsConstructor
    static class Child {
        private Long id;
        private String name;
        private Long pid;
    }

    @Test
    public void testPid() throws Exception{
        List<Child> children = Arrays.asList(
                new Child(1L, "1", 0L),
                new Child(2L, "2", 1L),
                new Child(4L, "22", 2L),
                new Child(3L, "3", 2L)
        );
        System.out.println(ReflectUtil.recursiveSearchParent(children, "pid", "id", 2L));
        ArrayList<Child> list = new ArrayList<>();
//        ReflectUtil.recursiveSearch(children,list,"id","pid",1L);
//        System.out.println(list);
//        System.out.println("-------");
//        ArrayList<Child> ref = new ArrayList<>();
//        recursiveSearch(children,2,ref);
//        System.out.println(ref);
//        ref.clear();
//        System.out.println("-----");
//        recursiveSearch(children,1,ref);
//        System.out.println(ref);
    }

    /**
     * @param source 表里查出来带pid和id字段的数据
     * @param id 要查询的id
     * @param ref
     * @param <T>
     */
    public <T> void recursiveSearch(List<T> source, long id, List<T> ref) {
        List<T> childList = source.stream().filter(s -> {
            try {
                Field pid = s.getClass().getDeclaredField("pid");
                pid.setAccessible(true);
                Long pidValue = (Long) pid.get(s);
                return pidValue == id;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        if (childList.isEmpty()) {
            return;
        }
        ref.addAll(childList);
        childList.forEach(s -> {
            try {
                Field childId = s.getClass().getDeclaredField("id");
                childId.setAccessible(true);
                Long childIdValue = (Long) childId.get(s);
                recursiveSearch(source, childIdValue, ref);
            } catch (Exception e) {
            }
        });
    }

    @Test
    public void testHeadTailFrame() throws InterruptedException {
        SimpleNettyServer simpleNettyServer = new SimpleNettyServer(1, 10000
                , new ChannelInitializer<ServerSocketChannel>() {
            @Override
            protected void initChannel(ServerSocketChannel serverSocketChannel) throws Exception {
            }
        }, new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new DelimitersHeadTailFrameDecoder(
                        new byte[]{((byte) 'a')}
                        , new byte[]{((byte) 'c')}
                        , 10
                )).addLast(
                        new SimpleChannelInboundHandler<HeadTailFrame>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, HeadTailFrame headTailFrame) throws Exception {
                                System.out.println(headTailFrame);
                                headTailFrame.getContent().release();
                            }
                        }
                );
            }
        });
        simpleNettyServer.start();
        Thread.currentThread().join();
    }

    @Test
    public void testClient() throws InterruptedException {
        int count = 200;
        CountDownLatch countDownLatch = new CountDownLatch(count);
//        String host = "47.92.165.174";
//        int port = 20055;
        String host = "47.100.26.111";
        int port = 18080;
        final ExecutorService executorService = Executors.newFixedThreadPool(count);
        final ArrayList<SimpleNettyClient> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {

            SimpleNettyClient client = new SimpleNettyClient(1, port, host,
                    new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new StringEncoder())
                                    .addLast(new StringDecoder());
                        }
                    });
            client.start();
            System.out.println(client.getChannel().isActive());
            list.add(client);
        }

        list.forEach(s -> executorService.execute(() -> {
            countDownLatch.countDown();
            for (int i = 0; i < 10_0000; i++) {
                try {
                    s.getChannel().writeAndFlush("hihihihihihihihihihihihi\r\n")
                            .get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.err.println(Thread.currentThread().getName() + " complete");
        }));
        while (true) {
            TimeUnit.SECONDS.sleep(3);
            list.forEach(s -> System.out.println(s.getChannel().isActive()));
        }
//        Thread.currentThread().join();
    }

    @Test
    public void testCreateFakeFile() throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        long begin = System.currentTimeMillis();
        NotVeryUsefulUtil.createFakeFile("F:\\a.txt"
                , Consts.GB_PER_B * 2);
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Test
    public void testFuture() {
        String[] s = {"丸摩堂", "茶百道", "coco"};
        Random random = new Random(System.currentTimeMillis());
        HashMap<String, AtomicInteger> map = new HashMap<String, AtomicInteger>() {{
            put(s[0], new AtomicInteger(0));
            put(s[1], new AtomicInteger(0));
            put(s[2], new AtomicInteger(0));
        }};
        for (int i = 0; i < 300; i++) {
            int position = random.nextInt(3);
            AtomicInteger count = map.get(s[position]);
            count.getAndIncrement();
        }
        System.out.println(map);
    }

    @Test
    public void testNetty() {

        SimpleNettyServer server = new SimpleNettyServer(2, 10000
                , new ChannelInitializer<ServerSocketChannel>() {
            @Override
            protected void initChannel(ServerSocketChannel serverSocketChannel) throws Exception {
                serverSocketChannel.pipeline().addLast(new LoggingHandler());
            }
        }, new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new LoggingHandler());
            }
        });
        server.setMaxShutdownWaitSeconds(10);
//        server.start();
//        server.stop();

        SimpleNettyClient client = new SimpleNettyClient(1, 10001, "127.0.0.1"
                , new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new LoggingHandler());
            }
        });
        client.setMaxShutdownWaitSeconds(10);
        client.stop();
    }


    @Test
    public void test16() throws Exception {
        SimpleNettyServer simpleNettyServer = new SimpleNettyServer(1, 10);
        simpleNettyServer.start();
        Thread.currentThread().join();
    }

    @Test
    public void testSwap() {
        int a = 1, b = 2;
        int c = a ^ b;
        a = c ^ a;
        b = c ^ b;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void testNIO() throws Exception {
        ActionSelectorTemplate actionSelectorTemplate = new ActionSelectorTemplate();
        Action action = new Action() {
            private int a = new Random().nextInt();

            @Override
            public void doAction() throws InterruptedException, TimeoutException {
                System.out.println(Thread.currentThread().getName());
            }
        };
        actionSelectorTemplate.put("task", 100, action);
        actionSelectorTemplate.put("task1", 200, action);
        actionSelectorTemplate.put("task2", 300, action);
        actionSelectorTemplate.start();
        TimeUnit.SECONDS.sleep(5);
        actionSelectorTemplate.remove("task");
        Thread.currentThread().join();
    }

    @Test
    public void test15() throws Exception {

        ExecutorService single = Executors.newFixedThreadPool(2);
        AbstractScheduleAction scheduleAction = (AbstractScheduleAction) new FinalScheduleAction();

        Runnable runnable = () -> {
            try {
                scheduleAction.doAction0();
            } catch (TimeoutException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        single.execute(runnable);
        TimeUnit.SECONDS.sleep(1);
        single.execute(runnable);
        TimeUnit.SECONDS.sleep(5);
        scheduleAction.interruptAll();
        single.execute(runnable);
        single.execute(runnable);
        Thread.currentThread().join();
    }

    static class FinalScheduleAction extends AbstractScheduleAction {
        /**
         * 执行任务
         *
         * @throws InterruptedException 打断触发
         * @throws TimeoutException     超时触发
         */
        @Override
        public void doAction() throws InterruptedException, TimeoutException {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().isInterrupted());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

    }


    @Test
    public void test14() {
        SimpleController controller = new SimpleController();
        Method[] methods = controller.getClass().getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getDeclaringClass().getName()
                    .concat(method.getName());
            String returnName = method.getReturnType().getName();
            String parameterName = "";
            for (Class<?> parameterType : method.getParameterTypes()) {
                parameterName = parameterName.concat(parameterType.getName()).concat(",");
            }
            System.out.println(methodName);
            System.out.println(returnName);
            System.out.println(parameterName);
        }
    }

    @Test
    public void testStreamDistinct() {
        ArrayList<Integer> collect = Arrays.asList(1, 2, 3, 4).stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Integer::intValue)))
                        , ArrayList::new)
                );

    }

    @Test
    public void test13() {
        for (int i = 1; i <= 99; i++) {
            System.out.println("认错x" + i);
        }
        String s = new String();
    }

    @Test
    public void test2() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(() -> reentrantLock.lock()).start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread = new Thread(() -> {

            try {
                reentrantLock.tryLock(3, TimeUnit.SECONDS);
                System.out.println(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        Thread.currentThread().join();
    }

    @Test
    public void test1() throws InterruptedException {
        String a = "aa";
        String b = "aa";
        new Thread(() -> {
            System.out.println("a:" + a);
            synchronized (a) {
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            synchronized (b) {
                System.out.println(b);
            }
        }).start();
        Thread.currentThread().join();
    }
}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   
____________ ~\________|__/   / // \__ |  ||  / | |   | | 
                      ,~-|~~~~~\--, | \|--|/~|||  |   | | 
                      [3-|____---~~ _--'==;/ _,   |   |_| 
                                  /   /\__|_/  \  \__/--/ 
                                 /---/_\  -___/ |  /,--|  
                                 /  /\/~--|   | |  \///   
                                /  / |-__ \    |/         
                               |--/ /      |-- | \        
                              \^~~\\/\      \   \/- _     
                               \    |  \     |~~\~~| \    
                                \    \  \     \   \  | \  
                                  \    \ |     \   \    \ 
                                   |~~|\/\|     \   \   | 
                                  |   |/         \_--_- |\
                                  |  /            /   |/\/
                                   ~~             /  /    
                                                 |__/   W<

*/