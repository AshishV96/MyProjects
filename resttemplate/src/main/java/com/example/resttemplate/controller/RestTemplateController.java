package com.example.resttemplate.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("rest")
public class RestTemplateController {

    private static RestTemplate restTemplate = new RestTemplate();
    private static String baseUrl = "http://localhost:8080/product/";

    @GetMapping("get/{id}")
    public ResponseEntity<String> getProductById(@PathVariable Integer id)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = null;

        try
        {
            response = restTemplate.exchange(baseUrl + "get/" + id,
                    HttpMethod.GET, request, String.class);
//            response = restTemplate.getForEntity(baseUrl + "get/" + id,String.class);
            System.out.println("STATUS :: "+response.getStatusCode());
            System.out.println("BODY :: "+response.getBody());
        }
        catch (HttpClientErrorException e)
        {
            System.out.println("STATUS :: "+e.getStatusCode());
            System.out.println("BODY :: "+e.getResponseBodyAsString());
            return new ResponseEntity<String>(e.getResponseBodyAsString(),HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @PostMapping("add")
    public ResponseEntity<String> addProduct(@RequestBody Object product)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(product,headers);

        ResponseEntity<String> response = null;

        try
        {
            response = restTemplate.exchange(baseUrl + "add/",
                    HttpMethod.POST, request, String.class);
//            response = restTemplate.postForEntity(baseUrl + "add/" ,product,String.class);
            System.out.println("STATUS :: "+response.getStatusCode());
            System.out.println("BODY :: "+response.getBody());
        }
        catch (HttpClientErrorException e)
        {
            System.out.println("STATUS :: "+e.getStatusCode());
            System.out.println("BODY :: "+e.getResponseBodyAsString());
            return new ResponseEntity<String>(e.getResponseBodyAsString(),HttpStatus.NOT_FOUND);
        }

        return response;
    }

}
