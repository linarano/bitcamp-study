package com.eomcs.oop.ex05.x4.app5;

import com.eomcs.oop.ex05.x4.app3.TrailerCar;

public class HybridTrailerCar extends TrailerCar {

  int kwh;
  public void chargeBattery (int kwh) {
    this.kwh = kwh;
  }

  // 슈퍼클래스로부터 상속받은 run() 재정의
  // 오버라이딩 
  @Override
  public void run() {
    // 하이브리드 전기차 구동 기능 추가
    if(kwh >0) {
      System.out.println("전기로 간다!");
    } else {
      super.run();}
  }  
}
