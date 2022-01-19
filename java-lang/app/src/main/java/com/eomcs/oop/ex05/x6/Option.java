package com.eomcs.oop.ex05.x6;

public abstract class Option extends Car {//  서브클래스에게 상속하는 용도
  Car car; // 레퍼런스 변수 
  //여기서만드는게 아니라 바깥에서 생성해서 가져와 생성자

  //붙여써야 의미있는것, 옵션은 붙어야의미가 있다. 체인이 차업이 필요?
  public Option(Car car) {
    this.car = car; // 어느 자동차에 붙일것인가.
  }
  // 옵션에서부터 물러주면 된다. 
  @Override
  public void start() {
    //   데코레이터는 자동차가 아니다. 
    // 따라서 시동이 걸라고 요청이 들어오면
    //실제 자동차 객체에게 위임해야한다.   데코레이터를 붙인 자동차에게 위임해야하나.ㄷ 
    car.start();
  }

  @Override
  public void stop() {
    car.stop(); // 실제자동차에게 위임 
  }

}
// 프로그래밍은 경험치가 있어야 실력이 는다.