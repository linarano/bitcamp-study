package com.eomcs.app1;

public class CommandHandler {

  void doHelp() {
    System.out.println("add   [값1] [값2]     더하기 계산을 수행한다.");
    System.out.println("minus [값1] [값2]     빼기 계산을 수행한다.");
    System.out.println("help                  도움말을 출력한다.");
  }

  void doAdd(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("add 명령어 입력 형식이 옳바르지 않습니다.");
      System.out.println("형식: add 값1 값2");
      System.out.println("예) add 100 200");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%d + %d = %d\n", v1, v2, (v1 + v2));
    }
  }

  void doMinus(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("minus 명령어 입력 형식이 옳바르지 않습니다.");
      System.out.println("형식: minus 값1 값2");
      System.out.println("예) minus 100 200");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%d - %d = %d\n", v1, v2, (v1 - v2));
    }
  }

  void doDivide(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("divide 명령어 입력 형식이 옳바르지 않습니다.");
      System.out.println("형식: divide 값1 값2");
      System.out.println("예) divide 100 200");
    } else {

      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%d / %d = %d\n", v1, v2, (v1 / v2));

      System.out.println("나누기 연산 중 오류 발생"); // 호출자에게 전달안됨 
    }
  }
}

//**** 어느지점에서 예외가 발생할지 판단. 개발자가 
// 예외를 잘못잡으면 예외가 또 발생 
//예외를 확인 

// 다른 더하기 메서드에서도 에러가 발생한다면?
// 또다른 방법을 쓰자. - 예외가 발생한지점에서 처리하지말자. 
// 전체의 부분에 대해서 에러를 잡을 수 있음. 

//예외가 발생할 만한 코드를 try 블록안에 
//int v1 = command.getInt(0);
//int v2 = command.getInt(1);
//System.out.printf("%d / %d = %d\n", v1, v2, (v1 / v2));
//
//// } catch (Exception e) { // 파라미터 타입 Exception - 예외를 잡는 블록
//// 예외에 대한 적절한 조치를 취하는 코드를 이 블록에 둔다. 
//System.out.println("나누기 연산 중 오류 발생"); // 호출자에게 전달안됨 
