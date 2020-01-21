package com.bundle.monitoring.service.impl;

import com.bundle.monitoring.model.dto.MonitoringDTO;
import com.bundle.monitoring.model.dto.ProductDTO;
import com.bundle.monitoring.model.dto.SaleDTO;
import com.bundle.monitoring.model.request.Product;
import com.bundle.monitoring.model.request.Sale;
import com.bundle.monitoring.model.request.Shipping;
import com.bundle.monitoring.service.MonitoringService;
import com.bundle.monitoring.service.ProductService;
import com.bundle.monitoring.service.SaleService;
import com.bundle.monitoring.service.ShippingService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoringServiceImpl implements MonitoringService {

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private ShippingService shippingService;

    @Override
    public String getSaleAndShipping(Long id) {

        MonitoringDTO monitoringDTO = new MonitoringDTO();

        Sale sale = saleService.getById(id);
        Product product = productService.getById(sale.getProductId());
        Shipping shipping = shippingService.getById(id);

        monitoringDTO.setSale(new SaleDTO().toDTO(sale));
        monitoringDTO.setProduct(new ProductDTO().toDTO(product));
        monitoringDTO.setStatus(shipping.isStatus() ? "TESLIM EDILDI" : "TESLIM EDILMEDI");

        Gson gson = new Gson();
        return gson.toJson(monitoringDTO);

    }
}
