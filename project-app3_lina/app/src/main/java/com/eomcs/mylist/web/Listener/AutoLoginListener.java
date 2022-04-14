package com.eomcs.mylist.web.Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.eomcs.mylist.domain.Member;

// 역할:
// - 요청이 들어올 때, 기능 테스트를 위해 자동으로 로그인 시킨다.
//
@WebListener
public class AutoLoginListener implements ServletRequestListener { //환경을 초기화
  @Override
  public void requestInitialized(ServletRequestEvent sre) { //   리스너활용 - 요청이 들어올때마다 호출되도록 변경
    //실무에서 많이 씀, 미리 담아두는 것 - 리스너 문법이 어떻게 활용되는지 봐라 
    //요청이될때마다 이 메서드가 호출되니까 , 뭔가 준비하고 싶으면 리스너에서 그작업을 하면된다. 

    //자바스크립트가 아니면 삭제할 방법이 없다.
    System.out.println("호출됨");
    Member loginUser = new Member();
    loginUser.setNo(2);
    loginUser.setName("user2");

    HttpServletRequest httpRequest = (HttpServletRequest) sre.getServletRequest();
    HttpSession session = httpRequest.getSession();
    session.setAttribute("loginUser", loginUser);
  }
}
