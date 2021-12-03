//배열: 같은 종류의 메모리를 여러개 만드는 명령문
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam2")//스피링부트가 관리할때 쓰는 클래스이름이 같을때 충돌방지
@RequestMapping("/lang/variable/exam2")//웹브라우저가 요청할 떄 사용하는 경로명
public class Exam2 {
  
  //배열 사용전
  //-값을 저장할 메모리를 담는 명령문
  @GetMapping("/test1")
  public String test1(String name1, String name2, String name3, String name4, String name5, String name6, String name7) {
      
    return "=> " + name1 + "," + name2 + "," + name3 + "," + name4 + "," + name5+ "," + name6 +"," + name7;
  }
  //배열 사용후
  @GetMapping("/test2")
  public String test2(String[] name){
      
    return "=> " + name[0] + "," + name[1] + "," + name[2] + "," + name[3] + "," + name[4]+ "," + name[5] +"," + name[6];
  }

  
}
