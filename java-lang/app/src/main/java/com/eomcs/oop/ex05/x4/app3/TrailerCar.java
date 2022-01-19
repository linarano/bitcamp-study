package com.eomcs.oop.ex05.x4.app3;

import com.eomcs.oop.ex05.x4.app1.Car;

public class TrailerCar extends Car {

  CampingTrailer trailer;

  public void setTrailer(CampingTrailer trailer) {
    this.trailer  = trailer;
  }

  // 상속받은 run() : 사용권한을 갖고있음 
  //현재 클래스의 역할에 맞게끔 재정의 \
  // 오버라이딩
  @Override
  public void run() {
    // 트레일러 장착 기능이 추가되었다면 다음과 같이 run() 메서드를 변경해야 한다.
    if (trailer == null) {
      super.run(); // 슈퍼클래스부터 따라올라가라
    }else {
      System.out.println("느릿느릿 조심히 움직인다.!");
    }
  }
}
// 훨씬더 유연하고 쎄련됨 
