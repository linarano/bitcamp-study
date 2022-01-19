package com.eomcs.oop.ex05.x2;

//캠핑카 만들기
//
//1) 기존 코드에 기능 덧붙이기
//
public class CarTest3 {

  public static void main(String[] args) {
    // Engine 클래스에 시동걸고 끄는 기능을 추가한다.
    // => start(), stop() 메서드 추가
    // => run() 메서드 변경

    CampingTrailer trailer = new CampingTrailer();

    Engine car = new Engine();
    car.setTrailer(trailer);//트레일러 객체준다.
    car.start();
    car.run();
    car.stop();

  }

}


//트럭과 캠핑카 번갈아 
// 기존코드를 변경해야되는 상황이 반드시 온다. (코드추가뿐만 아니라 )
//단순 변수와 메서드 추가뿐만 아니라 기존코드를 손댈수밖에 없다. 이 작은 코드를 짜는데도 이런상황 RUNF()