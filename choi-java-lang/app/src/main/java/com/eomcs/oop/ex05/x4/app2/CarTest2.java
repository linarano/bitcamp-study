package com.eomcs.oop.ex05.x4.app2;

//트럭 만들기
//
//1) 기존 코드에 상속
//
public class CarTest2 {

  public static void main(String[] args) {
    // Car 클래스를 상속 
    // => dump() 추가

    Truck car = new Truck();

    car.start();
    car.run();
    car.dump();
    car.stop();

  }

}
