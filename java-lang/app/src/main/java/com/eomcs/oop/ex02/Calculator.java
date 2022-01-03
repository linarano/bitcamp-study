package com.eomcs.oop.ex02;

class Calculator {

  int result = 0; //인스턴스변수 사용하려면, 인스턴스변수의 주소를 받는 this 필요 

  void plus(int value) {
    this.result += value;
  }

  void minus(int value) {
    this.result -= value;
  }

  void multiple(int value) {
    this.result *= value;
  }

  void divide(int value) {
    this.result /= value;
  }

  // 메소드를 만들어놓고, static을 붙일까말까 고민 - 인스턴스를 사용하지 않는 메서드라면 그냥 클래스 메서드로 두어라.(인스턴스에 들어있는 변수를 사용하지않으면, 주소필요없다)
  static int abs(int a) {
    return a >= 0 ? a : a * -1;
  }
}
