package com.eomcs.oop.ex02;

public class ExamTest2 {

  public class Calculator {

    static int result = 0;

    static void plus(int a) {
      result += a;
    }

    static void minus(int b) {
      result -= b;
    }
    static void multiple(int b) {
      result *=b;
    }

    static void divide(int b) {
      result /= b;
    }

  }


  public static void main(String[] args) { 

    Calculator.plus(2);
    Calculator.plus(3);
    Calculator.minus(1);
    Calculator.multiple(7);
    Calculator.divide(3);

    System.out.printf("result = %d\n", Calculator.result);
  }

}



