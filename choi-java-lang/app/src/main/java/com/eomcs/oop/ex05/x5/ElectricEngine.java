package com.eomcs.oop.ex05.x5;

public class ElectricEngine extends Option { // 옵션상속

  public  ElectricEngin(Car car) { // 생성자에 자동차 객제추소 받아야함 
    super(car); //내부변수에 저장 
  }


  //  전기자동차이므로 밧데리 충전기능붙임

  int kwh;
  public void chargeBattery (int kwh) {
    this.kwh = kwh;
  }

  // 옵션이므로 시동기능없음
  // 원래 가에 있는 스타트가 호출되야 함
  // 따라서 자동차에 위임해야함. 
  @Override
  public void start() {
    car.start(); 
  }

  @Override
  public void stop() {
    car.stop(); //포함하고 있는 실제 카 객체에게 달리라고 해야지. 기능을 덧붙일순없지 껍데기니까 
  }

  @Override
  public void run() {
    if (kwh > 0) {
      System.out.println("전기로 간다!");
    } else {
      car.run(); // 생성자한테 위임.
      //      옵션 자체는 실제 자동차가 아니다. 그래서 run()이 호출되면 실제 자동차 객체에게 위임한다
    }

  }
}