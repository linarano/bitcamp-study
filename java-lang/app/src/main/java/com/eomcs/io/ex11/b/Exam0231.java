// java.io.Serializable 처럼 사용되는 인터페이스 : java.lang.Cloneable 인터페이스
package com.eomcs.io.ex11.b;

public class Exam0231 {

  static class Score { //자동으로 Object 붙임  우리가 슈퍼클래스를 지정하지않으면
    String name;

    //    1) 오버라이딩
    //    @Override
    //      protected Object clone() throws CloneNotSupportedException {
    //        // TODO Auto-generated method stub
    //        return super.clone();
    //      }
    //    //2) 값에 맞게 변경
    //    @Override
    //    public Score clone() throws CloneNotSupportedException {// 1)같은접근범위나 확대는 되지만 좁히면 안됨. public/2)리턴타입의 서브로 바꿔도됨
    //      // TODO Auto-generated method stub
    //      return (Score) super.clone(); //스코어객체를 형변환할꺼니까 확실히 알려준다
    //    }
    //     복제 기능을 수행하려면 clone()을 오버라이딩 해야 한다.(object)
    @Override
    public Score clone() throws CloneNotSupportedException {
      return (Score) super.clone();
    }
  }

  public static void main(String[] args) throws Exception {

    Score obj = new Score();

    System.out.println(obj instanceof Cloneable);// 이 인터페이스를 구현한 객체만이 호출

    Score copy = obj.clone(); // 런타임(run-time) 오류!
    // Object에서 상속 받은 clone()을 호출하려면
    // 해당 클래스에 대해 복제 기능을 활성화해야 한다.
    // 방법? java.lang.Cloneable 인터페이스를 구현하라!
  }

}
