//static nested class : import static 사용 후
package com.eomcs.oop.ex11.b;

// 각각의 스태틱 멤버를 지정하는 대신 
// 다음과 같이 wildcard(*)를 사용하여 전체 스태틱 멤버를 한 번에 지정할 수 있다. //-컨트럴 제트 직전소스로 복원 -> 와일드카드 쓴는 것보다 추천!!!!!, 많지않으면 정확하게 적워두는게 후임개발자에게 소스코드를 이해하는데 더 도움 
import static com.eomcs.oop.ex11.b.F.m1;
import static com.eomcs.oop.ex11.b.F.v1;
import static com.eomcs.oop.ex11.b.sub.M.m2;
import static com.eomcs.oop.ex11.b.sub.M.v2;
import com.eomcs.oop.ex11.b.F.X;
import com.eomcs.oop.ex11.b.sub.M.Y;

class F {
  static int v1;

  static void m1() {}

  static class X {
    void test() {
      System.out.println("test()");
    }
  }
} 

public class Exam0430 {

  public static void main(String[] args) {
    // 같은 패키지 클래스의 스태틱 멤버
    // => import static 으로 미리 스태틱 멤버의 패키지 정보를 알려주면,
    //    마치 같은 클래스의 멤버인양
    //    클래스 이름 없이 사용할 수 있다.
    v1 = 100;
    m1();
    X obj = new X();

    // 다른 패키지 클래스의 스태틱 멤버
    // => import static 으로 미리 스태틱 멤버의 패키지 정보를 알려주면,
    //    마치 같은 클래스의 멤버인양
    //    클래스 이름 없이 사용할 수 있다.
    v2 = 200;
    m2();
    Y obj2 = new Y();
  }

}