// 제네릭(Generic) 문법 정리 - 레퍼런스와 인스턴스 생성 
package com.eomcs.generic.ex02;

import java.util.ArrayList;

public class Exam0213 {

  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  /*
   *   Object
   *     |
   *     A
   *    / \
   *   B1 B2
   *   |
   *   C
   */

  //클래스 하이라키
  public static void main(String[] args) {

    ArrayList<A> list1; //A타입을 다루는 배열의 주소를 받겠다는 선언

    //    list1 = new ArrayList(); // 다 된다는 의미이긴한데, 오류로 안잡기는 한데이렇게 객체를 생성하지 말고, 명확히 제네릭의 타입을 지정하라.
    //list1 = new ArrayList<Object>(); // 컴파일 오류! - 형식에 안맞아
    list1 = new ArrayList<A>();//레퍼런스와 같은 타입
    list1 = new ArrayList<>();//생략가능 - 레퍼런스와 같은 타입
    // list1 = new ArrayList<B1>(); // 컴파일 오류! // 범위를 축소했으므로 안됨
    //    list1 = new ArrayList<B2>(); // 컴파일 오류!
    //    list1 = new ArrayList<C>(); // 컴파일 오류!

    // A를 다룬다는 것은 그 자손까지 다 다룰려고 하는건데이렇게 쓰려고 상속관계를 만들었을 텐데 - 범위를 축소하면 안됨 
    list1.add(new A());
    list1.add(new B1());
    list1.add(new B2());
    list1.add(new C());

    ArrayList<B2> list2; //B2와 그 자손을 다루겠다고 제한한다는 의미

    // list2 = new ArrayList(); // 이렇게 사용하지 말고, 명확히 제네릭의 타입을 지정하라.
    //    list2 = new ArrayList<Object>(); // 컴파일 오류!
    list2 = new ArrayList<B2>(); //OK
    list2 = new ArrayList<>(); //B2를 생략한 문법이다. OK
    //list2 = new ArrayList<A>(); // 컴파일 오류!
    //list2 = new ArrayList<B1>(); // 컴파일 오류!
    //    list2 = new ArrayList<C>(); // 컴파일 오류!
  }
}








