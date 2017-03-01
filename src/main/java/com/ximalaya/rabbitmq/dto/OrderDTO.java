package com.ximalaya.rabbitmq.dto;

import lombok.Builder;

import java.util.Date;


@Builder
public class OrderDTO {

    private long orderId;

    private Date createdAt;


}
