// final 사용법: 상수 필드 만들기
package com.eomcs.oop.ex06.e;

class E {
  // 인스턴스 초기화 블록에서 값을 초기화시켜도 된다.
  final int v1;

  // 인스턴스 초기화 블록의 코드 또한 생성자에 복사된다. => 생성자로 들어감 
  {
    v1 = 200; // OK!
    //    v1 = 300; // 컴파일 오류!
  }
}

//스태틱 초기화블록과 다른것
public final class Exam0330 {
  public static void main(String[] args) {
    E e = new E();
    System.out.println(e.v1);
  }
}
