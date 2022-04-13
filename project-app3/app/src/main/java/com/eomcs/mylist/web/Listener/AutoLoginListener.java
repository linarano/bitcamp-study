package com.eomcs.mylist.web.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.eomcs.mylist.domain.Member;

// 역할:
// - HttpSession 객체를 생성할 때, 기능 테스트를 위해 자동으로 로그인 시킨다.
//
@WebListener
public class AutoLoginListener implements HttpSessionListener { //환경을 초기화
  @Override
  public void sessionCreated(HttpSessionEvent se) { //   리스너활용 - 세션이 만들어질때 이 메서드 호출된다.
    //실무에서 많이 씀, 미리 담아두는 것 - 리스너 문법이 어떻게 활용되는지 봐라 
    //세션이 생성될때마다 이 메서드가 호출되니까 , 뭔가 준비하고 싶으면 리스너에서 그작업을 하면된다. 

    //자바스크립트가 아니면 삭제할 방법이 없다.
    System.out.println("호출됨");
    Member loginUser = new Member();
    loginUser.setNo(2);
    loginUser.setName("user2");

    HttpSession session = se.getSession();
    session.setAttribute("loginUser", loginUser);
  }
}
