package com.bundle.monitoring.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Sale {
    private Long id;
    private UUID saleCode;
    private Long productId;
}
