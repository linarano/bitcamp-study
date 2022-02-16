// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;


public class Exam0510x {

  // 기존 코드 재사용하고 싶다. -> 간단하게  // 기존코드 복사를 그대로 하면 에러 발생시 모두 수정봐야하고, 종속성이 높다 그에 맞게 다 바꿔 줘야한다. 
  static class MyCalculator {
    public static int plus(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
  }

  interface Calculator {
    int compute(int x, int y);
  }

  public static void main(String[] args) {

    //1) 로컬클래스 공부 !!

  }
}


//항상 오와 열을 맞추기 - 눈코딩하지말기 
// 무조건 코딩을 해야지 실력이 는다 => 프로젝트를 해야하므로 코딩을 해야하니까  실력이 는다.
//계속 쳐야되