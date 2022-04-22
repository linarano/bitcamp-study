package com.eomcs.mylist.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.mylist.domain.Board;

@Service  // 이 표시가 있어야 객체로 만들고 만들어서 보드컨트럴러를 만들때 생성자를 넘겨준다. //@컴포넌트라고 붙여도되지만, 더 구체적인 표시 
public interface BoardService {

  int add(Board board);

  List<Board> list(int pageSize, int pageNo);

  Board get(int no);

  int update(Board board);

  int delete(Board board);

  int size();
}







//Default보드서비스가 생성자에서 SQlsession팩토리 요구 , 그러나 내가 만든 클래스가 아니므로 애노테이션을 붙일 수없다. (디스패쳐서블릿 객체를 만들듯이 자바소스코드로 해줘야함)