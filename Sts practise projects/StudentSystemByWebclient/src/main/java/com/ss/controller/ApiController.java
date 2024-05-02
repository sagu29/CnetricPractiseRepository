package com.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.service.ApiService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/fetch-data-from-api")
    public Mono<String> fetchDataFromApi() {
        return apiService.fetchDataFromApi();
    }
}
	


    
    

