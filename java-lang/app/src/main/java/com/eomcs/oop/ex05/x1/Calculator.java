package com.eomcs.oop.ex05.x1;

public class Calculator {
  public int result; //공개 해야 다른 패키지에서 사용가능

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  } 

  //com.eomcs.oop.ex05.x1.test2.Calculator에서 사용할 기능을  기존 코드에 추가한다.
  //  public void multiple(int value) {
  //    this.result *= value;
  //}
  //
}
