package com.eomcs.oop.ex05.x3.app1;

//자동차 만들기 
// 1) 기존 코드를 복사해온 후 기능 덧붙이기 

public class CarTest1 {

  public static void main(String[] args) {
    //Engine 클래스에 시동걸꼬 끄는 기능을 추가한다. 
    // => start(), stop() 메서드 추가

    Engine car = new Engine();
    car.start();
    car.run();
    car.stop();

  }

}
