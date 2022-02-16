// 서버와 입출력 테스트 - byte stream : Data 주고 받기
package com.eomcs.net.ex03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0130 {
  public static void main(String[] args) {

    try (Scanner keyScan = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // 데코레이터 붙임 
        DataInputStream in = new DataInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결되었고, 입출력 스트림도 준비되었음!");

      // 서버에 데이터를 보내기 전에 잠깐 멈춤!
      System.out.print(">");
      keyScan.nextLine();

      // 서버에 int 값을 전송한다.
      out.writeInt(1567891234); //4바이트 전송 ->  // 랜카드의 메모리로 출력한다. 기다리지않는다. 일단 보낸다.(블로킹이 없음)- 저쪽에서 읽든지 말든지 상관없다. 관련있는건 CPU가 가공해서 보내는 역할을함.  (=> 랜카드의 임시메모리에 저장된다. 출력 ) => 그후 랜카드가 데이터를 가공하여(랜카드 CPU) 인터넷선으로 보낸다. 직접 나가는게 아니다. 
      // 만약 서버에서 읽을 때까지 대기한다면 다음문장이 실행되지않을 것.  즉시리턴한다.// 전송이 완료될때까지 기다리는 것이 아니다. 


      // out.flush();
      // byte stream 을 사용할 때는 바로 출력한다.
      // 따라서 flush()를 호출하지 않아도 된다.
      System.out.println("서버에 데이터를 보냈음!"); //출력시켜놓고 다음줄 실행 

      // 서버에서 보낸 int 값을 읽는다.
      System.out.println("서버의 응답을 기다리고 있음!");
      int value = in.readInt(); // read할때 블로킹 - 데이터가 없으면 못읽음, 수신된 데이터가 메모리에 저장될때까지 기다리는 것. 그래서 블로킹한다.
      System.out.println(value);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


//인터넷 선과 연결된 랜카드 NIC 의 메모리가 있다.
//메모리의 용도 보내는 데이터를 임시보관, 받은 데이터를 App. 가져갈때까지 보관 
//랜카드가 크면 클수록 더 효율적 
//CPU에서 압축해제 후,
//그래픽카드의 메모리에 담아서 가공처리 후 읽는다. ( 메모리가 클수록 많은 데이터를 담는다.)

//일반 CPU 정수 외 다른 연산 가능 
//GPU 3차원 그래픽 좌표인 부동소수점에 특화 - 블록체인 : 채굴한다. - 부동소수점 연산 24시간 한달 내내 생성해서 값을 만들어내는 것.  채굴에 관련한 해쉬알고리즘은 부동소수점

//랜카드 통제 TCP/IP 
//인터넷 속도가 느리다면 받았다는 답이 올때까지 계쏙 보낼것 

//