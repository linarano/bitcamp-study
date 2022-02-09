package com.eomcs.net.ex12.awt;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 활성화된게 키보드이벤트를 받음 
//deafualt 문밥이 등장하기 전에 만든 인터페이스라서 추상클래스가 등장 디폴트 쓸 수 없음 
//관심있는 메서드만 상속받을 수 있게 도미 

public class MyWindowListener implements WindowListener {

  @Override
  public void windowIconified(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeiconified(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowActivated(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeactivated(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowOpened(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowClosing(WindowEvent e) {
    System.exit(0);

  }

  @Override
  public void windowClosed(WindowEvent e) {
    // TODO Auto-generated method stub

  }} 