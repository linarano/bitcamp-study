// 서버와 입출력 테스트 - byte stream + buffer ****// 버퍼조심!!! 
package com.eomcs.net.ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0160 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    try (Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
        Scanner in = new Scanner(new BufferedInputStream(socket.getInputStream()))) {

      System.out.println("서버와 연결되었음!");

      // 서버에 데이터를 보내기 전에 잠깐 멈춤!
      System.out.print(">");
      keyScan.nextLine();

      out.println("ABC가각간"); //->버퍼 중간에 끼워쓸때는 객체 안에 보관된다. 서버에 보내진게 아니라. 클라이언트 버퍼객체에 보관.*** 
      out.flush();
      // 버퍼를 사용할 때는
      // 데이터를 보내기 위해 반드시 flush()를 호출해야 한다.
      // => 버퍼에 남아 있는 데이터를 연결된 출력 스트림을 이용하여 내보낸다. (즉시보내고 싶으면!)
      System.out.println("서버에 데이터를 보냈음!");//-> 데이터를 보냈으나. 메모리에입력이 안됌

      String str = in.nextLine();
      System.out.println(str);

    } catch (Exception e) {
      e.printStackTrace();
    }

    keyScan.close();
  }
}


// 서로 대화가 안되는 상황- 네트워킹
//서버에서는 데이터를 못받은것. 