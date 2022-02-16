package com.eomcs.oop.ex05.x7;

public class CarTest1 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    testSedan(sedan);

    System.out.println("-----------------------");

    Truck truck = new Truck();
    testTruck(truck);


  }

  // 메서드 호출시 값을 파라미터로 넘기도록 설계했기 때문에 값을 넣어줘야함.
  static void testSedan(Sedan sedan) {
    sedan.start();
    sedan.openSunroof(true);
    sedan.stop();
    sedan.run();
  }

  static void testTruck(Truck truck) {
    truck.launch();
    truck.stopping();
    truck.dump();
  }


}
