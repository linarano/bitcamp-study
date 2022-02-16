package com.eomcs.oop.ex06.b;

// 오버로딩 규칙 정리!
//
public class C {

  public void m1() {}

  // 메서드를 찾을 때 이름과 파라미터 타입, 개수로 구분하기 때문에***: 같은이름의 메서드가 추가적재되었다.
  // 리턴 타입이 다른 것은 구분할 수 없다.
  //  public int m1() {return 0;} // 컴파일 오류! - 파라미터가 달라야함. 리턴타입과 상관없음


  // => 파라미터 타입이 달라야 한다.
  public void m1(float a) {} // OK
  public void m1(byte a) {} // OK
  public int m1(short a) {return 0;} // OK
  public String m1(long a) {return null;} // OK

  // => 파라미터 개수가 달라야 한다.
  public float m1(float a, float b) {return 0f;} // OK
  public void m1(short a, String b) {} // OK

  // => 파라미터 이름이 다른 것으로는 메서드를 구분할 수 없다.
  //  public void m1(float f) {} // 컴파일 오류! - 무엇을 호출해야할지 모르므로

  // => 접근 범위는 오버로딩과 상관없다.
  void m1(float a, int b) {} // OK
  private void m1(float a, int b, int c) {} // OK
  protected void m1(float a, int b, int c, String d) {} // OK
}


//참고 
//파라미터가 다르더라도 c 언어는 오버로딩이 불가. test 참고
// 그래서 c++ 에서 오버로딩 등장 , namespace등장(패키지와 동일- 자바에서 패키지라고 부름) - 원래 표준용어  프로그래밍 언어 세계에서 XML 메서드나 코드들을 그룹으로 묶을 때 NAMESPACE
// 같은 일을 하는 메서드인데 같은 이름으로 못만드냐는 목적
//리눅스커널- c : 패키지개념없고, 메서드동일하게 못정의 , 그래서 함수이름 앞에 접두사를 붙임(다른 사람의 짠 코드와 겹치지않게  - 패키지가없으므로 ) :eom-plus