// final 사용법: 상수 필드 만들기
package com.eomcs.oop.ex06.e;

class F {
  // 상수 필드는 인스턴스 마다 개별적으로 관리하지 않기 때문에 - 들어간 값은 동일!! 따라서 쓸데없이 여러개 변수를 만들 필요없다. 
  // 보통 스태틱 필드(클래스 필드)로 만든다.** 1번만 만들면된다. 인스턴스생성할때마다 만들지말고
  // 공개할 경우 public 으로 선언한다. ** 공개선언한다.
  //
  public static final int v1 = 100; // 이 방법을 추천!

  // 스태틱 상수 필드는 스태틱 블록에서 초기화시킬 수 있다.
  public static final int v2;
  static {
    //    v1 = 100;
    v2 = 200;
  }

}

public final class Exam0340 {
  public static void main(String[] args) {
    System.out.println(F.v1);
    System.out.println(F.v2);
  }
}

//회사소스는 내 공부연습용이 아님