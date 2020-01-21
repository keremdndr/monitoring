package com.bundle.monitoring.controller;

import com.bundle.monitoring.model.dto.MonitoringDTO;
import com.bundle.monitoring.model.dto.ProductDTO;
import com.bundle.monitoring.model.dto.SaleDTO;
import com.bundle.monitoring.service.MonitoringService;
import com.bundle.monitoring.util.dtoFactory;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.UUID;


class MonitoringApiControllerTest {

    private MockMvc mvc;

    @Mock
    private MonitoringService monitoringService;

    @InjectMocks
    private MonitoringApiController sut;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Gson gson = new Gson();
        Mockito.when(monitoringService.getSaleAndShipping(Mockito.anyLong())).thenReturn(gson.toJson(dtoFactory.monitoringDTO()));
        mvc = MockMvcBuilders.standaloneSetup(sut).build();

    }

    @Test
    void whenSaleIdGivenThenReturnAllInfo() throws Exception {
        MvcResult result = mvc
                .perform(get("/sale/1/shipping"))
                .andExpect(status().isOk()).andReturn();

        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        assertThat(responseMessage).isNotNull();
        assertThat(responseMessage).contains("\"code\":\"56613a46-d0eb-47ec-9303-aca508d8aa66\"");
    }
}