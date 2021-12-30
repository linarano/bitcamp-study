package com.eomcs.oop.ex01;

// # 클래스 사용 : 4) 메서드 활용
//
public class Exam0113 {

  // 여러 메서드에서 클래스를 사용한다면
  // 이렇게 메서드 밖에 선언해야 한다.
  // => static 메서드에서 사용할 수 있게 클래스도 static으로 선언한다.
  static class Score { // static쓰고, 메인바깥에 썼으니 다른데서도 쓸수 있다. 혹, 안에쓰려면 static 삭제
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) { 
    Score s = new Score(); //봉다리에 담아서 객체주소 전달

    s.name = "홍길동";
    s.kor = 100; //s가 가리키는 인스턴스 kor변수에 100을 집어넣는다.
    s.eng = 90;
    s.math = 80;

    // 성적 데이터를 클래스로 묶어 놓으면 값을 다루기가 편하다.
    // => 다음과 같이 성적 데이터를 한 번에 넘길 수 있다.
    printScore(s); // w주소를 넘긴다.

    Score s2 = new Score(); //봉다리에 담아서 객체주소 전달
    s2.name = "유관순";
    s2.kor = 100; 
    s2.eng = 90;
    s2.math = 80;

    printScore(s2);

    Score s3 = new Score();
    s3.name = "유관순";
    s3.kor = 100; 
    s3.eng = 90;
    s3.math = 80;


    printScore(s3);


  }

  static void printScore(Score s) { //s의 주소를 받았으니 
    s.sum = s.kor + s.eng + s.math; //s로 찾아가서 
    s.aver = s.sum / 3;
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}








