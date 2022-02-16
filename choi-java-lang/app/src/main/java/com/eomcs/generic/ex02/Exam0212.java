// 제네릭(Generic) 문법 정리 - 레퍼런스와 인스턴스 생성 
package com.eomcs.generic.ex02;

import java.util.ArrayList;

public class Exam0212 {
  public static void main(String[] args) {

    ArrayList<Object> list1; //배열로 오브젝트 데이터를 다룬다.
    // 제네릭 타입을 Object로 지정하면 
    // 그렇게 지정된 ArrayList 객체만 list1에 저장할 수 있다.

    //list1 = new ArrayList(); // 이렇게 사용하지 말고, 명확히 제네릭의 타입을 지정하라.
    list1 = new ArrayList<Object>();
    list1 = new ArrayList<>();
    //그러나 객체를 생성할 때 한정을 해버리는게 말이 되냐? 허락못한다. - 오브젝트 중에서 이것만 다룬다고 하는게 말이되냐?
    //    list1 = new ArrayList<String>(); // 컴파일 오류!
    //    list1 = new ArrayList<Integer>(); // 컴파일 오류!


    // 메서드를 호출할 때는 레퍼런스에 지정된 제네릭 타입으로 문법을 검사한다. (오븍젝트로 지정했으므로, 뭐든지 다올 수 있다)
    list1.add(new String()); 
    list1.add(new java.util.Date());
    list1.add(new Integer(100));
    list1.add(new StringBuffer());

  }
}

// 암기하지말고
//계속 써서 익숙해져라 






