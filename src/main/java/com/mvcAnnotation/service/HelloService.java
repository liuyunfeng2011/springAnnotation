package com.mvcAnnotation.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	public String getHello(String name) {
        return name + ",Hello!";
    }
}
