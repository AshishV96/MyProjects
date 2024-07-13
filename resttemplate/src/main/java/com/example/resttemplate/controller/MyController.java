package com.example.resttemplate.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.Random;

@RestController
@RequestMapping("my")
public class MyController {

    private Double OTP;
    private String str = "Hello";
    @GetMapping("start")
    public void startLoop() throws InterruptedException {

        int len = 0;
        while(true)
        {
            String st = "    "+str+"    ";

//            if(str.length()<10)
//                str+="    ";
            for(int i=len;i<len+10;i++)
             System.out.print(st.charAt(i%st.length()));

            len++;
            Thread.sleep(1000);

            for(int i=0;i<50;i++)
                System.out.println();

        }
    }
    @GetMapping("add/{s}")
    public String addString(@PathVariable String s)
    {
        str = s;
        return "added";
    }

    @GetMapping("sendOTP")
    public String sendOTP(HttpSession session) throws InterruptedException {
        Random random = new Random();
        Integer OTP = random.nextInt(899999)+100000;
        System.out.println("Session ID:: "+session.getId());
        System.out.println(OTP);
        session.setAttribute("OTP",OTP);
        Thread.sleep(2000);
        return "OTP Sent";
    }

    @PostMapping("isOTPValid")
    public String isOTPValid(@RequestBody Integer OTP,HttpSession session)
    {
        if(OTP.compareTo((Integer)session.getAttribute("OTP"))==0)
            return "OTP Valid";

        else {
            System.out.println(session.getAttribute("OTP"));
            return "OTP Invalid";
        }
    }

}
