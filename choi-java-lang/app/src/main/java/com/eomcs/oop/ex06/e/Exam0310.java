// final 사용법: 상수 필드 만들기
package com.eomcs.oop.ex06.e;

class C {
  // 필드에 final 을 붙이면 상수 필드가 된다.
  // 생성자에서 초기화시켜야 한다.
  //
  final int v1; // 상수생성이 복잡하지않으면 변수초기화에서 해버려라.  어차피 컴파일해서 들어갈것이니까 

  public C() {
    v1 = 100;
  }

  public void m1() {
    // 상수 필드는 값을 변경할 수 없다.
    //    v1 = 200; // 컴파일 오류! 값을 바꿔선느 안되는 필드란의미
  }
}


public final class Exam0310 {
  public static void main(String[] args) {
    C c = new C();
    System.out.println(c.v1);
  }
}
