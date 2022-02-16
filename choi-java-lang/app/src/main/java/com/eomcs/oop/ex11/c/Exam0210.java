// inner class : 바깥 클래스의 스태틱 멤버에 접근하기
package com.eomcs.oop.ex11.c;

class B {
  // 클래스 멤버
  static int v1 = 10; //1)
  static void m1() {} //2)

  class X { //3)
    void test() {
      // 바깥 클래스든 패키지 멤버 클래스든 스태틱 멤버를 사용할 때는 
      // 다음과 같이 클래스 이름으로 해당 멤버를 사용한다.
      System.out.println(B.v1);
      B.m1();// 생략가능하나 명확이게 명확 -> 선배들은 많이 샹락 
      System.out.println("-------------------------");

      // 그런데 중첩 클래스에서 바깥 클래스의 스태틱 멤버에 접근할 때는 
      // 바깥 클래스 이름을 생략할 수 있어 편하다.
      // 왜? 
      // - 중첩 클래스도 바깥 클래스의 멤버이기 때문에
      //   (즉 X 도 v1, m1() 처럼 B 클래스의 멤버이다)
      //   같은 멤버에 접근할 때는 클래스 명을 생략할 수 있다.
      System.out.println(v1); 
      m1(); 
      System.out.println("-------------------------");
    }
  }
}

public class Exam0210 {

  public static void main(String[] args) {
    B outer = new B();
    B.X obj = outer.new X();

    obj.test();
  }

}

// X찾아보고, 상속클래스찾아보고 , 없으면 바깥 클래스를 찾는 방식 