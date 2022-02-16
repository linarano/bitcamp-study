package com.eomcs.oop.ex05.x6;

public class CarTest2 {
  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    testCar(sedan);

    System.out.println("-------------------");

    Truck truck = new Truck();
    testCar(truck);


    Suv suv = new Suv();
    suv.active4wd(true); //상태값 변경하고 run 실행
    testCar(suv); // 프로그래밍은 항상 이런저런 조건(상황을) 줘야한다. 
  } 

  static void testCar(Car car) { //뜯어고칠필요 없음 다형적 변수의 특장 
    car.start();
    car.run();
    car.stop();
  }
}

//  static void testTruck(Truck car) {
//    car.launch();
//    car.go();
//    car.stopping();
// 1)트럭을바꿔버리멘 에러가 뜬다. 트럭메서드를 썼던 
// 다형성변수로 받는다. 

// 기존에 cartest2에러 