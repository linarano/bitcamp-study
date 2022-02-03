package com.eomcs.app1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[계산기 클라이언트]");

    Scanner keyScan =  new Scanner(System.in); //데코레이터와 ㅣㅂ슷한

    while(true) {
      System.out.print("요청(예: 서버주소/연산자/값1/값2)?");
      System.out.print("=> ");
      String input = keyScan.nextLine();

      if(input.equals("exit") || input.equals("quit")) {
        System.out.println("종료!");
        break;
      }

      int slashPos = input.indexOf("/"); //제일 처음에/ 를 찾아서 위치리턴
      String  serverAddress = input.substring(0,slashPos);
      String  queryString = input.substring(slashPos + 1);//두번째  -stringdms  불변객체, 한번넣으면 바뀌지않음 새로넣음 (웹서버와 웹브라우저에서)- 자바
      //url컴포넌드 - 자바스크립트 메서드로 바꿔줘야함. 그러나 

      // 서버 애플리케이션과 네트워크 연결을 수행한다.
      Socket socket = new Socket(serverAddress, 8888) ; // 서버와 연결될 때까지 객체를 생성하지 않는다.
      System.out.println("서버와 연결되었음!");

      // 데이터를 주고 받기 위한 입출력 스트림을 준비한다.
      PrintStream out = new PrintStream(socket.getOutputStream());
      Scanner in = new Scanner(socket.getInputStream());

      //만약 연산자가/ 일경우 - 인코딩
      if(queryString.startsWith("/")) {
        queryString= queryString.replaceFirst("/","%2f");//예)localhost///4/2
      }

      // 서버에 데이터를 보낸다.
      out.println(queryString); // 실행속도가떨어질지라도 가독성을 높여라, 더 직관적 => 유지보수에 좋다 

      // 서버가 응답한 데이터를 읽는다.
      String response = in.nextLine(); // 서버가 한 줄의 문자열을 보낼 때까지 리턴하지 않는다. (강사데이터만 출력- 줄바꿐코드 제외)
      System.out.println("==> " + response);

      // 입출력 도구를 다 사용했으면 자원을 해제한다.
      out.close();
      in.close();

      // 서버 애플리케이션과 연결된 것을 끊는다.
      socket.close();
      System.out.println("서버 연결 종료!");
    }

    keyScan.close(); //여러번 사용할꺼니까 바깥으로 뺸다 안쓰면 바로 종료하도록 짜라 
  }
}

//메모를 더쓰거나 , 실행속도 떨어지더라도 이해하기 좋은쪽으로 소스코드 변경해라 
//유지보수, 소스코드를 이해하는 데도움이 되고

//명령어작성 규칙중에 써서는 안되는게 있음  /사용불가. 다른형식으로 보내야함  - 식별연산자로 쓰이거나 다른의미로 쓰고있는 경우
//인코딩, 디코딩 - 기존의 형식에서 쓰는 문자인경우, 그 문자를 상대편 서버에 보낼때 특별한 다른 형식으로 바꿔서 보내자
//인코딩- 디코딩 짝궁처럼 가야한다. 
