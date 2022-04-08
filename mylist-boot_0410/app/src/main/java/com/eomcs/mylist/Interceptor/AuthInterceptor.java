package com.eomcs.mylist.Interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eomcs.mylist.conf.MvcConfiguration;
import com.eomcs.mylist.controller.ResultMap;
import com.eomcs.mylist.domain.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

//Auth - 사용자인증여부 검사(권한 등 )
public class AuthInterceptor implements HandlerInterceptor {

  private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class); //클래스 패키지로 묶을꺼냐 - 패키지별로 모드를 쓴다. 
  // private static final Logger2 log = LogManager.getLogger(AuthInterceptor.class);// 이름
  //스프링부트셋팅에 관련된것만 

  //클래스와 상관없이 같은 이름으로 묶음 

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    log.trace("preHandle 호출()");

    HttpSession session= request.getSession();
    Member loginUser = (Member)session.getAttribute("loginUser");
    if(loginUser == null) {
      //로그인을 하지않았으면 오류 메시지를 JSON  형식으로 직접응답한다. 

      String json = new ObjectMapper().writeValueAsString(new ResultMap().setStatus(ResultMap.FAIL).setData("로그인하지않았습니다!");
      response.setContentType("application/json:charset=UTF-8");
      PrinWriter out = response.getWriter();
      out.write(json);
      return false;// 페이지 컨트럴러를 실행하지말고 즉시응답하라 
    }
    // return HandlerInterceptor.super.preHandle(request, response, handler);
    return true; //로그인 된 상태라면 계속진행하라! (요청한 페이지 컨트롤러의 메서드를 호출하라 )
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    log.trace("postHandle 호출()");
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  } 



}
