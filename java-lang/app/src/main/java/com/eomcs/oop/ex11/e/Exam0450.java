// anonymous class - 익명 클래스가 놓이는 장소: 파라미터
package com.eomcs.oop.ex11.e;


class my {
  static void m1(){
    System.out.println("오호라!!!!"); 
  }

  void m2(){
    System.out.println("와우!!!!"); 
  }

}



public class Exam0450 {


  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A {
    void print(); //리턴타입이 보이드고 리턴값이 없고, 파라미터가 없으므로 가능 -> 크리에이트 4 // 추상메서드가 1개인 인터페이스인 경우는 가능.  단1개 / 디폴트로 먼저 구현되어있는것은 카운트 안함 
  }

  static A create1() {
    class X implements A{

      @Override
      public void print() {
        System.out.println("Hello!");

      }

    }
    return new X();
  }


  static A create3() { //  에이인터페이스 구현한 구현체 
    return () -> System.out.println("Hello3!!");
  }

  static A create4() {
    return My::m1(); // 스태팃 메서드가능 
  }


  static A create5() {
    return  new My()::m2(); // 인스턴스 메서드는 주소를 객체 만들어서주소 줘야함 
  }

  ;

  //실무에선  2번째 방식을 쓴다. 
  public static void main(String[] args) {

    A obj1 = create1();
    obj1.print();

    A obj1 = create1();
    obj1.print();
  }
}

//메서드가 1개짜리 인터페이스인경우 -> 펑셔널 인터페이스 -> 람다문법으로 표현가능
//인터페이스를 구현 , 다만 람다, 익명클래스로 구현



//람다문법과 메서드레퍼런스는 오직 인터페이스ㄱ만가능 하다 