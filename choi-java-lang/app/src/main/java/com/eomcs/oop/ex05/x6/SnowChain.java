package com.eomcs.oop.ex05.x6;

public class SnowChain extends Option { //카를 상속받은 옵션이라는 클래스를 상속받는다. 
  //디폴트 슈퍼클래스 없다. 기본생성자없다. 옵션은 오로지 카객체 받는 생성자만 있음
  //그래서 생성자 준비

  public SnowChain(Car car) {
    //옵션 클래스가 반드시 카달라고 요구하므로 그대로 슈퍼클래스에 전달.
    super(car);
  }
  @Override
  public void run() {
    System.out.println("도로마찰력을 증가시킨다. !");
    car.run();// 원래 자동차가 하는일 호출 
  }
}
//무조건 위임 
//  @Override
//  public void start() {
//    //   데코레이터는 자동차가 아니다. 
//    //시동이 걸라고 요청이 들어오면
//    //    데코레이터를 붙인 자동차에게 위임해야하나.ㄷ 
//    car.start();
//  }
//
//  @Override
//  public void stop() {
//    car.stop();
//  }


// 자기껍데기를 버리는 작업을 해야함. 휴대폰과 휴대폰껍데기 
//번거롭다 잘라라. 옵셩에서 아예 상속해보자  
