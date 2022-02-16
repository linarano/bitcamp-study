// URL 클래스를 이용하여 HTTP 요청 수행하기
package com.eomcs.net.ex08;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    // URL 클래스를 이용하면 HTTP 프로토콜을 신경쓰지 않고
    // HTTP 요청을 수행할 수 있다.
    // 특히 HTTPS까지도 처리할 수 있다.**** -> 이게 안되면 프로그램 코딩이 장난아님. 직접소캣작성할 필요없이 이 클래스걸사용해라. 

    // => URL 주소를 검증하고 준비한다.
    URL url = new URL("https://sports.news.naver.com/index");

    // => 서버와 연결하고 HTTP 요청을 수행한다.
    // => 그런 후에 웹서버의 응답 데이터를 읽어들일 도구를 준비한다.
    InputStream in = url.openStream(); // 웹서버 연결 URL에 지정된 서버로 요청을 날린다. - 한줄씩 읽어드리는 기능이 없으므로 버퍼 붙여 

    // => 서버가 보낸 데이터를 한 줄씩 읽기 위해 데코레이터를 붙인다.
    BufferedReader in2 = new BufferedReader(new InputStreamReader(in));

    while (true) {
      String str = in2.readLine();
      if (str == null)
        break;

      System.out.println(str);
    }

    in2.close();
    in.close();
  }

}

// 응답헤더는 뺴버리고 웹서버가 웹브라우저에게 응답하는 정보 빼고 
//응답헤더 다음에 오는 한줄 다음에 오는게 나나온다. (데이터만)
//빈줄다음에

//
//<!DOC>

//간단하게 크롤링할 떄 사용할 수 있다. 
//컨텐츠가 한번에 넘어오는게 아니라
//기본 HTMl 컨턴츠만 넘어오고
//다 따로 요구해야함 


// 컨텐츠만 꺼낼 수 있음 - 210번과 비교 