package com.eomcs.mylist.dao;

import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Member;

@Mapper  
public interface MemberDao {

  int insert(Member member);

  //  Member findByEmailAndPassword(@Param("email") String email,@Param("password") String password);// a라는 변수에 들어온 값을 (일관성떄문에 똑같게 만들어라 )SQL 맵퍼에서 이이름으로 꺼내라
  Member findByEmailAndPassword( String email, String password);// a라는 변수에 들어온 값을 (일관성떄문에 똑같게 만들어라 )SQL 맵퍼에서 이이름으로 꺼내라

  Member findByEmail(String email); //1개일때는 파람지정할 필요없다.

  //List<Member> findAll();

  // Member findByNo(int no);

  //int update(Member member);

  // int delete(int no);

}











