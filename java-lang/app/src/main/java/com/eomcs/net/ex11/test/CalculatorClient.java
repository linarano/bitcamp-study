package com.eomcs.net.ex11.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  public static void main(String[] args) {

    try (
        Scanner keyScan = new Scanner(System.in); // 서버와 연결이 끊어지면 입력닫는다. 
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        ) {

      while (true) {
        String str = in.nextLine();
        if (str.length() == 0) {
          break;
        }
        System.out.println(str);
      }

      while(true) {
        System.out.println("계산식> ");
        String input = keyScan.nextLine();

        if(!input.equals("quit") && input.split(" ").length !=3) {
          System.out.println("입력 형식이 올바르지 않습니다. 예) 23 + 5");
          continue;
        }


        out.println(input);
        out.flush();

        String str = in.nextLine();
        System.out.println(str);

        //statefull방식으로 변경
        if(str.equals("quit")) {
          break;
        }
      }

    } catch (Exception e) {
      System.out.println("서버 연결 오류!");
    }
  }
}
// 지금 스테이트리스방식 접속하고 요청하고연결끝내기  -> stateful 방식으로 바뀜 - 클라이언트가 그만둘때까지 주거니바껄떄가지 - 동작방법을 의미 - 문법이 달라지는게 아님
// 전형적인 스테이트 풀방식