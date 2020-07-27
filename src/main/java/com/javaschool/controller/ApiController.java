package com.javaschool.controller;

import com.javaschool.dto.RequestDTO;
import com.javaschool.service.ApiService;
import javassist.tools.web.BadHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class ApiController {

    private final Logger log = LoggerFactory.getLogger(ApiController.class);
    private ApiService apiService;

    public ApiController(ApiService apiService){
        this.apiService = apiService;
    }


    @PostMapping("/alias/")
    ResponseEntity<String> createAlias(@RequestBody RequestDTO request){
        log.info("Request url: {}", request.getUrl());
        try{
        String response = apiService.createAlias(request.getUrl());
        return ResponseEntity.ok().body(response);
        }catch (BadHttpRequest e){
            return  ResponseEntity.badRequest().body("URL invalid!");
        }
    }

    @GetMapping("/alias/")
    ResponseEntity<String> getFromAlias(@RequestParam("alias") String alias) throws BadHttpRequest {
        log.info("Request get information from alias: {}", alias);
        try {
            String aliasResponse = apiService.getFromAlias(alias);
            return ResponseEntity.ok().body(aliasResponse);
        }catch (BadHttpRequest e){
            return  ResponseEntity.badRequest().body("Alias does not exist");
        }
    }



}
