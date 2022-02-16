package com.eomcs.net.ex11.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {

  String logo;

  public CalculatorServer() {
    StringBuilder logoStr = new StringBuilder();

    try (BufferedReader welcomeIn = new BufferedReader(new FileReader("welcome.txt"));) {
      while (true) {
        String str = welcomeIn.readLine();
        if (str == null) {
          break;
        }
        logoStr.append(str + "\n");
      }
    } catch (Exception e) {
      if (logoStr.length() > 0) {
        logoStr.setLength(0);
      }
      logoStr.append("환영합니다!\n");
    }

    logo = logoStr.toString();
  }

  public void launch(int port) {
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("서버 실행 중...");

      while (true) {

        new RequestHandler(serverSocket.accept()).start();// 안쪽부터 실행하므로 임시변수 만들지마라. 소켓못만들면, 안됨

      }

    } catch (Exception e) {
      System.out.println("서버 소켓 생성 중 오류 발생!");
    }
  }

  public static void main(String[] args) {
    new CalculatorServer().launch(8888);
  }

  public class RequestHandler extends Thread { // 서버에서만 쓸꺼니까 패키지멤버라는 일반멤버로 만들지만 특정클래스 - 중첩클래스 nesttes zmffotm 

    Socket socket;
    String logo;

    public RequestHandler(Socket socket) {//중첩클래스 이너클래스(논스태틱)
      this.socket = socket;
    }

    @Override
    public void run() {
      try (
          Socket socket2 = socket; // close() 자동 호출하기 위해
          Scanner in = new Scanner(socket.getInputStream());
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {

        out.print(logo);//중첩클래스의 이점  - 바깥클래스의 객체주소  // 마치 자기변수인냥 생략가능. 

        out.println("계산식을 입력하세요!");
        out.println("예) 23 + 7 ");
        out.println();

        while( true) {
          String str = in.nextLine();//클라이언트가 보낸걸 읽어 

          if(str.equals("quit")) {
            out.println("goodbye!");
            out.flush();
            break;
          }
          try {
            String[] values = str.split("");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[2]);
            String op = values[1];

            switch (op) {
              case  "+" : out.printf(" %d %s %d =%d \n", a, op, b, a + b); break;
              case  "-" : out.printf(" %d %s %d =%d \n", a, op, b, a - b); break;
              case  "*" : out.printf(" %d %s %d =%d \n", a, op, b, a * b); break;
              case  "/" : out.printf(" %d %s %d =%d \n", a, op, b, a / b); break;
              case  "%" : out.printf("%d %s %d =%d \n", a, op, b, a % b); break;
              default: out.printf("%d %s %d =%d \n", a, op, b,"지원하지않는 연산자 입니다.");

            }
            out.flush();

          }catch(Exception e) {
            out.println("계산중 오류발생-" + e.getmessage());
            out.flush();
          }

        }
      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
      }
    }
  }


}
//중첩클래스 - 파라미터로 받을 필요가 없다.
//특정클래스 안에서만 사용 

//자바스크립트 클로저 
//내부에서 쓰려는게 아니라 
//용도가 다름 클로저 리턴, 파라미터로 넘겨지거나 해줄려고 쓰는 것  




