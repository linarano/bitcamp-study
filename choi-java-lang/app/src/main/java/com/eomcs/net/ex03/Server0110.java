// 클라이언트와 입출력 테스트 - byte stream
package com.eomcs.net.ex03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0110 {
  public static void main(String[] args) { 
    Scanner keyboard = null;
    ServerSocket serverSocket = null; 

    try {
      keyboard = new Scanner(System.in); // 데코레이터처럼 쓰이나 데코레이터가 아님 왜냐 인풋스트림의 서브클래스가 아님 
      serverSocket = new ServerSocket(8888);
      System.out.println("클라이언트의 연결을 기다리고 있음.");

      Socket socket = null;
      OutputStream out = null;
      InputStream in = null; // try문 안에 두면 finally에서 접근 못하므로 닫아야하니까 밖에 둔다. (유효범위)

      try {
        // accept()
        // - 대기열에서 클라이언트 정보를 한 개 꺼내 소켓을 만들어 클라이언트와 연결한다.
        // - 만약 대기열에 클라이언트 정보가 없다면 클라이언트가 접속할 때까지 기다리다.
        socket = serverSocket.accept();
        System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음.");

        // 클라이언트와 데이터를 주고 받을 입출력 스트림 객체를 준비한다.
        // => 출력 스트림 객체를 준비하기
        out = socket.getOutputStream();

        // => 입력 스트림 객체를 준비하기
        in = socket.getInputStream();
        System.out.println("클라이언트와 통신할 입출력 스트림이 준비되었음.");

        // Client와 Server의 통신 규칙에 따라 순서대로 입출력 해야 한다.
        // 왜? 
        // 입출력은 blocking 모드로 작동하기 때문이다.
        // 즉 read()라는 메서드는 클라이언트가 보낸 데이터를 읽기 전까지 리턴하지 않는다.
        //
        // 클라이언트와 서버 간의 데이터를 주고 받는 통신 규칙을 "프로토콜(protocol)"이라 한다.
        // 클라이언트에서 한 줄의 문자열을 보내면
        // 서버는 한 줄의 문자열을 읽은 후에 응답해야 한다.

        System.out.print("데이터를 읽기 전에 잠깐!");
        keyboard.nextLine(); // 실행제어용 의미없음 .

        System.out.println("클라이언트가 보낸 1바이트를 기다리고 있음!");
        // => 클라이언트가 1바이트를 보낼 때까지 리턴하지 않는다.
        int request = in.read(); // blocking 모드로 작동한다. // 이메서드가 호출되어야 데이터를 읽는다.

        System.out.println(request);

        // 서버가 데이터를 보내지 않으면 클라이언트의 read()는 리턴하지 않는다.
        // 이를 확인하기 위해 잠시 실행을 멈춘다.
        System.out.print("데이터를 보내기 전에 잠깐!");
        keyboard.nextLine();

        // => 클라이언트에게 받은 문자열을 그대로 보낸다.
        // 물론 클라이언트가 보낸 데이터를 다 읽을 때까지 리턴하지 않는다.
        out.write(request);
        // out.flush();
        // byte stream 을 사용할 때는 바로 출력한다.
        // 따라서 flush()를 호출하지 않아도 된다.
        System.out.println("클라인트에게 데이터를 보냈음.");

      } catch (Exception e) {
        e.printStackTrace();

      } finally {
        try {out.close();} catch (Exception e) {} // 보통입출력은 {}, 순서대로 닫아라. 출력을 먼저 닫는다. close() 내부적으로 flush가 안되어있으면 닫는다. // 버퍼가 꽉 차지않으면 내보내지않는다. close로 닫아서 찌꺼기를 내보내도록
        try {in.close();} catch (Exception e) {} // 입력/ 출력을 따로따로 닫아야한다. 출력을닫다가 에러 발생하면 catch문으로 바로 넘어감 .
        try {socket.close();} catch (Exception e) {}
        System.out.println("클라이언트와의 연결을 끊었음.");
      }


    } catch (Exception e) {
      System.out.println("상세 예외정보"); // 포트중복일때 발생하는 에러 
      e.printStackTrace(); // 메인에서 호출한 메서드를 따라올라가라. 맨 마지막부터 거꾸로 따라올라가면서 출력해라ㅣ.- 예외발생 추적 

    } finally {
      System.out.println("키보드 자원해제 및 서버 소켓 자원 해제!");
      keyboard.close(); //닫다가 에러있어도 던지지않고 무시 , 자기가 알아서 처리 (메뉴얼)  throws 선언 안되어있음 
      try { serverSocket.close(); } catch (IOException e) {}
    }
    System.out.println("서버 종료!");
  }

}

//
//serverSocket - 에러 던진다라고 메뉴얼에 적혀있음 - 개발자에 강조하는 것 
//throws Exception { //JVM에게 맡겨 - 예외발생했는지 역으로 출력하고 프로그램 당장종료시킬꺼야. 난 아름답게 안해 ...란의미 => 예외만 오면 당장멈춘다. 끔찍한 상황 
//런타입 익셉션이 아니라면 try-catch 또는 상위자에게 호출해야함.  처리한 사실을 명확하게 알고 있어라 (메서드 호출시)
//내가 만든 메서드를 다른 개발자가 쓴다면?
// 예외 발생시, 그 예외에 대해서 런타입익셉션, 그냥 익셉션을 던질지 우리가 결정. 
// 런타입 익셉션 던진다. - 치명적인 에러는 아닌데 알아서 잘써
// 반드시 처리해야하는 에러라면- 예외던질때 익셉션 또는 익셉션 하위클래스를 던져야함. (이거 예외처리 안하면 시스템 전방에 악영향을 끼친다. )
//
// 우리가 에러를 가지는 메서드를 호출하는 입장이라면?
//예외처리해야하는 메서드라는 것을 인지해야함.(강조)//가능한한 반드시 에러를 처리해라. 