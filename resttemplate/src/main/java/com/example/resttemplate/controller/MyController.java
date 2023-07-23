package com.example.resttemplate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("my")
public class MyController {

    private String str = "Hello";
    @GetMapping("start")
    public void startLoop() throws InterruptedException {

        int arr[] = {1,2,3};
        int arr1[] = arr;

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


}
