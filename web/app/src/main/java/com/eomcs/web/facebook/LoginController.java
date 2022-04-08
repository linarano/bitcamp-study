package com.eomcs.web.facebook;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController {

  @RequestMapping("/facebook/login1")
  public Object Login1() {
    //  System.out.println("abc\u2326def"); 이스케이프문자
    return "test..ok!";
  }

  @RequestMapping("/facebook/login2")
  public Object Login2(String accessToken) throws Exception {
    //페이스북 서버에 접속하여 사용자 정보를 요구한다.
    System.out.println(accessToken); // 잘받아왔는지 서버쪽에서 확인

    //RestTemplate 객체를 만들자 

    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(
        "https://graph.facebook.com/v13.0/me?access_token={value1}&feilds={value2}",//요청할 URL 
        String.class, //서버에서 받은 결과의 타입
        accessToken, // URL의 첫번째에 들어갈 값
        "id,name,email,gender" //페이스북 측에 요청하는 로그인 사용자정보
        ); // 달라고 하되 공개되것만 줄것  

    //    return URLDecoder.decode(result, "UTF-8");

    return StringEscapeUtils.unescapeJava(result) ; //@를 유니코드로 보내줬기때문에 우리가 제대로 나오게쓰자
  }  
}
