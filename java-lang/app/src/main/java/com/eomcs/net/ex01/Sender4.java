// 파일 보내기
package com.eomcs.net.ex01;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender4 {

  public static void main(String[] args) throws Exception {
    File file = new File("temp/jls11.pdf");

    FileInputStream fileIn = new FileInputStream(file);

    System.out.println("서버에 연결 중...");
    Socket socket = new Socket("localhost", 8888);
    System.out.println("서버에 연결 완료!");

    DataOutputStream out = new DataOutputStream(socket.getOutputStream());// 이번에는 바이트배열로 보내자.- 데코레이터 
    Scanner in = new Scanner(socket.getInputStream());

    System.out.println("서버에 데이터 송신 중...");

    long startTime = System.currentTimeMillis();

    // 1) 파일 크기 보내기 (먼저보냄)
    out.writeLong(file.length()); // 길이를 long으로 리턴 20억 - 2 기가 

    // 2) 파일 이름 보내기
    out.writeUTF(file.getName()); // 문자열 

    // 3) 파일 데이터 보내기 - 모두 바이트배열 
    int b;
    while ((b = fileIn.read()) != -1) { //지금은 데이터 주고받자는 의미로 
      out.write(b);
    }

    long endTime = System.currentTimeMillis();

    System.out.printf("서버에 데이터 송신 완료!(%d밀리초)\n", endTime - startTime);

    // 4) 서버의 응답받기
    String response = in.nextLine();
    System.out.println(response);

    in.close();
    out.close();
    socket.close();
    fileIn.close();
  }

}


//no line - 입출력 합이 맞아야함 .