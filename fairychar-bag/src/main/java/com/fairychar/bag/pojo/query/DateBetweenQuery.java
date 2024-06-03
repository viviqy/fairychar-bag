package com.fairychar.bag.pojo.query;


import com.fairychar.bag.domain.Consts;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Datetime: 2021/5/21 20:03
 *
 * @author chiyo
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Schema(description = "日期段查询")
public class DateBetweenQuery implements Serializable {
    @Schema(description = "起始时间")
    @JsonFormat(pattern = Consts.SIMPLE_DATE_FORMAT)
    private LocalDate from;
    @Schema(description = "结束时间")
    @JsonFormat(pattern = Consts.SIMPLE_DATE_FORMAT)
    private LocalDate to;
}
