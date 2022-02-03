package com.eomcs.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServerApp {

  public static void main(String[] args) {
    SpringApplication.run(ServerApp.class, args);
  }


  @RequestMapping("/help")
  public String help() {
    StringBuilder strBuilder = new StringBuilder();
    strBuilder.append("<!DOCTYPE html>\n");
    strBuilder.append("<html><head><meta charset='UTF-8'><title>웹 계산기</title></head>\n");
    strBuilder.append("<body>\n");
    strBuilder.append("<h1>웹 계산기 도움말</h1\n>");
    strBuilder.append("<h1>사용법</h1\n>");
    strBuilder.append("URL 형식 => http://localhost:8080/cal?op=연산자&a=값1&b=값2<br>\n");
    strBuilder.append("예) => http://localhost:8080/cal?op=-&a=100&b=200<br>\n");
    strBuilder.append("<body></html>\n");

    return strBuilder.toString();

  }
}

//웹브라우저는 역슬래쉬n 무쉬 -> 소스보기 - 텍스트 에디터로 출력 개발자가 소스코드 확인하기 어려움 개발자 위한 것. (웹브라우전 br 태그만 )