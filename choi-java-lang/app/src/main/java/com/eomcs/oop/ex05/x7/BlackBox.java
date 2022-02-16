package com.eomcs.oop.ex05.x7;

public class BlackBox extends Option {
  boolean cameraOn;

  BlackBox (boolean on) {
    this.cameraOn= on;
  }

  public void setBlackBox() {
    if (cameraOn) {
      System.out.println("블랙박스녹화를 시작했습니다. 안전운전하세요");
    }else {
      System.out.println("녹화가 종료되었습니다.");
    }
  }
}