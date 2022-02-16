// 인터페이스 - 기본 메서드(default method)
package com.eomcs.oop.ex09.b;

interface MyInterface3 {
  int a =100;//PUBLIC STATIC FINAL
  void m1();//퍼블릭오브스트랙트

  // default method:
  // - 기존 프로젝트에 영향을 끼치지 않으면서 기존 규칙에
  //   새 메서드를 추가할 때 유용한다.
  // - 인터페이스에서 미리 구현한 메서드이기 때문에 *****
  //   클래스에서 구현을 생략할 수 있다.
  // - 반대로 구현을 강제할 수 없다는 것이 단점이다.*****(추상메서드가 아니므로 강요할 수 없다)- 문제점! : 아무때나 쓰면 안됨 / 인터페이스는 추상메서드 
  default void m2() {//퍼블릭
    System.out.println("MyInterface3.m2()");
    // 어차피 새 메서드는 새 프로젝트의 구현체가 오버라이딩 할 것이니
    // 여기에서는 자세하게 정의하지 않는다.
    // 다만 이 인터페이스를 구현한 예전 프로젝트에 영향을 끼치지 않으면서
    // 새 메서드를 정의할 때 사용하는 문법이다.
  };

  default void m3() {
    System.out.println("MyInterface3.m3()");
  };
}

// 2) 인터페이스 구현
class MyInterface3Impl implements MyInterface3 { // 클래스이름 주목!!! 접미사로 사용 인터페이스의 구현체 인터페이스이름+인터페이스약자

  // 추상 메서드는 반드시 구현해야 한다.
  @Override
  public void m1() {
    System.out.println("MyInterfaceImpl.m1()");
  }

  // default 메서드는 오버라이딩 해도 되고 안해도 된다.
  @Override
  public void m2() {
    System.out.println("MyInterfaceImpl.m2()");
  }

  // default 메서드는 오버라이딩 해도 되고 안해도 된다. (메서드 구현을 강제하지못함 - 규칙을 따르지말라니 무슨뜻이야 힘이 약한것 강제성이 없는 것, 너무느슨함 )
  // => m3() 는 이 클래스에서 오버라이딩을 하지 않았다. (이미만들었으므로 안만들어도됨 구현)
}

public class Exam03 {

  public static void main(String[] args) {
    MyInterface3 obj = new MyInterface3Impl();

    obj.m1();
    obj.m2();
    obj.m3();
  }

}
//스태틱필드 - 인스턴스 주소를 주더라도 인스턴스가 아니면 클래스에서 찾는다. 
//이태릭체

//자바스크립트 상수, 자바의 상수