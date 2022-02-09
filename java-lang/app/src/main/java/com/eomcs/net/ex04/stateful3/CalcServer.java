// stateful 방식 - 다중 클라이언트의 요청 처리 시 문제점과 해결책 (중첩클래스) - Thread 사용
package com.eomcs.net.ex04.stateful3;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {

  // 클라이언트와 통신하는 부분을 별도의 분리하여
  // 독립적으로 실행하게 한다.
  static class RequestHandler extends Thread {

    Socket socket;

    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      // main() 메서드를 호출과 분리하여 별도로 실행할 코드가 있다면
      // 스레드의 이 메서드에 둔다. 
      try (Socket socket2 = socket; //try  블럭 나갈때  close() -  여기다 쓰는 이유 // 변수 선언해두면 try 블럭 나갈떄 소켓은 닫히지못함.try블럭끝나고  socket2.close() 아니면 따로 작성해줘야함
          DataInputStream in = new DataInputStream(socket.getInputStream());
          PrintStream out = new PrintStream(socket.getOutputStream());) {

        // 작업 결과를 유지할 변수
        int result = 0;

        loop: while (true) {
          String op = in.readUTF();
          int a = in.readInt();

          switch (op) {
            case "+":
              result += a;
              break;
            case "-":
              result -= a;
              break;
            case "*":
              result *= a;
              break;
            case "/":
              result /= a;
              break;
            case "quit":
              break loop;
            default:
              out.println("해당 연산을 지원하지 않습니다.");
              continue;
          }

          out.printf("계산 결과: %d\n", result);
        }
        out.println("quit");
      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
      } finally {
        System.out.println("클라이언트 연결 종료!");
      }
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket ss = new ServerSocket(8888);

    while (true) {
      System.out.println("클라이언트의 연결을 기다림!");
      Socket socket = ss.accept();
      InetSocketAddress remoteAddr = (InetSocketAddress) socket.getRemoteSocketAddress(); //클라이언트의 포트번호 알아냄 추상클래스이므로 실제 서브클래스로 타입캐스트  - 아니면 JVM의 처리
      System.out.printf("클라이언트(%s:%d)가 연결되었음!\n", //
          remoteAddr.getAddress(), remoteAddr.getPort());//ip와 포트번호 - 특정범위 밖의 포트 접속 하면 접속거절 할 수 있음, getAddress()사용

      // 연결된 클라이언트가 연결을 끊기 전까지는
      // 대기하고 있는 다른 클라이언트의 요청을 처리할 수 없다.
      // 이것이 스레드를 사용하기 전의 문제점이다.
      // 해결책?
      // 클라이언트와 대화하는 부분을 스레드로 분리하여 실행하라!
      RequestHandler requestHandler = new RequestHandler(socket); // 클라이언트 연결되면 쓰레드로 처리 
      requestHandler.start();
      // 스레드를 실행하려면 start() 를 호출하라.
      // start()에 내부에서 run()을 호출할 것이다.
      // start() 호출한 후에 즉시 리턴한다.
      System.out.printf("%s 클라이언트와의 대화를 별도의 스레드에서 담당합니다!\n", //
          remoteAddr.getAddress());
    }
    // ss.close();
  }
}


//클라이언트가 연결되면 서버는 쓰레드를 만들어
// 동시에 여러클라이언트 접속- 계산 기능을 각각 쓰레드가 처리 ( 별도작업자를 두는 것) Thread 
//커넥션 풀방식도 - 마치 동시에 실행하는 것처럼 할 수 있따.
//게임서버가 이용.


