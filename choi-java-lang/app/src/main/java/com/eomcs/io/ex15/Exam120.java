//바이너리 파일을 텍스트 형식으로 저장하기 

package com.eomcs.io.ex15;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Base64;
import java.util.Base64.Decoder;


public class Exam120{
  public static void main(String[] args) {

    Decoder decoder = Base64.getDecoder();

    FileReader in = new FileReader("./temp/photo.txt");
    FileOutputStream out = new FileOutputStream("./temp/photox.jfif");

  }


}
/*
package com.eomcs.io.ex15;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Exam120 {
  public static void main(String[] args) throws Exception {
    Decoder decoder = Base64.getDecoder();
    FileReader in = new FileReader("./temp/photo.txt");
    FileOutputStream out = new FileOutputStream("./temp/photox.jfif");

    char[] buf = new char[1000000];//이번엔 왕창- 넉넉하게 // 1024바이트단위로 저장 -> 꺼낼때도 똑같이 
    int len = in.read(buf);  // 꽉안찰 수도 있으므로 리턴될 문자열을 챙겨야함
    System.out.printf("읽은 문자 수: %d\n", len);

    // 
    byte[] decodedBytes = decoder.decode(String.valueOf(buf,0,len));//읽은 문자열을 텍스트로 넘겨)
    //System.out.println(encodedStr);

    out.write(decodedBytes);

    in.close();
    out.close();
  }
}

//검색키워드는 기억해라. "Base64"- 바이너리 데이터를 텍스트로 바꿀때 쓰는 인코딩알고리즘 
 */