//바이너리 파일을 텍스트 형식으로 저장하기 
package com.eomcs.io.ex15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Exam110{
  public static void main(String[] args) throws Exception {
    Encoder encoder = Base64.getEncoder();

    File file = new File("./temp/photo.jifif");
    FileInputStream in = new FileInputStream(file);
    FileWriter out = new FileWriter("./temp/photo.txt");

    byte[] buf = new byte[(int)file.length()];
    int len = in.read(buf);
    System.out.printf("읽은 바이트 수 : %d\n", len);

    //바이트 배열에 저장된 바이너리 데이터를 텍스트로 변환하기
    String encodedStr = encoder.encodeToString(Arrays.copyOf(buf,len));

    // 텍스트로 변환된 데이터를 파일로 출력하기 
    out.write(encodedStr);


    in.close();
    out.close();
  }
}


/*
public class Exam110 {
  public static void main(String[] args) throws Exception {
    Encoder encoder = Base64.getEncoder();
    File file = new File("./temp/photo.jfif");// 파일정보가 필요

    FileInputStream in = new FileInputStream(file);
    FileWriter out = new FileWriter("./temp/photo.txt");

    //배열이 크다고 해서 운영체제에서 한번다 읽지않음
    //자동으로 여러번 읽음
    //이렇게 짜면 안된다. 실무에서//
    //우리는 실습으로 파일크기 작으므로 -> 통짜로 읽자
    byte[] buf = new byte[(int)file.length()]; // 1024바이트단위로 저장 -> 꺼낼때도 똑같이  //  간단하게 가자 -> 파일 통째로 //렝스의 리턴값 롱 , 혹시 파일이 2기가 넘어갈것을 대비해서 롱 타입 /./우리 배열은  4기가 넘어갈수 없음 40억바이트
    int len = in.read(buf); //운영체제는 1700만 읽고 리턴할 수 있음, // 따라서 운영체제가 실제 읽기에는 읽은개숫가 중요 
    System.out.printf("읽은 바이트 슈: %d\n", len);
    //원래 파일 크기가 읽은 개수를 서로 비교해서 부족하면 더 읽어야함 
    //파일입출력은 반복문으로 짜야하는게 맞음

    // 바이트 배열에 저장된 바ㅓ이너리 데이터를 텍스트로 변환하기  - 버퍼에 꽉 채울 수도있고 안채울 수도있음 - 버퍼에 꽉 안찬 부분은 뺴고 바꿔
    // 새로운 형식의 문자열로 리턴  나머지부분 전체를 통째로 바꾼다. 그래서 우리는 딱 데이터가 들어있는 만큼만 새로 배영을 만들어서 
    String encodedStr = encoder.encodeToString(Arrays.copyOf(buf, len));//배열을 통째로 밖에 주는 수밖에 없다. 정확하지않음 -> 배열 크기만큼 복사
    //System.out.println(encodedStr); //통째로 읽으니공백까지 다 변환하는 문제

    out.write(encodedStr);
    // 읽었으면
    in.close();
    out.close();
  }
}

//검색키워드는 기억해라. "Base64"- 바이너리 데이터를 텍스트로 바꿀때 쓰는 인코딩알고리즘 

 */