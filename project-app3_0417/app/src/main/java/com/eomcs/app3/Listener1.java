package com.eomcs.app3;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

// 서블릿 컨테이너가 특정 상태에 놓일 때 수행할 작업이 있다면 리스너 클래스에 정의하라!
// 
@WebListener // 클라이언트의 요청이 들어오면 다음클래스를 실행하라고 서블릿 컨테이너에게 알려준다.
public class Listener1 implements ServletRequestListener{ // 요청, 응답 상태일 때
  @Override
  public void requestInitialized(ServletRequestEvent sre) { 
    // 요청이 들어오면 필터를 실행하기 전에 호출됨.
    System.out.println("Listener1.requestInitialized"); // 서블릿이 응답할때마다 무얼 하고싶으면 여기다 적응
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    // 응답을 완료할 때 필터 실행 후에 호출됨
    System.out.println("Listener1.equestDestroyed");
  }
}
