package com.eomcs.oop.ex05.x5;

public class CarTest3 {
  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    Trailer trailer = new Trailer(sedan); // 트레일러는 붙여쓰는 옵션이므로 세단에 붙인다. 세단을 생성자에 넣어야한다. 반드시
    ElectricEngine electricOption = new ElectricEngine(trailer);
    //);

    trailer.start();
    trailer.stop();
    trailer.run();

    System.out.println("---------------");
    Truck truck = new Truck();
    Trailer trailer2 = new Trailer(truck);
    trailer2.start();
    trailer2.stop();
    trailer2.run();

  }
}


// 옵션을 붙일 때도  순서가 있다. 
//세단에 먼저 엔진을 붙여야한다.ㅣ
//옵션에 따른 순서가 있다.
//세단에 -엔진-트레일러 
//전기자동차이면서 트레일러 자동차 
//엔진이필요가 가 필요없으면 바로 연결하면 됨. 