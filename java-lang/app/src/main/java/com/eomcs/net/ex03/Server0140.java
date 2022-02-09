// 클라이언트와 입출력 테스트 - byte stream : Data 주고 받기 II
package com.eomcs.net.ex03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0140 {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("클라이언트의 연결을 기다리고 있음.");

      try (Socket socket = serverSocket.accept();// 대기열등록됐다면 이미 연결 에 클라이언트가 있다면 꺼내서 소켓을 생성 - accept해야 클라이언트와 연결되는게 아니라. //accept는 승인//접속순서대로 꺼낸다. 
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream())) { //따로 finally만들 필요 없음 try()

        System.out.println("클라이언트가 보낸 Data를 기다리고 있음!");

        int value = in.readInt();
        byte value2 = in.readByte();
        float value3 = in.readFloat();
        String value4 = in.readUTF();
        System.out.printf("%d, %d, %f, %s\n", value, value2, value3, value4);


        System.out.println("데이터를 보내기 전에 잠깐!");
        keyboard.nextLine();

        // 클라이언트에서 받은 Data를 그대로 리턴한다. (보내는순서 중요 -읽는쪽에서 똑같이 - 규칙: 프로토콜)
        out.writeInt(value);
        out.writeByte(value2);
        out.writeFloat(value3);
        out.writeUTF(value4);
        // out.flush();
        // byte stream 을 사용할 때는 바로 출력한다. //char stream은 flush()를 하지않으면 안내보내짐// 권장 모두다 flush()써라.
        // 따라서 flush()를 호출하지 않아도 된다.
        System.out.println("클라인트에게 데이터를 보냈음.");

      }
      System.out.println("클라이언트와의 연결을 끊었음.");

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }

}

