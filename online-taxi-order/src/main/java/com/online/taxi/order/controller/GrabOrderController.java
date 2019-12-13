package com.online.taxi.order.controller;

import com.online.taxi.order.service.GrabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "grab")
public class GrabOrderController {

    @Autowired
    private GrabService grabService;

    @RequestMapping(value = "/do/{orderId}/{driverId}")
    public String grab(@PathVariable int orderId, @PathVariable int driverId) {
        grabService.grabOrder(orderId,driverId);
        return "";
    }
}
