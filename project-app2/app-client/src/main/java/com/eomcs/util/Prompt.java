package com.eomcs.util;

import java.util.Scanner;

public class Prompt {
  static Scanner keyScan = new Scanner(System.in); 

  public static String promptString(String titleFormat, Object...args) { //가변 파라미터: 0개 이상의 값이 온다 (안와도 되고) - Object 여러타입을 받으려고 ...
    System.out.print(String.format(titleFormat, args));
    return keyScan.nextLine();
  }

  public static int promptInt(String titleFormat, Object...args) {
    return Integer.parseInt(promptString(titleFormat, args)); //오버로딩- 파라미터 타입.순서,갯수가 달라야한다. 리턴타입만 다른상태(같은 이름ㅇ르 가질수없음 -> 메서드 구분이 불가) - 호출메서드 구분 파라미터 값으로 구분 
  }
}

//객체 생성을 안해도 되니까 스태틱으로 쓰자 
//프로그램적으로 프롬프트는 객체 1번만 만들면 되니까 굳이

//복잡한 코드를 메서드로 감추고, 쓴느 입장에서 단순하게 사용하게 하는 것 
//캡슐화

//특정기능을 수행하는 코드를 메서드로 포장, 메서드들을 관리하기 좋게끔 클래스로 포장
// 사용하는 입장에서는 호출만하면되니까 