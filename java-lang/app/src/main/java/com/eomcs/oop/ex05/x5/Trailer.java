package com.eomcs.oop.ex05.x5;

import javax.swing.plaf.synth.SynthRootPaneUI;

public class Trailer extends Option {

  public Trailer(Car car) {
    super(car);
  }

  CampingTrailer trailer;

  public void setTrailer(CampingTrailer trailer) {
    this.trailer= trailer;
  }
  // 옵션이므로 시동기능없음
  // 원래 가에 있는 스타트가 호출되야 함
  @Override
  public void start() {
    car.start(); 
    sysout("덜덜덜 트레일러가 따라간다.")
  }
  @Override
  public void stop() {
    car.stop(); //포함하고 있는 실제 카 객체에게 달리라고 해야지. 기능을 덧붙일순없지 껍데기니까 
    sysout("덜덜덜 트레일러가 따라간다.")
  }
  @Override
  public void run() {
    car.run(); // 생성자한테 위임.
    sysout("덜덜덜 트레일러가 따라간다.")
  }
