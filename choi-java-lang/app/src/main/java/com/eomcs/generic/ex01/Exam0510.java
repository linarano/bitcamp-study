// 제네릭(Generic) : 배열 만들기 *****
package com.eomcs.generic.ex01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Exam0510 {

  // 제네릭 배열 생성하기 - 일반적 방법으로 생성 안됨 => 그러므로 아래의 방법을 잘 알아둬야한다. 

  // 예1) 제네릭의 타입 파라미터로 레퍼런스 배열을 생성할 수 없다.
  static <T> T[] create1() {
    T[] arr; //  제네릭 타입  변수는 만들 수 있음 
    //        arr = new T[10]; // 컴파일 오류! new 명령어를 사용할 때 제네릭의 타입 파라미터를 사용할 수 없다.
    return null;
  }

  // 예2) 견본 배열을 받아서 복제하는 방법을 사용한다.
  static <T> T[] create2(T[] arr) { // 스트링 배열이 넘어오면, 복제하는 것도 스트링 배열임
    // copyOf(original, newLength)
    // => 원래 배열(original)과 같은 타입의 배열을 배열크기(newLength)에 맞춰 새로 생성한다.
    return Arrays.copyOf(arr, 10); // 복제한게 더 크면 새 배열을 만든다. 값이 잇으면 값도 그대로 복제
  } //패키지가 다름 

  // 예3) 배열의 타입 정보를 받아 생성하기 ****
  @SuppressWarnings("unchecked")
  static <T> T[] create3(Class<?> type) {
    return (T[]) Array.newInstance(type, 10); //위와 패키지가 다름 , 단 형변환 해줘야해
  }

  // 예4) 견본 배열에서 타입 정보를 추출하여 배열을 생성하기*** - 타입정보 대신 배열이 넘어옴
  @SuppressWarnings("unchecked")
  static <T> T[] create4(T[] arr) {
    Class<?> arrayTypeInfo = arr.getClass(); // 예) String[]
    System.out.println(arrayTypeInfo);

    Class<?> arrayItemTypeInfo = arrayTypeInfo.getComponentType(); // 예) String
    System.out.println(arrayItemTypeInfo);

    return (T[]) Array.newInstance(arrayItemTypeInfo, 10);
  }// 배열정보에서 그 항목정보만 빼낸다. 둘중에 편한 방법쓰면된다.

  public static void main(String[] args) {
    // 제네릭을 사용하는 메서드를 이용하여 배열 만들기

    // 파라미터로 빈 배열을 넘기면,
    String[] arr1 = create2(new String[0]); // 우리가 만들게 아니라, 만들수 있도록 샘플역할만 하도록 0개를 만들면 됨 ->배열의 타입정보만 필요 
    System.out.println(arr1.length);

    // 내부에서 생성할 배열 크기 보다 더 큰 배열을 파라미터로 넘긴다면?
    // copyOf() 그래도 새 크기에 맞춰 새 배열을 생성한다.
    String[] temp = new String[100];
    String[] arr2 = create2(temp);
    System.out.println(arr2.length);
    System.out.println(temp == arr2);

    // 생성할 배열의 타입 정보를 넘긴다.
    String[] arr3 = create3(String.class);//멤버클래스의 정보 스태틱메소드.class
    System.out.println(arr3.length);

    // 배열을 넘기면 배열의 항목 타입을 알아내어 새 배열을 만든다.
    String[] arr4 = create4(new String[0]);
    System.out.println(arr4.length);
  }


}








