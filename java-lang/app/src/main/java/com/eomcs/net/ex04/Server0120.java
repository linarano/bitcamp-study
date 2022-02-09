// 통신 방식 - Stateful + 여러 클라이언트 요청 처리
package com.eomcs.net.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0120 {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("서버 실행!");

      while (true) {
        // 한 클라이언트와 대화가 끝다면 다음 클라이언트와 대화를 한다.
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream())) {

          System.out.println("클라이언트가 연결되었음!");

          while (true) {
            String name = in.readLine();
            if (name.equalsIgnoreCase("quit")) {
              out.println("Goodbye!");
              out.flush();
              break;
            } // 앞 고객이 상담이 끝날때까지 계속 , 상담이 끝날때까지 계속
            out.printf("%s 님 반갑습니다!\n", name);
            out.flush();
          }
        } catch (Exception e) {
          System.out.println("클라이언트와 통신 도중 오류 발생!");
        }
        System.out.println("클라이언트와의 연결을 끊었음.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }

}

//110번과 차이! - 서버는 계속 기다림 - 여러클라이언트와 연결하려고 while문 밖에 

//statefull- 순차적처리
// 먼저 접속한 고객과의 연결이 끊을때까지 뒤의 고객(대기)에게는 응답안함. 계속 대기해야함.

//네이버 검색시 앞사람의 검색이 끝날때까지 검색결과가 안된다면 안된다. - stateless + thred: 동시요청처리