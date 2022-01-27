package com.eomcs.app1;

import java.net.Socket;

public class ClientApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[계산기 클라이언트]");

    //1) 서버 애플리케이션과 네트워크 연결을 수행한다.
    Socket socket = new Socket("127.0.0.1", 8888);
    System.out.println("서버와 연결되었음!");


    // 데코레이터 연결
    PrintStream out = new PrintStream(socket.getOutputStream());
    InputStream in = socket.getInputStream();
    Scaner in = new Scanner(socket.getINputStream();)

        //서버에 데이터를 보낸다.
        out.println("강사");

    //서버가 응답한 데이터를 읽는다.
    String response = in.nextLine();
    System.out.println("==>" + response);

    //입출력 도구를 다 사용했으면 자원을 해제한다.
    out.clise();
    in.close();
    //스캐너가 데코레이터는 아니지만 데코레이터처럼 역할을 한다. 
    //1바이트를 4바이트메모리에 담아서 


    // 서버 애플리케이션과 연결된 것을 끊는다.
    socket.close();
    System.out.println("서버 연결 종료!");
  }

}
