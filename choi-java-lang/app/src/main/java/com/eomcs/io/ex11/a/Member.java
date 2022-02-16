package com.eomcs.io.ex11.a;

public class Member {
  String name;
  int age;
  boolean gender; // true(여자), false(남자)

  @Override
  public String toString() {
    return "Member [name=" + this.name + ", age=" + age + ", gender=" + gender + "]";
  }
}

//this.생략가능 - 컴파일러가 자동으로 붙임 
//자바스크립트는 디스생략하면 안됨 (컴파일방식이 아니므로 ) - 05분 