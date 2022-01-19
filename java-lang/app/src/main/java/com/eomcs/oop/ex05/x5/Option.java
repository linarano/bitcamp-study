package com.eomcs.oop.ex05.x5;

public abstract class Option extends Car { // 중간공통점
  Car car;

  public Option(Car car) {
    this.car = car;
  }
}
// 옵션은 자동차에 붙이는 것.
//옵션을 상속받은 클래스는 다 
//어느 자동차에 붙일 껀지 생성자에 자동차 주소를 받아야함



//그후 트레일러옵션만듬