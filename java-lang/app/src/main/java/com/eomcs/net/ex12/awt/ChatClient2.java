package com.eomcs.net.ex12.awt;

import java.awt.Frame;


@SuppressWarnings("serial")
public class ChatClient2 extends Frame {

  public  ChatClient2() {
    super("채팅");


    this.addWindowListener(new myWindowListener());
    // 인터페이스와 상속?????? 기억이 안남 
    //addWindowListener(WindowLister l)

  }

  public static void main(String[] args) {
    new ChatClient2(); 
  }

}
