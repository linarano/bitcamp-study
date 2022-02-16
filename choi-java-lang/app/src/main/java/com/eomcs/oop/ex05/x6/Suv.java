package com.eomcs.oop.ex05.x6;

public class Suv extends Car {
  boolean enabled4wd;

  @Override
  public void run() {
    if(enabled4wd) {
      System.out.println("부아아아아앙 난 힘이좋은 suv");
    }else {
      System.out.println("그냥달리자");
    }
  }

  public void active4wd(boolean enable) {
    this.enabled4wd = enable;
  }
}

// 신규프로젝트이므로 과거에 얽매이는 트럭과는 달라.
// 상태값 변경이 먼저, 그리고 run이 실행되야함. 

//기존객체이 기능을 붙였다뗐다하고 싶다 - > option
//단 데코레이터 객체는 주객체와 ㄸ고같은 조상을 가져야한ㄷ.
//그래야 붙여야하기ㄸ#ㅐ문에 얘네들을 포함할 수 있도록, CAR 포함 