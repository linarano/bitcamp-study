package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.MemberService;;

@RestController
public class MemberController {

  @Autowired
  MemberService memberService;

  @RequestMapping("/member/signup")
  public Object signUp(Member member) {
    if( memberService.add(member) ==1) {
      return "success";
    }else {
      return "fail";
    }
  }

  @RequestMapping("/member/signin")
  public Object signIn(String email, String password, HttpSession session) { //계속 정보를 가질 수있도록 
    Member loginUser = memberService.get(email,password); //사용자정보를 달라고하자 
    if(loginUser==null) { //json 일반문자열로 보내면 안돼 ,널도 보내면 안됨 
      return "fail"; 
    }
    // 로그인이 성공하면,
    // 다른 요청을 처리할 때 로그인 회원의 정보를 사용할 수 있도록 세션에 보관한다.
    session.setAttribute("loginUser", loginUser);
    return "success";
  }

  //단순히 결과를 넘기는게 아니라 조직적으로 
  // 기본생성자는 직관적이지 못함 

  @RequestMapping("/member/getLoginUser")
  public Object signUp(HttpSession session) {
    Object member = session.getAttribute("loginUser");
    if(member != null) {
      //return new ResultMap("success",data);
      return new ResultMap()
          .setStatus(SUCCESS) //문자열은 오타날 가능성이높다
          .setData(member); //위의방식과 비교해 한눈에 알아보기 쉽다
    }else {
      return new ResultMap()
          .setStatus(FAIL)
          .setData("로그인하지 않았습니다");
    }
  }
  //제이슨은 겟.셋메서드만 메서드로 인정 

  @RequestMapping("/member/signout")
  public Object signIn( HttpSession session) { //계속 정보를 가질 수있도록 
    session.invalidate();
    return new ResultMap().setStatus(SUCCESS);
  }



}
