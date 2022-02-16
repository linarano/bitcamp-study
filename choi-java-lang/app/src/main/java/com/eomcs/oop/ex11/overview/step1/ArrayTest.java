package com.eomcs.oop.ex11.overview.step1;

import java.util.ArrayList;

public class ArrayTest {

  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);

    System.out.println(list.size());
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
      if (i == 3) {
        list.remove(3);
      }
    }
  }

}


