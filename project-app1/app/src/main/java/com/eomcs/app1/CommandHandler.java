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
}

// 다 스태틱임으로 인스턴스를 못만듬 여러개못만듬
//지금 당장은 더 큰 이점이 없지만, 인스턴스필드도없지만 
//향후 인스턴스만들지 모른다. 
//대부분 개발자들이 인스턴스메서드로 만든다. 나중을 위해서
//나중의 확장성때문에 
// 지금은 키보드에서 입력받지않고,
//파일도 아니지만 ,네트워킹 등

//대부분의 개발자들이 인스턴스메서드로 쓴다.
//메서드를 분류하는 용도로 클래스를 적는다.