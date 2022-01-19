package com.eomcs.oop.ex05.x1;

// 1) 계산기 객체를 이용하여 계산기 사용하기 
public class CalculatorTest {
  public static void main(String[] args) {
    Calculator c = new Calculator();

    c.plus(100);//인스턴스 메소드이므로 주소를 주고 호출 ,메소드 내장변수 this에 들어갈 주소 
    c.minus(200);
    System.out.println(c.result);
  }

}
