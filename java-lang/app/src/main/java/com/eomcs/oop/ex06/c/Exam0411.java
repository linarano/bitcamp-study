// 오버라이딩(overriding) - 오버라이딩과 super 키워드
package com.eomcs.oop.ex06.c;

public class Exam0411 {

  static class A {
    void m() {
      System.out.println("A의 m()");
    }
  }

  static class A2 extends A {

    @Override
    void m() {
      System.out.println("A2의 m()");
    }


    void test() {
      // this 레퍼런스로 메서드를 호출하면,
      // => 현재 클래스(this의 실제 클래스, 예 A3)에서 메서드를 찾아 호출한다.
      // => 현재 클래스에 메서드가 없으면 수퍼 클래스에서 메서드를 찾는다.
      // => 메서드를 찾을 때까지 최상위 클래스까지 따라 올라간다.
      this.m();

      // super 레퍼런스로 메서드를 호출하면,
      // => 수퍼 클래스(메서드가 소속된 클래스의 수퍼클래스 예 A2 )에서 메서드를 찾아 호출한다.
      // => 수퍼 클래스에 없으면 그 상위 클래스로 따라 올라간다.
      // => 오버라이딩 하기 전의 메서드를 호출하고 싶을 때 유용하다.
      super.m();
    }
  }

  static class A3 extends A2 {
    @Override
    void m() {
      System.out.println("A3의 m()");
    } 
    //주석처리한경우 A2 m()
  }

  public static void main(String[] args) {
    A3 obj = new A3();
    obj.test(); //A2에서 상속받은 메서드 test()호출
  }
}

//서브클래스가 여러개일때 - 메서드의 위치 호출되는  기준이 명확해야됨 

//this가 현재 클래스에서 m()을 
//test메소드는 A2가 갖고있지만 this에는 실제타입인 A3의 주소가 들어있는 것.
// 메소드를 찾는 위치가 중요
//A3부터 찾는다.

//super는 "메서드가 소속된 클래스의 수퍼클래스(A)" ,A2 m()은 붕뜬다. 




