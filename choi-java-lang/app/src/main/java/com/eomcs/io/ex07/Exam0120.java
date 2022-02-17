// DataBufferedFileOutputStream을 이용하여 객체 출력
package com.eomcs.io.ex07;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    DataBufferedFileOutputStream out = new DataBufferedFileOutputStream("temp/members.data"); //버퍼기능 추가

    Member member = new Member();
    member.name = "AB가각간";
    member.age = 27;
    member.gender = true;

    long start = System.currentTimeMillis();

    for (int i = 0; i < 1000000; i++) {
      out.writeUTF(member.name);
      out.writeInt(member.age);
      out.writeBoolean(member.gender);
    }

    long end = System.currentTimeMillis();

    out.close();

    System.out.println("출력 완료!");
    System.out.printf("경과된 시간: %d\n", end - start);
  }

}

//버퍼 쓰고 안쓰고 하늘꽈 땅차이