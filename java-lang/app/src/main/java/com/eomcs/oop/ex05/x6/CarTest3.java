package com.eomcs.oop.ex05.x6;

public class CarTest3 {
  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    SnowChain snowChain = new SnowChain(sedan); // 단독사용불가하므로 세단에 붙임다.
    testCar(snowChain);



    System.out.println("----------------------------");


    Truck truck  = new Truck();
    BlackBox blackBox = new BlackBox(truck); // 단독사용불가하므로 세단에 붙임다.
    testCar(blackBox);

    System.out.println("----------------------------");
    //
    //    //SUV 머드 븥ㅊ야리 
    //    Suv suv = new Suv();
    //    BlackBox blackBox2 = new BlackBox(suv);
    //    SnowChain snowChain2 = new SnowChain(blackBox2);
    //    testCar(snowChain2);

    //순서가 없다. - 블록체인이 달린 블랙박스 SUV 
    Suv suv = new Suv();
    SnowChain snowChainSuv = new SnowChain(suv);
    BlackBox blackBoxSuv = new BlackBox(snowChainSuv);
    testCar(blackBoxSuv);
  }

  static void testCar(Car car) { //뜯어고칠 필요 없음, 다형적 변수의 특장 
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

//인간이 말하는것처럼 자연스러운것 - 객체지향ㅎ프로그램

//기능을 무조건 포함이 아니라 자유롭께 뗐다 붙였다 하고 싶어서 설계 - 데코레이터 

//데코레이터 붙일 떄 순서 
//썬팅지. 뽁뽁이 - 순서가 필요한 기능이 있을떄 일상생활과 마찬가지로 
//3차원 안경 - 안경먼저끼고- 3차원안경끼고 거꾸로 쓰는 건없다. 순서지켜야된느게 이쏙, 순서가 바뀌어도 상관없는게 있따.
// 데코레이터 사용방법에 따라서 우리가 결정 
