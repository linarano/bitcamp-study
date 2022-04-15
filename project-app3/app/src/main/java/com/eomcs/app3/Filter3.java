package com.eomcs.app3;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//서블릿 실행 전/후에 수행할 작업이 있다면 필터에서 처리

@WebFilter({"/hello3","/hello5"}) // 어떤 요청에 대해 필터를 적용할 것인지 지정 - 모든 요청 * 
public class Filter3 implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("Hello12FIlter.init()");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    System.out.println("Hello2doFilter()");
    HttpServletRequest httpRequest = (HttpServletRequest) request; // 원래한정해서 만든것은 아니었지만 서블릿은 지금 주로 웹에서 쓰게되므로 원래는 더 범용적으로 쓰라고 만든 기술 
    System.out.println(httpRequest.getServletPath()); // 우리가 지금 http프로토컬을 다루고 있기 때문에 원래 넘어온 객체가 httpServletRequest가 맞으므로 형변환 가능, 아닌걸 형변환할 수 없음

    //다음 필터 실행 없으면 서블릿 실행
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    System.out.println("Hello2destroy()");
  }


}
