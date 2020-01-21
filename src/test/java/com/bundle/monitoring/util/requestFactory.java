package com.bundle.monitoring.util;

import com.bundle.monitoring.model.request.Product;
import com.bundle.monitoring.model.request.Sale;
import com.bundle.monitoring.model.request.Shipping;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

public final class requestFactory {
    public static Sale sale(){
        Sale sale = new Sale();
        sale.setId(1L);
        sale.setProductId(1L);
        sale.setSaleCode(UUID.fromString("56613a46-d0eb-47ec-9303-aca508d8aa66"));

        return sale;
    }

    public static Product product() throws MalformedURLException {
        Product product = new Product();
        product.setId(1L);
        product.setCategory("category");
        product.setImage(new URL("http://www.dundarkerem.com"));
        product.setName("productName");
        product.setPrice(new BigDecimal(6000.50));

        return product;
    }

    public static Shipping shipping(){
        Shipping shipping = new Shipping();
        shipping.setCreatedAt(new Date());
        shipping.setStatus(true);
        shipping.setSaleId(1L);

        return shipping;
    }
}
