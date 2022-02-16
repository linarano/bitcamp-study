package com.eomcs.algorithm.data_structure.array3;

public class Test2 {
  public static void main(String[] args) { // 제네릭(일반적인)
    ArrayList<Score> list = new ArrayList<Score>();// 객체 선언할 때   Score를 쓸꺼야  -> 이 어레이리스트에는    Score를 넣을꺼야 
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("안중근", 100, 100, 100));
    list.add(new Score("유관순", 100, 100, 100));
    list.add(new Score("윤봉길", 100, 100, 100));
    list.add(new Score("김상옥", 100, 100, 100));

    // 불편2:
    // 목록에서 값을 저장할 때 원하지 않는 타입의 값이 들어가는 것을 막을 수 없다. (처음부터 막는게 가장좋다)
    //=> 목록에서 다룰 항목의 타입을 정하고,  add() 메서드에서 그 타입의 값을 받도록 정의한다.
    //=> 그러면 ArrayList를 생성할 때 지정한 타입이 아닌 경우 컴파일 오류가 발생한다.
    //
    list.add(new String("오호라")); //=> 잘못 들어간것을 막고, 꺼낼때 지정안해줘도됨 

    for (int i = 0; i < list.size(); i++) {
      Score s = list.get(i); 
      System.out.printf("%s:%d, %f\n", s.name, s.sum, s.aver);
    }
  }
}


//문법은 불편해서 편하게 할려고 나온다.
//문법을 강화시키는 이유 - 원래대로 안쓰고 자꾸 이상하게 쓸려고
//만드는 의도대로 쓰지않기 때문에 문법이 점차 강화되는 것