package com.eomcs.net.ex12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


@SuppressWarnings("rawtypes")
public class ChatServer {
  int port;


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


  @SuppressWarnings("unchecked")
  public void sendMessage(String message) {
    ArrayList deleteStreams = new ArrayList();

    for (int i = 0; i< clientOutputStreams.size(); i++){
      DataOutputStream out = (DataOutputStream) clientOutputStreams.get(i);
      try {out.writeUTF(message);}
      catch (Exception e) {
        System.out.println("전송오류 : " + message);
        deleteStreams.add(out); //  무효한 출력 스트림은 삭제 명단에 등록한다.  -> 무미건조한 코드를 말로 풀어써라 . 머릿속에 그림을 그려라  수억수천년동안 쌓인 데이터를  단기간에 흡수하는 지식 
      }
    }

    for (Object deleteStream : deleteStreams) { // 삭제 명단에 등록된 출력스트림을 제거한다. 
      clientOutputStreams.remove(deleteStream);
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

        clientOutputStreams.add(out); // 접속하는 순간 목록에 추가하고 1)


        String nickname = in.readUTF(); //메세지를 보낼때마다 쓰자

        out.writeUTF(nickname + "님 환영합니다!");
        out.flush();

        while (true) {
          String message = in.readUTF();
          if (message.equals("\\quit")) {
            // out.writeUTF("Goodbye!"); //  별도의 쓰레드가 작업하므로 언제뜰지몰람 - 프로토콜을 바꾸자 - 더 쉽게 //  연결을 끊겠다는 메시지를 클라이언트에게 보낸다.
            out.writeUTF("<![QUI[]]}>"); // 사람들이 잘 입력하지않을만한 문자열을 줄 꺼다 - 특별한 코드를 보낼꺼다. 
            out.flush();
            clientOutputStreams.remove(out);// 메시지 출력목록에서 연결이 종료된 클라이언트를 제거한다. 2
            break;
          }
          sendMessage(String.format("[%s] %s", nickname, message));// 클라이언트의 출력을 받으면 이쪽으로 보내라. 
          // sendMessage("[" +nickname+"]" + message);

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