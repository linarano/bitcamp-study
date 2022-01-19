package com.eomcs.oop.ex05.x4.app5;

import com.eomcs.oop.ex05.x4.app3.CampingTrailer;

public class TrailerTruck extends Truck  {
  CampingTrailer trailer;

  public void setTrailer(CampingTrailer trailer) {
    this.trailer  = trailer;
  }

  @Override
  public void run() {
    // 트레일러 장착 기능이 추가되었다면 다음과 같이 run() 메서드를 변경해야 한다.
    if (trailer == null) {
      super.run(); // 슈퍼클래스부터 따라올라가라- 재정의전으로 가라 
    }else {
      System.out.println("느릿느릿 조심히 움직인다.!");
    }
  }

}
