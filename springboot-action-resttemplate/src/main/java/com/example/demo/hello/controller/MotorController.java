package com.example.demo.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/motor")
public class MotorController {

    @Autowired
    RestTemplate restTemplate;

    private static String MOTOR_VIL_URL = "https://VIL3.Motor.com/SelectlineConnector.aspx?";

    /*
    https://VIL3.Motor.com/SelectlineConnector.aspx?cid=99&pid=99&pin=userxyz
    &ts=5/27/2021 08:52:03 PM&ip=68.12.4.128&cg=1,2,3
    &Search=brake pad&Vin=1GD120CL8BF179694&sig=abd673f982bc9028ab3309fa
     */
    @GetMapping("/vil")
    public void motorVIL(){
        Object cid = 99;
        Object pid = 99;
        Object ts = "5/27/2021 08:52:03 PM";

        Object ip = "68.12.4.128";

        Object cg = "1,2,3";

        Object search = "brake pad";

        Object vin = "1GD120CL8BF179694";
        Object sig = "abd673f982bc9028ab3309fa";
        restTemplate.getForObject(MOTOR_VIL_URL + "cid={cid}&pid={pid}&ts={ts}&ip={ip}&cg={cg}" +
                        "&Search={search}&Vin={vin}" +
                        "&sig={sig}", List.class,
                cid, pid, ts, ip, cg, search, vin, sig);
    }
}
