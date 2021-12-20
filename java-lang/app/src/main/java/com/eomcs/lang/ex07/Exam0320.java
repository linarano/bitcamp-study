package com.eomcs.lang.ex07;

//# 메서드 : call by reference
//
public class Exam0320 {

  static void swap(int[] arr) {
    System.out.printf("swap(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
    int temp = arr[0];
    arr[0] = arr[1];
    arr[1] = temp;
    System.out.printf("swap(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
  }
  // 호출이 끝나면 다 사라지고, 리턴
  public static void main(String[] args) {
    int[] arr = new int[] {100, 200};
    swap(arr); // 배열 인스턴스(메모리)를 넘기는 것이 아니다. 
    // 주소를 넘기는 것이다.
    // 그래서 "call by reference" 라 부른다.
    System.out.printf("main(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
  }
}




//main - arr 과 swqp- 같은메모리를 가리킨다.
//그렇게에 값이 바뀌면 영향을 받는다.
// 메인이 참고하는 값이 호출하는 쪽에서 바꾸고 싶으면 값을 넘기지말고 주소를 넘기면된다.

// 값을 받는게 있고, 주소를 넘기는게 있다.