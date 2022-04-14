package com.eomcs.mylist.web.Listener;

import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mylist.service.BoardService;
import com.eomcs.mylist.service.MemberService;
import com.eomcs.mylist.service.impl.DefaultBoardService;
import com.eomcs.mylist.service.impl.DefaultMemberService;

//역할:
//- 웹애플리케이션이 시작될 때 서비스 객체, DAO 객체, Mybatis 객체를 준비한다.
//
// 서블릿이 사용할 자원을 준비한다.
//
@WebListener // 리스너라고 서블릿컨테이너에게 알려줘야함
public class ContextLoaderListener implements ServletContextListener { //환경을 초기화
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    //웹 애플리케이션이 시작되면 이 메서드가 호출될 것이다. 
    System.out.println("서비스 및 Dao, 마이바티스 객체 준비");
    try {
      // 1) Mybatis의 SqlSessionFactory 준비
      String resource = "com/eomcs/mylist/conf/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);

      // 2)서비스 객체 생성
      BoardService boardService = new DefaultBoardService(sqlSessionFactory);
      MemberService memberService = new DefaultMemberService(sqlSessionFactory);


      //서블릿 보관소는 특정사용자만 가능
      // 3) 서블릿에서 서비스 객체를 사용할 수 있도록 SevletContext  보관소에 저장한다. - 보관소 여러개 (그중 이건 여러명이 공유하는 보관수)
      ServletContext 웹애플리케이션보관소 = sce.getServletContext();
      웹애플리케이션보관소.setAttribute("boardService",boardService);
      웹애플리케이션보관소.setAttribute("memberService",memberService);

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
