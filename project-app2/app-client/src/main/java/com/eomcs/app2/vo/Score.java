package com.eomcs.app2.vo;

import java.io.Serializable;

public class Score  implements Serializable {
  private static final long serialVersionUID = 1L;

  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;

  public static Score fromCSV(String csv) {
    String[] values = csv.split(",");
    Score score = new Score();
    score.setName(values[0]);
    score.setKor(Integer.parseInt(values[1]));
    score.setEng(Integer.parseInt(values[2]));
    score.setMath(Integer.parseInt(values[3]));
    return score;
  }

  public String toCSV() {
    return String.format("%s,%d,%d,%d",
        this.getName(),
        this.getKor(),
        this.getEng(),
        this.getMath());
  }

  private void compute() {
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


}


/*
public class Score implements Serializable{

private static final long serialVersionUID = 1L;
String name;
int kor;
int eng;
int math;
int sum; // 설정할때만 조회하는 것 - 우리가 직접 입력하는게 아님 
float average; // 설정할때만 조회하는 것 - 우리가 직접 입력하는게 아님  - 모두 셋터겟터가 있을 필요없다 -> 값을 꺼낼 떄 우지보수용 

public static Score fromCSV(String csv) {// 팩토리 메서드 - 객체 생성과정이 복잡하므로 메서드를 호출 -> 캡슐로 감싼다. -> 캡슐화시킨다. -> 복잡한 코드를 캡슐에 감쳐놓고 우리는 단순하게 사용
  String[] values = csv.split(",");
  Score score = new Score();
  score.setName(values[0]);
  score.setKor(Integer.parseInt(values[1]));
  score.setEng(Integer.parseInt(values[2]));
  score.setMath(Integer.parseInt(values[3]));
  return score;
} // 내부적으로 인스턴스 필드안씀 

public String toCSV() { //  내부변수 -인스턴스 메서드
  return String.format("%s,%d,%d,%d",  
      this.getName(), 
      this.getKor(),
      this.getEng(),
      this.getMath());
}

private void compute() {
  sum = kor + eng + math; //this 생략
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
}
 */

//어떤 인스턴스메서드를 호출하든 - 주소를 줘여한다. this는 생략된것일뿐 
// 모든 필드가 셋터와 겟터가 있어야하는게 아니다. getSum(); get