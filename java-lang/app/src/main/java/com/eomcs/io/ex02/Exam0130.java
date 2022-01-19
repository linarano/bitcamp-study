// Byte Stream - 바이트 단위로 읽기 II
package com.eomcs.io.ex02;

import java.io.FileInputStream;

public class Exam0130 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/test1.data");

    // 반복문을 이용하여 여러 바이트를 읽는다.
    int b;

    //    while (true) {
    //      b = in.read();
    //      if (b == -1) // 파일의 끝에 도달하면 -1을 리턴한다.// 바이트세계에서는 음수가 없고 무조건 양수
    //        break;
    //      System.out.printf("%02x ", b);
    //    }

    while ((b = in.read()) != -1) { // 파일끝에 도달하지않고, 파일읅 읽었다는 뜻. 위에것으로 이해해라. 실무에서는 이 방법을 쓴다. 
      System.out.printf("%02x ", b);
    }

    in.close();
  }

}
