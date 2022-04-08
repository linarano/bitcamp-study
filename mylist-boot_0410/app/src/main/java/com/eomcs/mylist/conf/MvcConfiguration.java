package com.eomcs.mylist.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.eomcs.mylist.Interceptor.AuthInterceptor;

//@Configuration  //애노테이션의 용도
//=>다음 클래스는 설정에 관련된 일을 하는 클래스임을 선언
//=>스프링부트(스프링프레임워크)는 이 애노테이션이 붙은 클래스에 대해
// 관련 메서드를 호출하여 내부 설정에 반영한다. 

@Configuration 
public class MvcConfiguration implements WebMvcConfigurer {

  private static final Logger log = LoggerFactory.getLogger(MvcConfiguration.class);

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    log.debug("MvcConfiguration.addInterceptors()호출됨");

    registry.addInterceptor(new AuthInterceptor()) // 설정파일은 우리가 명시적으로 만들어줘야함 스프링부트가 아니라
    .addPathPatterns("/**/add", "/**/update*", "/**/delete*"); // 무조건 사용자인증여부 검사해라
    //인터셉터를 언제 끼워야되느냐 
  }
}
