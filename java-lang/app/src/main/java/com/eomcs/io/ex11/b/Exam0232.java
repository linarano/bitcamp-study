// java.io.Serializable 처럼 사용되는 인터페이스 : java.lang.Cloneable 인터페이스
package com.eomcs.io.ex11.b;

public class Exam0232 {

  // 이 클래스는 복제 가능하다고 설정한다.
  static class Score implements Cloneable {
    // Cloneable 인터페이스에는 메서드가 없다.
    // 따라서 이 인터페이스를 구현하는 클래스는 메서드를 정의할 필요가 없다.
    // 이 인터페이스 목적은 복제 가능 여부를 설정하는 용도이다.

    String name;

    @Override
    public Score clone() throws CloneNotSupportedException {
      return (Score) super.clone();
    }
  }

  public static void main(String[] args) throws Exception {

    Score obj = new Score();
    obj.name = "홍길동";

    System.out.println(obj instanceof Cloneable);//복제기능 활성화한 객체라는 뜻 

    Score copy = obj.clone();

    System.out.println(obj == copy); // OK! Score3 클래스는 복제를 허락했기 때문이다.
    System.out.println(obj.name); // 복제를 했기에 값은 다 같음 
    System.out.println(copy.name);

  }

}
//이클래스는 ~할 수 있는 클래스입니다. "허락한다고 표현 - 이기능을 활성화 시키라는 의미!" - 메서드가 없는 인터페이스
//그럼에도 불구하고 구현하는 이유
//표시하기 위해서 -able ~가 가능하다 