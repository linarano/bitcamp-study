package com.eomcs.lang.ex06;

//# 흐름 제어문 - switch 문법 II
//
public class Exam0241 {

  public static void main(String[] args) {
    int level = 1;//7을 집어넣는 것을 막을 방법이 없다

    // 상수를 사용하면 주석없이 바로 이해할 수 있다.(상수는 값이 안바뀜),따로주석필요없음
    // => case 문자의 값으로 변수를 사용할 수 없다.
    // => 단 값이 변경되지 않는 final 변수라면 사용할 수 있다.
    //
    final int GUEST = 0, MEMBER = 1, ADMIN = 2;

    switch (level) {
      case GUEST:
        System.out.println("조회만 가능합니다.");
        break;
      case MEMBER:
        System.out.println("글작성 가능합니다.");
        break;
      case ADMIN:
        System.out.println("다른 회원의 글을 변경, 삭제할 수 있습니다.");
        break;
    }
  }
}

//0,1,2 외의 값을 넣는 것을 막을 방법이 없다. 그래서 Enum사용
//항상 짜는 것보다 문제를 찾는게 더 시간이 오래걸려
//실수 줄이는게 잘짜는 것
