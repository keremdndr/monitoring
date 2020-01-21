package com.bundle.monitoring.controller;

import com.bundle.monitoring.service.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonitoringApiController {

    @Autowired
    private MonitoringService monitoringService;

    @GetMapping("/sale/{saleId}/shipping")
    @ResponseStatus(HttpStatus.OK)
    public String asd(@PathVariable Long saleId){
        return monitoringService.getSaleAndShipping(saleId);
    }
}

