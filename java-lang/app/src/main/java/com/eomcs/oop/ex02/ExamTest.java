package com.eomcs.oop.ex02;

// # 사용자 정의 데이터 타입
//
public class ExamTest {

  static class Score {
    String name; 
    int kor;
    int eng;
    int math;
    int sum;
    float average;


    public void calculate() {
      this.sum = this.kor + this.eng + this.math;
      this.average = this.sum/ 3f;
    }
  }

  public static void main(String[] args) {
    Score score = new Score();

    score.name = "최리나";
    score.kor = 100;
    score.eng = 90;
    score.math = 85;

    score.calculate();

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", score.name, score.kor, score.eng, score.math,
        score.sum, score.average);
  }
}

