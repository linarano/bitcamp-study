package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.MemberService;;

@RestController
public class MemberController {

  @Autowired
  MemberService memberService;

  @RequestMapping("/member/signup")
  public Object signUp(Member member) {
    if( memberService.add(member) ==1) {
      return "success";
    }else {
      return "fail";
    }
  }

  @RequestMapping("/member/signin") //스프링부트가  on인 경우 true로 인식. 에러가 뜨면 스트링으로 받거나 값이 안넘어와서 그런것
  public Object signIn(String email, String password, boolean saveEmail, HttpServletResponse response, HttpSession session) { //계속 정보를 가질 수있도록 
    Member loginUser = memberService.get(email,password); //사용자정보를 달라고하자 
    if(loginUser==null) { //json 일반문자열로 보내면 안돼 ,널도 보내면 안됨 
      return "fail"; 
    }
    // 로그인이 성공하면,
    // 다른 요청을 처리할 때 로그인 회원의 정보를 사용할 수 있도록 세션에 보관한다.
    session.setAttribute("loginUser", loginUser);

    Cookie cookie = null;
    if (saveEmail) {
      //이메일을 쿠키로 보낸다.(서버렌더링방식)
      cookie = new Cookie("userEmail", email); // 쿠키로 보내는건 문자열만 가능, 세션은 객체보낼수있음
      //웹브라우저 실행동안에는 쿠키를 가지고 있어라 웹브라우저를 닫으면 쿠키를 날아감
    }else{
      cookie = new Cookie("userEmail","");
      cookie.setMaxAge(0); //이메일 체크 해제-이제 무효하니까 삭제해 웹브라우저ㅑㅇ
    }
    response.addCookie(cookie);

    return "success";
  }

  //단순히 결과를 넘기는게 아니라 조직적으로 
  // 기본생성자는 직관적이지 못함 

  @RequestMapping("/member/getLoginUser")
  public Object signUp(HttpSession session) {
    Object member = session.getAttribute("loginUser");
    if(member != null) {
      //return new ResultMap("success",data);
      return new ResultMap()
          .setStatus(SUCCESS) //문자열은 오타날 가능성이높다
          .setData(member); //위의방식과 비교해 한눈에 알아보기 쉽다
    }else {
      return new ResultMap()
          .setStatus(FAIL)
          .setData("로그인하지 않았습니다");
    }
  }
  //제이슨은 겟.셋메서드만 메서드로 인정 

  @RequestMapping("/member/signout")
  public Object signIn(HttpSession session) { //계속 정보를 가질 수있도록 
    session.invalidate();
    return new ResultMap().setStatus(SUCCESS);
  }
  @RequestMapping("/member/facebookLogin")
  public Object facebookLogin(String accessToken, HttpSession session) {

    // 1) accessToken을 가지고 페이스북으로 가서 로그인 사용자 정보를 가져온다.
    RestTemplate restTemplate = new RestTemplate(); //자바에서 http 요청처리해주는 도구
    Map<String,String> result = restTemplate.getForObject( // 서버에 담은걸 맵에 담으면 꺼내쓰기 편함 -겟요청해주는 메서드
        "https://graph.facebook.com/v13.0/me?access_token={value1}&feilds={value2}",//요청할 URL 
        Map.class, //서버에서 받은 결과의 타입 - 단 제이슨또는 xml형식이어야함
        accessToken, // URL의 첫번째에 들어갈 값
        "id,name,email,gender" //페이스북 측에 요청하는 로그인 사용자정보
        );

    //2) // 사용자 이름과 이메일을 알아낸다.
    String name =result.get("name"); //아이디는 페이스북아이디니까 필요없다.
    String email =result.get("email");


    //3) 현재 등록된 사용자 중에서 해당 이메일의 사용자가 있는지찾는다. 
    Member member =  memberService.get(email);//이메일로 찾아낸다. 

    //4-1) 등록된 사용자가 있으면 그 사용자로 자동로그이넟리
    if(member !=null) {
      session.setAttribute("loginUser", member);
      return new ResultMap().setStatus(SUCCESS).setData("기존회원 로그인"); 

    }else {
      //4-2) 등록된 사용자가 아니라면 자동으로 회원등록 후 자동로그인 처리한다. 
      // member = new member().setEmail(email).setName(name).setPassword("1111");
      memberService.add(new Member()
          .setEmail(email)
          .setName(name)
          .setPassword("1111"));
      session.setAttribute("loginUser",memberService.get(email));
      return new ResultMap().setStatus(SUCCESS).setData("새회원로그인"); 
    }
  }
}