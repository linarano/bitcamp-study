package com.eomcs.algorithm.data_structure.array3;

public class Test {
  public static void main(String[] args) {
    ArrayList<Score> list = new ArrayList<Score>(); //이변 수를 사용하는 모든 곳에 Score가 들어감 
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("안중근", 100, 100, 100));
    list.add(new Score("유관순", 100, 100, 100));
    list.add(new Score("윤봉길", 100, 100, 100));
    list.add(new Score("김상옥", 100, 100, 100));
    list.add(new String("오호라"));

    for (int i = 0; i < list.size(); i++) {
      // 불편1:  => 해결 
      // => 목록을 생성할 때 목록에서 다룰 항목의 타입을 Score로 선언한다.
      //=> 그러면  get() 메서드의 리턴타입은  Score가 된다.
      // => 따로 형 변환할 필요없다.      
      //
      Score s = list.get(i); // 문법적으로 Object를 꺼내도록 되어있으므로 컴파일러에게 알려줘 //-> 해결 컴파일러는 스코어로 봄 
      System.out.printf("%s:%d, %f\n", s.name, s.sum, s.aver);
    }
  }
}
