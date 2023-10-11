package com.cdc2023.springrestjwtauth.hello.restcontroller;

import com.cdc2023.springrestjwtauth.beans.components.HelloComponent;
import com.cdc2023.springrestjwtauth.hello.model.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    HelloComponent helloComponent;

    @GetMapping("/simple")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(value = "/greeting/{name}" )
    public HelloWorld hello(@PathVariable("name") String name) {
        return HelloWorld.builder().message(String.format("Hello %s!!!", name)).build();
    }

    @GetMapping(value = "/bean/{name}" )
    public HelloComponent helloBean(@PathVariable("name") String name) {
        helloComponent.setMessage(String.format("Hello %s!!!", name));
        return helloComponent;
    }
}
