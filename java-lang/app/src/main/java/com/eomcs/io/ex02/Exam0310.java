// Byte Stream - 바이트 배열의 특정 부분을 출력하기
package com.eomcs.io.ex02;

import java.io.FileOutputStream;

public class Exam0310 {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("temp/test1.data");

    byte[] bytes = {0x7a, 0x6b, 0x5c, 0x4d, 0x3e, 0x2f, 0x30};

    // write(byte[]) : 배열의 값 전체를 출력한다.
    // write(byte[], 시작인덱스, 출력개수) : 시작 위치부터 지정된 개수를 출력한다.
    //
    out.write(bytes, 2, 3); // 2번 데이터부터 3 바이트를 출력한다. //배열의 주소, offset-기준점

    out.close();

    System.out.println("데이터 출력 완료!");

  }

}

//끊임없이 배열 사용
//배열 호출
//메서드 리턴값 연습
//반복문 다루는 것 연습 
//마이리스트 - 재밋지 
//그걸 하기위해서는 실제로 연습해야함 .