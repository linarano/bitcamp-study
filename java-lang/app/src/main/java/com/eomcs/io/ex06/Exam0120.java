// 버퍼 사용 후 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls11.pdf");

    byte[] buf = new byte[8192]; // 보통 8KB 정도 메모리를 준비한다.
    int len = 0;

    long startTime = System.currentTimeMillis(); // 밀리초

    int callCount = 0;

    while ((len = in.read(buf)) != -1) { //한번에 8192만큼읽음 
      System.out.printf("읽은 바이트 수: %d\n", len);
      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);
    System.out.println(callCount);
    in.close();
  }

}
//1024
//비트를 쓰다보니까 이진수원리이기때문에 
//1K = 1024byte
//방법이 균일해야함. 일관성 
//프로그래밍 방법이 균일하고 일관되길 원함 
//한번에 왕창읽는다. - 한번 데이터를 찾았을때 연속해서 데이터를 읽는게 빠름 

//1개씩 꺼내고 다시넣고, 1개씩 꺼내고 다시넣는것은 시간이 오래걸림 
//마치 편의점진열대(버퍼)와 - 창고(파일)처럼 
//손님이 원하면 편의점진열대 커피를 한개씩 주고 
//다 비워지면 창고에서 왕창 꺼내서 채우는 것처럼 
