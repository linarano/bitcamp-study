//package com.eomcs.mylist;
//
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@SpringBootApplication
//public class App {
//
//  //스프링부트는 자동화가 잘되어있음 
//  //  //1) 인스턴스필드로 받을 수도있고, 
//  //  @Value("${spring.datasource.driver-class-name}")
//  //  String driverClassName; // 이 변수에 들어갈 값은 어플리케이션 프러퍼티에있는 값을 변수에 넣어다오
//  //  @Value("${spring.datasource.url}")
//  //  String url;
//  //  @Value("${spring.datasource.username}")
//  //  String username;
//  //  @Value("${spring.datasource.password}")
//  //  String password;
//
//  //  //DB 커넥션풀 준비
//  //  public static DataSource dataSource; //공개안하면 not visible -> 인터페이스 레퍼런스에 저장하는 방식으로, 그래야 다른 서브클래스들이 올수 있음, - 아파치에서 만든 것
//  //
//
//
//  // Spring 프레임워크(Ioc = 객체풀) 에서 객체를 생성한 후 보관하도록 만드는 방법
//
//  @Bean // => 이 메서드를 자동으로 스프링부트가 호출하고,  다음 메서드를 호출한 후 이 메서드가 리턴한 값을 스프링 부트에(컨테이너) 내부적으로 보관하라고 지시하는 애노테이션
//  public DataSource DataSource( //2) 파라미터로 넘겨줄 수도있음
//      @Value("${spring.datasource.driver-class-name}") String driverClassName, // 스프링부트는 모르니까 알려주자 
//      @Value("${spring.datasource.url}") String url,
//      @Value("${spring.datasource.username}")String username,
//      @Value("${spring.datasource.password}") String password
//      ) {
//
//
//
//    try {
//      DriverManagerDataSource connectionPool = new DriverManagerDataSource(); // 트라이 캐치 등의 조건문을 클래스안에 둘 수 없음 , 블록안에서는 가능 , 매번연결하지않으므로 속도 빨라짐
//      connectionPool.setDriverClassName(driverClassName);
//      connectionPool.setUrl(url);
//      connectionPool.setUsername(username);
//      connectionPool.setPassword(password);
//      // 소스 코드안에 정보가 들어있으면 나중에 정보가 바꾸면 매번 바꾸어 컴파일해서 다시 패킹해야하는 단점이 있음
//      //소스코드 안에 설정정보를 두면 불편 -> 스프링 부트의 경우에는 # application.properties에 둔다
//      return connectionPool;
//
//    }catch (Exception e) {
//      throw new RuntimeException(e);
//    }
//
//  }
//
//
//
//  public static void main(String[] args) {
//    SpringApplication.run(App.class, args);
//  }
//
//  //@Bean
//  public CommandLineRunner commandLineRunner(ApplicationContext beanContainer) {
//    return args -> {
//
//      System.out.println("빈 컨테이너가 생성한 객체(빈 컨테이너에 들어 있는 객체):");
//
//      String[] beanNames = beanContainer.getBeanDefinitionNames();
//      for (int i = 0; i < beanNames.length; i++) {
//        Object bean = beanContainer.getBean(beanNames[i]);
//        System.out.printf("----> %03d: %s\n", i + 1, bean.getClass().getName());
//      }
//
//    };
//  }
//
//  @RequestMapping("/hello")
//  String hello() {
//    return "Hello World!";
//  }
//
//}
