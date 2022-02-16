// 제네릭(Generic) 문법 정리 - 레퍼런스와 인스턴스 생성 
package com.eomcs.generic.ex02;

import java.util.ArrayList;

public class Exam0211 {
  public static void main(String[] args) {
    // 레퍼런스를 선언할 때 제네릭 타입을 지정하지않으면
    //객체 생성시 어떤 제네릭 타입을 지정하더라도 상관 없다. 

    ArrayList list1; //레퍼런스와 넣을 수 있는 객체 => 타입지정하지않으면 아무거나 다됨 //=> 레퍼런스의 제네릭타입이 중요//Object dhk ehddlf
    // list1 = new ArrayList(); // 레퍼런스가 중요한것!!
    // list1 = new ArrayList<>(); //   list1 = new ArrayList(); 동일
    //    list1 = new ArrayList<Object>();

    //list1 = new ArrayList<String>(); // 되는 이유는?
    list1 = new ArrayList<Member>();

    //=> 레퍼런스를 선언할 때 , 제네릭타입을 지정하지 않으면 
    //    ArrayList 객체를 생성할때 지정한 제네릭 타입은 무시된다.
    list1.add(new String());
    list1.add(new Integer(100));
    list1.add(new java.util.Date());
    list1.add(new Member("홍길동", 20));


    // 레퍼런스를 선언할때 제네릭 타입을 <?>로 선언하면
    // 객체 생성시 어떤 제네릭 타입을 지정하더라도 상관없다.
    //단, 메서드를 사용할 때 주의해야 한다.
    ArrayList<?> list2; 
    //list2 = new ArrayList(); 
    //    list2 = new ArrayList<>();
    list2 = new ArrayList<Object>();
    //    list2 = new ArrayList<String>();
    //    list2 = new ArrayList<Member>();

    //=> 레퍼런스 선언할 떄 제네릭 타입을 ?로 설정했기 때문에 
    // 컴파일러는 add() 메서드의 파라미터 타입은 ? 가 된다.
    // 즉 파라미터 타입이이 뭔지 정확하게 설정되지 않았기 때문에 
    // 컴파일러는 문법의 유효여부를 검사할 수 없다.
    //
    //    list2.add(new String()); // 컴파일 오류!
    //    list2.add(new Integer(100)); // 컴파일 오류!
    //    list2.add(new java.util.Date()); // 컴파일 오류!
    //    list2.add(new Member("홍길동", 20)); // 컴파일 오류!
  }
}


//레퍼런스가 중요한 것 
// 아무것도 안주는 것과
//? 지정하면 -> 컴파일러는 알 수가 없다.
//아~! 그럴 수 있구나





