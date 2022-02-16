package com.eomcs.algorithm.data_structure.array2.step2;

public class Score { // 원래 인스턴스 필드는 퍼블릭으로 공개안하지만 지금은 제네릭을 배울려고
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public Score(String name, int kor,int eng,int math) {
    this.name =name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;

    this.compute();
  }

  private void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
