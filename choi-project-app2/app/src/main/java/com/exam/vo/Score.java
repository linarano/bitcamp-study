package com.exam.vo;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;

  public void compute() {
    sum = kor + eng + math;
    average = sum / 3f;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int kor) {
    this.kor = kor;
    compute();
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    this.eng = eng;
    compute();
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
    compute();
  }

  public int getSum() {
    return sum;
  }

  public float getAverage() {
    return average;
  }

  @Override
  public String toString() {
    return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
        + sum + ", average=" + average + "]";
  }

  public char[] toCSV() {
    // TODO Auto-generated method stub
    return null;
  }

  public static Score fromCSV(String line) {
    // TODO Auto-generated method stub
    return null;
  }


}

//인스턴스메서드나 인스턴스 필드를 사용하려면 객체의 주소를 줘야한다. 주소를 받는 this는 생략 된것 
//모든 필드가 setter/getter가 있어야하는게 아니다. => 성적평균이나 합계는 직접 값을 입력하는 것이 아니라 계산해서 넣는것이므로 Setter불필요