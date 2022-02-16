// 버퍼 사용 전 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls11.pdf");// 몇번트랙을 찾고 섹터를 찾아서 따라가며 저장되어있는지 알아야함 

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초

    int callCount = 0;
    while ((b = in.read()) != -1) { //1byte만 읽는다.
      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);
    System.out.println(callCount);

    in.close();
  }

}

// 트랙과 섹터찾는게 힘들다 오래걸릴수박에  없다. 평균읽기 시간 = data seek time + real time
//뷔폐의 앞접시 역할 버퍼 
//중간접시에 왕창담아서 다 꺼내고 , 다끝나면 다시 왕창끄고 
//매번 한숟갈만큼 가져오는 것보다 