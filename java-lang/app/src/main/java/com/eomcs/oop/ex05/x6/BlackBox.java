package com.eomcs.oop.ex05.x6;

public class BlackBox extends Option {

  public  BlackBox(Car car) { // 데코레이터이므로 자기스스로작업 못하므로 생성자에 차객체를 받아야함
    //옵션 클래스가 반드시 카달라고 요구하므로 그대로 슈퍼클래스에 전달.
    super(car); // 인스턴스필드에 저장 
  }

  @Override
  public void run() { // 주기능에 옵션을 붙이자. 
    car.run();// 원래 자동차가 하는일 호출 - 옵션에서 안만들었으니 , 직접구현해야함. 

  }

  @Override // 오버라이딩할때 자기가 갖고있는걸쓰는게 아니라. 블랙박스도 자기스탑이 있을것. 상속받았으니까. 악세사리이므로
  //자기것은 아무의미없음, 주객체의 기능의 의미있는것. 데코레이터는 절대 자기것을 쓰면 안된다. 
  public void start() {
    //car.start();
    super.start(); //오버라이딩 전 슈퍼클래스 - 옵션에서 되어있으므로, 
    System.out.println("녹화가 시작된다!");
  }

  @Override
  public void stop() {
    // TODO Auto-generated method stub
    super.stop(); // 순서 - 시동걸고끄고 
    System.out.println("녹화종료");
  }

}
// 특정 주기능에 run() 그 기능에 대해 옵션을 주고싶다. => 기능을 붙였다뗐다가 쉬움 
//달리가 멈추면 녹화가 꺼진다. 