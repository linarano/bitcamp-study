// connectionless 클라이언트 - 연결없이 데이터 송신
package com.eomcs.net.ex05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Connectionless
// => 서버와 연결없이 데이터를 보내고 받을 수 있다. (놀랍다)
// => DatagramSocket, DatagramPacket을 사용하여 처리한다. (클래스가달라짐, 문법이 달라짐)
// => 예) 편지, ping 등
// => 응용) 모니터링 프로그램에서 많이 사용한다. - 서버가 실행되어있으면 받고, 없으면 못받고, - 살아있든 안살아있든 일단 지정된 위치로 보낸다
// 연결지향은 서버가 안켜져있으면 에러 
public class Client0210 {
  public static void main(String[] args) throws Exception {
    // connectionless 방식으로 통신을 수행할 소켓 생성
    // - 클라이언트 쪽은 포트 번호를 지정하지 않는다.
    // - 물론 OS가 자동으로 부여할 것이다. ( 이거는 연결지향과 동일)
    DatagramSocket socket = new DatagramSocket(); // 쓰는 방법이 다름  - 데이터를 던지는 도구 

    // 데이터를 받을 상대편 주소와 포트 번호
    String receiver = "localhost";
    int port = 8888;

    // 보낼 데이터를 바이트 배열로 준비
    //     String message = new String("Hello"); // Heap에 String 객체 생성
    //String message = "Hello"; // constant pool에 String 객체 생성 - 상수스트링 - 같은 컨텐츠가 중복생성안되게 ---- 이걸 써라. 사용자에게 입력받으면 어쩔 수 없지만 이걸써라.코딩편하고, 메모리 중복해서 만들지 마라 
    //이 잦체가 스트링 객체 
    //byte[] bytes =  message .getBytes("UTF-8");
    byte[] bytes = "Hello".getBytes("UTF-8");// 스티링 객체임(스트링리터럴이_) - 당황하지마라. 

    // 보낼 데이터를 패킷에 담는다.
    // => 패킷 = 데이터 + 데이터크기 + 받는이의 주소 + 받는이의 포트번호
    DatagramPacket packet = new DatagramPacket(
        bytes, // 데이터가 저장된 바이트 배열
        bytes.length, // 전송할 데이터 개수
        InetAddress.getByName(receiver), // 데이터를 받을 상대편 주소 // new InetAddress() 불가능 - defulat 패키지 
        port // 포트번호
        );

    // 데이터 전송
    socket.send(packet);
    System.out.println("데이터 전송 완료!"); // 잘받았는지 안받았는지 상대편의 상태 알 길이 없음 

    // 자원해제
    socket.close();

    // 상대편이 네트웍에 연결되었는지 따지지 않고 무조건 데이터를 보낸다.
    // 만약 상대편이 연결되어 있지 않다면, 보낸 데이터는 그 쪽 네트웍에서 버려진다. -라우터와 허브까지 도달 지정된 주소의 해당하는 컴퓨터가 없으면 데이터 버려진다. 
    // => 데이터 송수신을 보장하지 않는다.
  }
}


