package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

// 서브클래스의 공통 분모를 추출하여 슈퍼클래스를 정의한경우,
// 직접사용하려고 만든 클래스가 아니다.
//단지 서브클래스에게 공통 분모를 물려주려고 만든 클래스이다. 
// 이런 경우 추상클래스로 선언한다. 
// 추상클래스만이 추상 메서드를 가질 수 있기 때문에
//반드시 추상클래스로 선언해야한다. 
//
public abstract class AbstractBoardDao implements BoardDao { // 데이터 처리는 무조건 DAO에가 맡긴다. 

  // 서브클래스에서 접근해야할 필드라면 
  //접근범위를 protected로 설정한다.
  //defualt는 같은 패키지만 가능 
  //
  protected ArrayList boardList = new ArrayList(); // 변수 선언 = 변수를 만들라는 명령!

  // 데이터를 저장하는 save() 메서드가 반드시 있어야한다. - 여러 메서드에서 save()를 사용한다.
  // 데이터를 저장하는 방법은 서브클래스마다 다르다. 
  // 수퍼클래스에서 save()메서드를 구현해봐야 의미가 없다.
  //- 어차피 서브클래스에서 재정의
  // 이런 경우 해당메서드를 "추상메서드로 선언한다."
  //있어야 하는 클래스이므로 수퍼클래스에 두는 것 
  //서브클래스에서 오버라이딩 할 수 있도록 접근가능하도록 해야한다.
  //-서브클래스가 다른 패키지에 있을 수도 있다.
  //- 이런 경우 메서드의 접근범위를 protectedc
  //
  protected abstract void save() throws Exception;


  @Override
  public int countAll() {
    return boardList.size();
  }


  @Override
  public Object[] findAll() {
    return boardList.toArray();
  }


  @Override
  public void insert(Board board) throws Exception {
    boardList.add(board);
    save(); //디스생략가능(자바스크립트는 안되) , 넘어온 주소를 넘김 // 오류났을때, 내가 처리할건지, 오류를 던질지 결정 다시리턴할지 DAO는 오류를 처리하지말고 전달해야함. 보드컨트럴러가 처리할일 
  }
  //현업에서 insert의 리턴값은 1개 - 객체들어가는 것
  //우리는 들어갈때마다 1


  @Override
  public Board findByNo(int no) {
    if (no < 0 || no >= boardList.size()) {
      return null;
    }
    return (Board) boardList.get(no);
  }


  @Override
  public int update(int no, Board board) throws Exception { // 나중에 업데이트하자 다른기능과함께 , 업데이트를 호출할 컨트럴러에게 예외를 던져라. 직접처리할지말고 
    if ( no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.set(no, board);
    save(); //추가변경삭제한후, 서버꺼버리면 세이브가 안된상태로 종료. 업데이트할때마다,ㅡ 삭제할때마다 바로 저장. 더이상 세이브호출할 필요없이. , 어차피 dbms로 바꿀꺼다. (파일출력 담당하는 프로그램이 따로있지않냐)
    return 1;
  }


  @Override
  public int delete(int no) throws Exception {
    if (no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.remove(no);
    save();
    return 1;
  }


  @Override
  public void increaseViewCount(int no)  throws Exception  {
    Board board = findByNo(no);
    board.setViewCount(board.getViewCount() +1);
    save();
  }
}

//서브클래스마다 save() 방식이 다름
















//