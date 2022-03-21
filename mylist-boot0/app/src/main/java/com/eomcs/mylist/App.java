package com.eomcs.mylist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableTransactionManagement // 애노테이션으로 트랙잭션을 제어할 수 있게 설정한다. 
@RestController
@SpringBootApplication
public class App {

  //  //@Bean - 주석으로 막으면 호출됨 - 스프ㄹ링웹 ㅡㅍㅊ 있어야되는데 / 자동설정된것 부트(스타터때문에) 
  //  PlatformTransactionManager transactionmanager(DataSource ds) {
  //    return new DataSourceTransactionManager(ds); //커넥션풀을 달라고
  //  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  //@Bean
  public CommandLineRunner commandLineRunner(ApplicationContext beanContainer) {
    return args -> {

      System.out.println("빈 컨테이너가 생성한 객체(빈 컨테이너에 들어 있는 객체):");

      String[] beanNames = beanContainer.getBeanDefinitionNames();
      for (int i = 0; i < beanNames.length; i++) {
        Object bean = beanContainer.getBean(beanNames[i]);
        System.out.printf("----> %03d: %s\n", i + 1, bean.getClass().getName());
      }

    };
  }

  @RequestMapping("/hello")
  String hello() {
    return "Hello World!";
  }

}
