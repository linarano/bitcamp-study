package com.eomcs.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @RequestMapping("/hello")
  // @ResponseBody //클라이언트에게 보내줘야할 데이터야 라는 의미
  String hello() {
    return "Hello World!";
  }

}
