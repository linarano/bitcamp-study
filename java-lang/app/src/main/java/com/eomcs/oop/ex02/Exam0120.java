package com.eomcs.oop.ex02;

// # 사용자 정의 데이터 타입 + 클래스 메서드 - static 사용
//
public class Exam0120 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    //클래스는 사용자정의데이터타입을 만든다. ( 원시타입데이터정의처럼)클래스의 인스턴스 필드로 메모리구조를 설계하고, 그데이터를 다룰 연산자(메소드)를 정의한다.
    //필드문법 사용 데이터저장 메모리준비, 메소드문법을 사용해서 데이터를 다룰 연산자 정의 

    // 메서드를 이용하여 이 타입의 데이터를 다룰 수 있는 연산자를 정의한다.
    // - 사용자 정의 데이터 타입 입장에서는 메서드가 연산자 역할을 한다.
    // - 즉 사용자 정의 데이터 타입에 메서드를 정의하는 것은
    //   그 데이터를 다룰 연산자를 정의하는 것이다.

    // Score 데이터 값을 다룰 수 있는 새 연산자를 정의해 보자.
    // - 다음 메서드는 Score 객체의 국,영,수 값의 합계와 평균을 계산하는 연산자이다.
    public static void calculate(Score score) {// 특정인스턴스의 값을 다루려고 파라미터로 주소를 받음
      score.sum = score.kor + score.eng + score.math;
      score.average = score.sum / 3f;
    }
    // 클래스 메서드
    // - static이 붙은 메서드이다.
    // - 특정 인스턴스에 대해 사용하는 것이 아니라, 모든 인스턴스에 대해 사용할 수 있다.
    // - 특정 인스턴스의 값을 다루고 싶다면 파라미터로 그 인스턴스의 주소를 받아야 한다.
    // - 연산자가 다른 클래스의 데이터를 다룬다면 이 메소드는 해당클래스에 있을 필요가없다. = move method, 프로그램은 한번에 다 짤 생각하지말고 글을 퇴고하는 것처럼 유지보수하기 더 좋게 리팩토링 다듬어라. 
  }

  public static void main(String[] args) {

    Score s = new Score(); //Score 설계도에 따라서 메모리를 준비
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math = 85;

    // 다음은 Score의 값을 다루는 연산자가 없을 때의 예이다.
    // score.sum = score.kor + score.eng + score.math; 
    // score.average = score.sum / 3f;

    // 사용자 정의 데이터 타입의 값을 연산자를 사용하여 다뤄보자!
    Score.calculate(s); //스코어 클래스에 정의 되어있는 연산자를 사용해서 그 메모리를 다루세요.;

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.average);
  }
}

