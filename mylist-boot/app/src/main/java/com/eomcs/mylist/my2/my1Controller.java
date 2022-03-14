package com.eomcs.mylist.my2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("my1.my1Controller")

public class my1Controller {

  String[] rookies = new String[5];
  int size = 0;

  @RequestMapping("/my1/list")
  public Object list() {
    String[] arr = new String[size];
    for(int i = 0; i <size ; i++) {
      arr[i] = rookies [i];
    }
    return arr;
  }

  @RequestMapping("/my1/add")
  public Object add(String name, String number, String position, String age, String team) {
    String rookie = name + "," + number + "," + position + "," + age + "," + team;
    rookies[size++] = rookie;
    return size;
  }




}