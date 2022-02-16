// stateful 방식 - 계산기 클라이언트 만들기
package com.eomcs.net.ex04.stateful;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);

    Socket socket = new Socket("localhost", 8888);
    Scanner in = new Scanner(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    while (true) {
      System.out.print("값1? ");
      out.writeInt(Integer.parseInt(keyScan.nextLine()));//키보드입력받아서 int로 변환, 서버에 보낸다. 

      System.out.print("연산자? ");
      out.writeUTF(keyScan.nextLine());//내부적으로 버퍼처리되는듯?

      System.out.print("값2? ");
      out.writeInt(Integer.parseInt(keyScan.nextLine())); 
      //out.flush(); // 꼭해줘라 신경쓰지말고 그냥

      String str = in.nextLine();
      System.out.println(str);

      if (str.equals("Goodbye!"))
        break;
    }

    in.close();
    out.close();
    socket.close();
    keyScan.close();
  }
}


//계속연결- 먼저 요청한 클라이언트와 작업이 끊길때까지 다음 클라이언트는 기다려야함