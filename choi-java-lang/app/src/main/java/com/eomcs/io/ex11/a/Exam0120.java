// 인스턴스 입출력 - DataInputStream으로 인스턴스 읽기
package com.eomcs.io.ex11.a;

import java.io.DataInputStream; // Data Processing Stream Class = Decorator
import java.io.FileInputStream; // Data Sink Stream Class = Concrete Component

public class Exam0120 {

  public static void main(String[] args) throws Exception {

    FileInputStream fileIn = new FileInputStream("temp/member.data");
    DataInputStream in = new DataInputStream(fileIn);

    Member member = new Member();

    member.name = in.readUTF(); //저장된 순서대로 읽는다. 반드시
    member.age = in.readInt();
    member.gender = in.readBoolean();

    in.close();

    System.out.println(member); //멤버객체  - toString의 메서드의 값을 준다
  }
}


