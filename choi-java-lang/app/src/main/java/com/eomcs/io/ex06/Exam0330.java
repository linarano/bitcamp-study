// BufferedFileInputStream과 BufferedFileOutputStream을 사용하여 파일 복사 및 시간 측정
package com.eomcs.io.ex06;

public class Exam0330 {

  public static void main(String[] args) throws Exception {
    BufferedFileInputStream in = new BufferedFileInputStream("temp/jls11.pdf");
    BufferedFileOutputStream out = new BufferedFileOutputStream("temp/jls11_4.pdf");

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초

    int count = 0;
    while ((b = in.read()) != -1) {
      out.write(b);
      count++;
    }

    // 아직 파일로 출력되지 않고 버퍼 남아 있는 데이터를
    // 마무리로 출력한다.
    // out.flush();

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);
    System.out.println(count);

    in.close();
    out.close();
  }

}

//내부에서 버퍼로 처리
//프로그래밍이 편하게 껍데끼를 씌울수록 실행속도는 떨어짐
//서버를 늘리면 됨. 그 비용이 코드를 작성하는 비용보다 쌈.
//개발자 1명 쓰는 것보다 서버증설비용이 훨씬 쌈 
//개발생산성이 더 낫다.
//껍데기를 적절히씌워라 