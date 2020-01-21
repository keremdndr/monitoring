package com.bundle.monitoring.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Shipping {
    private Long saleId;
    private boolean status;
    private Date createdAt;
}
