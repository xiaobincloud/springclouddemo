package com.cloud.order.dto.RequestDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xiaobin
 * @Title: OrderInfoDTO
 * @date 2019/04/28
 * @Description:
 */
@Data
@NoArgsConstructor
@ApiModel(value = "创建订单信息")
public class OrderInfoDTO implements Serializable {

    @ApiModelProperty(value = "订单名称")
    private String name;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal price;
}
