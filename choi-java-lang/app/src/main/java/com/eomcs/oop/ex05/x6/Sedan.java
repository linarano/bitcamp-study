package com.eomcs.oop.ex05.x6;

public class Sedan extends Car {

  boolean auto;
  boolean opendSunroof; // 그 상태를 저장할 인스턴스 변수 필요

  @Override // 컴팡리러에게 검사요구 
  public void run( ) {
    System.out.println("쌩쌩 달리는중!");
  }

  public void openSunroof( ) {
    System.out.println("달리는중!");
    this.opendSunroof = true;
  }

  public void closeSunroof( ) {
    System.out.println("달리는중!");
    this.opendSunroof = false;// 현상관리 - 막상 만들다보면 설계도면에 없는 기능 추가할 수 있음. 만들고 설계도에 추가하면됨
  }

}

// 문법을 암기하면 뭐하나
//단순한 문법을 프로그래밍 하는데 겁내지말기.
//50일 남음. 
//이제얼마안남음 