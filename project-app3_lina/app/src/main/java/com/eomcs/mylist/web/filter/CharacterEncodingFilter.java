package com.eomcs.mylist.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")//모든 요청에 대해서 실행
public class CharacterEncodingFilter implements Filter{

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    //equest.getM //클라이언트가 겟을 했는지 포스트를 했는지 - HTTp프로토콜 관련정보이므로 -> 원래모습으로 돌려야함

    //POST  요청의 경우
    //다음필터나 서블릿을 실행하기 전에 파라미터 값의 인코딩을 UTF-8로 지정한다.
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    if(httpRequest.getMethod().equals("POST")){
      httpRequest.setCharacterEncoding("UTF-8");
    }

    // 현재 필터 다음에 연결된 필터 또는 서블릿을 실행한다.
    // 만약 다음에 실행할 필터가 없다면 내부적으로 최종 목적지인 서블릿을 실행한다.
    chain.doFilter(request, response); // 다음 체인에 연결하는 역할 - 이걸호출안하면 서블릿호출안됨 반드시
  }
}
