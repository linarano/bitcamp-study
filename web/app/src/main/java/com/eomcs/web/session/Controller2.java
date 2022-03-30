package com.eomcs.web.session;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

  //1) 세션을 사용하지않는 request handler
  @RequestMapping("/session/step1")
  public Object step1(String name, HttpSession session) {
    session.setAttribute("name", name);
    return "step1() 실행!";
  }


  //2) 세션을 사용하는 request handler
  // =>HttpSession 객체를 달라고 파라미터에 선언하라!
  //
  //세션 아이디를 요청했다고해서 주는게 아니라
  //세션을 사용하는  request handler
  @RequestMapping("/session/step2")
  public Object step2(int age, HttpSession session) {
    session.setAttribute("age", age); //인트값이 오토박싱되어서 저장 
    return "step2() 실행!";
  }

  //3) 세션을 사용하는 request handler
  // => 이미 세션이 생성된 후에 요청하면 기존 세션 객체를 그대로 사용한다.
  // => 세션이 없는 상태에서 요청하면 새 세션 객체를 만든다.
  // => 세션이 있지만 무효한상태일 경우 새세션 객체를 만든다.

  @RequestMapping("/session/step3")
  public Object step3(boolean working,HttpSession session) {
    session.setAttribute("working", working);
    return "stpe3() 실행!";
  }

  @RequestMapping("/session/step4")
  public Object step4(HttpSession session) {
    HashMap<String, Object> map= new HashMap<>();
    map.put("name",session.getAttribute("name"));
    map.put("age", session.getAttribute("age"));
    map.put("working", session.getAttribute("working"));
    //문자에서 값추출할려면 값을 구하기 위해서 다 잘라야함 - json 파싱하는게 힘들다  
    return map;// 해쉬맵 리턴 객체가 json형식으로 감 - 스프링부트가 자동으로 해준다 
  }

}

//요청이 달라도 같은 세션을 사용하므로 기존에   HttpSession에 키와 밸류값을 저장한다 