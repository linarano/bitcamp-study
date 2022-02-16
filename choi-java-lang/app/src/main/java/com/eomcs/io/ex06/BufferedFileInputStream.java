package com.eomcs.io.ex06;

import java.io.FileInputStream;
import java.io.IOException;

public class BufferedFileInputStream extends FileInputStream {
  byte[] buf = new byte[8192];
  int size; // 배열에 저장되어 있는 바이트의 수 (size =< 8192) - 실제버퍼에 읽은 개수
  int cursor; // 바이트 읽은 배열의 위치 - 앞으로 읽을 바이트의 인덱스 

  public BufferedFileInputStream(String filename) throws Exception {
    super(filename);
  }

  //파일에서 버퍼로 왕창 읽어온 횟수
  int readCount = 0;

  // 상속받은 메서드를 재정의하여
  //버퍼를 사용하는 서브클래스의 특징에 맞춰서
  //상속받은 메서드를 재정의한다.
  @Override
  public int read() throws IOException {
    if (cursor == size) { // 바이트 배열에 저장되어있는 데이터를 모두 읽었다면,
      if ((size = super.read(buf)) == -1) { // 다시 파일에서 바이트배열로 데이터를 왕창 읽어 온다.
        return -1;
      }
      readCount++; 
      System.out.printf("==>버퍼로 왕창 읽었음! - %d 번째 \n", readCount);
      cursor = 0;
    }
    return buf[cursor++] & 0x000000ff; //바이트배열의 값을 그냥 하나하나 리턴 그대로 해주면 안되는 이유// 172=>-84로 표현되기에 저렇게 붙여줘여함.
    //음수의 경우 ffffff로 3바이트가 반환되기때문에 

    //위의 리턴 문장은 컴파일 할때 아래의 문장을 ㅗ바뀐다. 
    //  int temp;//무조건 int
    //  temp = buf[cursor];
    //  cursor++;
    //  //return temp& 0x000000ff;
  }
}



//파일에서 바이트 값을 꺼낼 때 주의할점
//buf[i]  1바이트 => int값으로 리턴 4바이트 
//ac 부호비트로 판단, 실제로는 +84이나
//& 둘다 1일때만 1 
//어떤 값에대해서 &1 위에값그대로 투영 
//원래값 172