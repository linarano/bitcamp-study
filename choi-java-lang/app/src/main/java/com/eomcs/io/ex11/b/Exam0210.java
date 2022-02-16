// 인스턴스 입출력 - ObjectOutputStream으로 인스턴스 출력하기
package com.eomcs.io.ex11.b;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    // ObjectOutputStream
    // => DataOutputStream의 기능을 포함한다.
    // => 인스턴스를 바이트 배열로 만들어 출력하는 기능(writeObject())이 있다.
    // => 단 java.io.Serializable 인터페이스를 구현한 클래스에 대해서만 가능하다.
    //
    FileOutputStream fileOut = new FileOutputStream("temp/member2.data");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);

    Member member = new Member();
    member.name = "AB가각간";
    member.age = 27;
    member.gender = true;

    // ObjectOutputStream에는 인스턴스의 값을 바이트 배열로 만들어 출력하는 기능이 있다.
    //
    // writeObject()
    // - java.io.Serializable 이 선언된 클래스의 객체만 출력할 수 있다.
    // - 인스턴스의 필드 값을 바이트 배열로 만들어(직렬화) 출력한다.
    // - 인스턴스의 필드의 값만 출력하는 것이 아니다.
    // - 클래스 이름과 인스턴 변수의 정보도 함께 출력한다. ,class가 출력되는게 아니라 
    //       출력데이터 = 클래스이름(명) + 인스턴스 변수 정보 + 인스턴스 변수 값 + 버전***
    //
    out.writeObject(member);
    // 그러나 실행하면 오류가 발생한다.
    // => java.io.NotSerializableException
    // => 인스턴스의 값을 자동으로 바이트 배열로 만들 수 있도록 허락되지 않아서
    //    발생한 실행 오류이다.
    //
    // Member 클래스가 java.io.Serializable을 구현하면
    // 바이트 배열로 자동 변환하는 것이 가능하다.
    // writeObject()를 호출하여 인스턴스의 값을 출력할 수 있다.(인스턴스 통쨰로내보내겠다는 의미)
    //

    out.close();
    System.out.println("데이터 출력 완료!");
  }

}


//용어 정리!
//1) Serialize(직렬화)
// - 객체(인스턴스) ===> 바이트 배열
// - marshalling 이라고도 부른다.
//
//2) Deserialize(객체 복원)
// - 바이트 배열 ===> 객체
// - unmarshalling 이라고도 부른다.
//

// 초심자때는 실행속도,퍼포먼스 신경쓰지마라  그렇게 말하는 사람말 무시
//속도 신경쓰면 절대 객체지향 문법을 쓰면 안된다.
//메서드 1개 만들것 잘개 쪼개서 여러개 만드는 것
//클래스 1개만들걸 여러개
//클래스1번 호출이 아니라 여러호출
//객제지향문법, 설계기법에 충분히 노출되어라. 

//메모리,파일크기 신경쓸것없다.
//오로지 지금 내가 짜는 코드가 객체지향다우냐
//객체지향 신경쓰다가 못만들면 안됨

//일단 만들어서 돌아가야돼
//리팩톨이 통해서 우리가 할수있는 만큼만 해라.
//현재 수준이 3이면 3만큼의 실력으로 객체지향 코드를 만들면 된다.
//실력이 커갈수록 코드가 바뀔것.

//단, 노가다 10년한다고 건축물 설게할 수 있나
//설계기술필요 
//프로그램 많이 짠다고 객체지향 프로그래밍이 되는게 아니다. 
//끊임없는 공부가 필요 -> 객체지향코드를 위해서 
//가만히 앉아서 된느것 없다.

//일단 돌아가게 해라. 
//단 유지보수가 더 잘되는게 중요 , 메모리나 실행속도에 매몰되지마라.