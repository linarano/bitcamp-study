package com.eomcs.net.ex12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ChatServer {
  int port;


  @SuppressWarnings("rawtypes")
  ArrayList clientOutputStreams = new ArrayList(); //

  public ChatServer(int port){
    this.port = port;
  }

  public void service() {
    try(ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중..");

      while(true) {
        new RequestHandler(serverSocket.accept()).start();// (serverSocket.accept() 먼저 실행 순서!!! 리턴돼야 객체가 생성된아 
      }

    } catch (Exception e){
      System.out.println("서버 실행 오류- " + e.getMessage());
    }
  }


  public void sendMessage(String message) {
    for (int i = 0; i< clientOutputStreams.size(); i++){
      DataOutputStream out = (DataOutputStream) clientOutputStreams.get(i);
      try {out.writeUTF(message);} catch (Exception e) {}

    }
  }
  class RequestHandler extends Thread {
    Socket socket; // 인스턴스필드

    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
      //클라이언트 요청처리 하는 걸 이 메서드에 

      try (Socket socket2 = socket;
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream())) {

        clientOutputStreams.add(out);

        out.writeUTF("환영합니다!");
        out.flush();

        while (true) {
          String message = in.readUTF();
          if (message.equals("\\quit")) {
            out.writeUTF("Goodbye!");
            out.flush();
            break;
          }
          sendMessage(message);// 클라이언트의 출력을 받으면 이쪽으로 보내라. 
        }
      } catch (Exception e) {
        System.out.println("클라이언트와의 통신 오류! - " + e.getMessage());
      }
    }
  }


  public static void main(String[] args) {
    new ChatServer(8888).service();

  }

}


// 계속 클라이언트가 요청하면
//쓰레드가 별도의 요청흐름을 만들어
// 실행흐름은 어차피 다시 메인으로 돌아와 종료한다. - 절대 중간에 끊기는게 없다.( 실처럼 계속 연결되어 결국에는 메인으로 들어온다) - main() 호출 --> 결구 메인으로 돌아옴
//새로운 실행흐름 new Thread();