// 타입아웃 시간 설정하기
package com.eomcs.net.ex02;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client0310 {
  public static void main(String[] args) throws Exception {
    // 실행을 잠시 중단시키기 위해 사용
    Scanner keyScan = new Scanner(System.in);
    System.out.println("클라이언트 실행!");

    // 1) 소켓만 생성한다.
    Socket socket = new Socket();
    System.out.println("소켓 생성됨.");

    // 2) 연결할 서버의 주소를 준비한다. ( 따로 객체에 저장) -java.net패키지- 추상클래스 , 타임아웃시간 임의적으로 
    SocketAddress socketAddress = new InetSocketAddress("192.168.0.3", 8888); // 서브클래스를 만들어서 리턴 

    // 3) 서버와의 연결을 시도한다.
    // => 타임아웃으로 지정된 시간 안에 서버와 연결되지 않으면 즉시 예외가 발생한다.
    // => Windows의 경우, 
    //    - 로컬에 접속할 때 타임아웃 설정이 정상적으로 동작되지 않는다.(확인 할 것!) // 로컬은 바로 확인가능하므로 즉시에러띄움  서버가 띄우지않으므로, 타임아웃제대로 테스트하려면 원격으로 테스트해라 
    //    - 원격 윈도우 PC에 서버를 실행하여 접속한다면 정상적으로 동작한다.
    //
    System.out.println("서버와 연결 중...");
    socket.connect(socketAddress, 3000); // timeout : milliseconds - 메서드호출 : 여기서 타임아웃시간 지정  
    System.out.println("서버와 연결되었음!");

    keyScan.nextLine(); // 사용자가 엔터를 칠 때까지 다음 코드로 이동하지 않는다.

    socket.close();
    System.out.println("서버와의 연결을 끊었음.");

    keyScan.close();
  }
}

//타임아웃 여러가지 방법이있음
//기본방식이 마음에 안들때 
