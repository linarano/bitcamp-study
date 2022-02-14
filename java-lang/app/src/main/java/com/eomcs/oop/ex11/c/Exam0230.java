// inner class : 바깥 클래스의 인스턴스 멤버 접근하기 II
package com.eomcs.oop.ex11.c;

class B3 {

  // 인스턴스 멤버
  int v1 = 10;

  class X {
    int v1 = 100;

    void test() {
      // this 생략 -> 여기에 호출한 객체의 주소가 담긴다.
      int v1 = 1000;

      System.out.printf("v1 = %d\n", v1); // 로컬 변수 -> 따로 지정하지않으면 가장 가까운 곳에 찾는다. 
      System.out.printf("this.v1 = %d\n", this.v1); // 인스턴스 변수 
      System.out.printf("B3.this.v1 = %d\n", B3.this.v1); // 바깥 객체의 인스턴스 변수  // B3.this 바깥객체
    }
  }
}

public class Exam0230 {

  public static void main(String[] args) {

    //같은 아우터 객체를 참조한다.
    B3 outer = new B3();
    outer.v1 = 11;

    B3.X x1 = outer.new X();
    x1.test();
    System.out.println("--------------------");

    B3.X x2 = outer.new X();
    x2.test();
    System.out.println("--------------------"); 

    // 새롭게 다른 객체를 생성 함. - 바깥 객체의 주소가 달라졌다는 의미임 
    B3 outer2 = new B3(); 
    outer2.v1 = 22;

    B3.X x3 = outer2.new X();
    x3.test();
    System.out.println("--------------------");
  }

}

//이너클래스의 객체
//기본 
//인스턴스를 생성하면
//인스턴스의 클래스정보와 인스턴스 필드만 존재함 (힙)

//클래스의 메서드, 클래스의 중첩클래스정보 없음  없음 -> 메서드아레아 (클래스코드) 
//중첩클래스의 인스턴스는 + 바깥클래스의 주소가 들어있음 
