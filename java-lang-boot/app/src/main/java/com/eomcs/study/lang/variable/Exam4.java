//변수활용
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.Exam4")//클래스이름이 같을때 충돌방지
@RequestMapping("/lang/variable/exam4")
public class Exam4 {
//스프링 부트는 클라이언트가 보낸 값을 파라미터타입에 맞춰 자동형변환을 수행한다.
//=> 웹브라우저가 보내는 값은 무조건 "문자열이다."무얼보내든- 게시글, 단 파일업로드는 바이너리형식으로 보내짐, 날짜든뭐든 다 문자열 
 
  //테스트 경로 
  //=>100=> byte
  @GetMapping("/test1")
  public String test1(int v1, int v2, String op) {
      int result = 0;
      
      switch(op) {
        case "+": result = v1 + v2; break;
        case "-": result = v1 - v2; break;
        case "*": result = v1 * v2; break;
        case "/": result = v1 / v2; break;
        case "%": result = v1 % v2; break;
        default : return "해당 연산을 수행할 수 없습니다.";
        
        
        
      }
      
    String html =  "<!DOCTYPE html>"
     +" <html>"
     + "<head>"
     +"<meta charset=\"UTF-8\">"//이거 일반문자야라고 알려주는 것
     + "<title>변수활용</title>"
     + "</head>"
     +"<body>"
     +"<h1>계산 결과 </h1>"
     + "<p>"+ v1 + " " + op + " " + v2 + " = "+ result + "</p>"  
     +"</body>"
     +"</html>";
     
  return html;
  }
  
  //테스트 경로 
  //=>100=> byte
  @GetMapping("/test2")
  public Object test2(int v1, int v2, String op) {
    System.out.println(">"+v1+"<");  
    System.out.println(">"+v2+"<");
    System.out.println(">"+op+"<");//서버에서 보여줘 
    
    int result = 0;
        switch(op) {
        case "+": result = v1 + v2; break;
        case "-": result = v1 - v2; break;
        case "*": result = v1 * v2; break;
        case "/": result = v1 / v2; break;
        case "%": result = v1 % v2; break;
        default : return "해당 연산을 수행할 수 없습니다.";
        }
           
  return result; //클래스 코드묶음 특정기능 단위로 - result를 문자로 바꿔주는 것. 정수를 다루는 기능
  }
  
  
  //=>100=> byte
  @GetMapping("/test3")
  public Object test3() {
    
    String[]names = {"홍길동", "임꺽정", "유관순", "안중근"};
    
    return names;//스프링부트는 이 메서드가 리턴한 배열을 JSON 형식의 문자열로 바꿔 리턴한다.
        }
    }

