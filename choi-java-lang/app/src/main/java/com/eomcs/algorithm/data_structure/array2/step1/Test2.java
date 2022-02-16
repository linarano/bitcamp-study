package com.eomcs.algorithm.data_structure.array2.step1;

import com.eomcs.algorithm.data_structure.array2.step2.Score;

public class Test2 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("안중근", 100, 100, 100));
    list.add(new Score("유관순", 100, 100, 100));
    list.add(new Score("윤봉길", 100, 100, 100));
    list.add(new Score("김상옥", 100, 100, 100));

    // 불편2:
    // 목록에서 값을 저장할 때 원하지 않는 타입의 값이 들어가는 것을 막을 수 없다. (처음부터 막는게 가장좋다)
    //
    list.add(new String("오호라"));

    for (int i = 0; i < list.size(); i++) {
      Score s = (Score) list.get(i); //   여기서 에러뜸
      System.out.printf("%s:%d, %f\n", s.name, s.sum, s.aver);
    }
  }
}


//문법은 불편해서 편하게 할려고 나온다.
//문법을 강화시키는 이유 - 원래대로 안쓰고 자꾸 이상하게 쓸려고
//만드는 의도대로 쓰지않기 때문에 문법이 점차 강화되는 것