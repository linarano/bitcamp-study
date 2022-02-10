package com.eomcs.net.ex12.awt;

import java.awt.Frame;


public class ChatClient2 extends Frame {

  private static final long serialVersionUID = 1L;

  public ChatClient2() {
    super("채팅");
    this.addWindowListener(new MyWindowListener());
  }

  public static void main(String[] args) {
    new ChatClient2(); 
  }

}
