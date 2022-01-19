package com.eomcs.oop.ex05.x5;

public class CarTest2 {
  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    Trailer trailer = new Trailer(sedan); // 트레일러는 붙여쓰는 옵션이므로 세단에 붙인다. 세단을 생성자에 넣어야한다. 반드시
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

//트레일러 기능이 추가된 트럭이 되었다. 
