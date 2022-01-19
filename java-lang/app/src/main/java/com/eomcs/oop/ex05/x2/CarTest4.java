package com.eomcs.oop.ex05.x2;

public class CarTest4 {

  public static void main(String[] args) {

    Engine car = new Engine();

    car.chargeBattery(100);
    car.start();
    car.run(); 
    car.stop();

  }

}


//트럭과 캠핑카 번갈아 
// 기존코드를 변경해야되는 상황이 반드시 온다. (코드추가뿐만 아니라 )
//단순 변수와 메서드 추가뿐만 아니라 기존코드를 손댈수밖에 없다. 이 작은 코드를 짜는데도 이런상황 RUNF()