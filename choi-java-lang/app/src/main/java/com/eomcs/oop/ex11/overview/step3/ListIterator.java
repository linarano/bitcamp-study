package com.eomcs.oop.ex11.overview.step3;

public class ListIterator implements Iterator {

  MyList list;
  int cursor;// 꺼낼위치 - 가리키고있는 것 // 처음 0 - 사이즈보다 작아야함 같으면 안됨

  public ListIterator (MyList list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() {

    return cursor < list.size();
  }
  //if (cursor  >=  list.size()) {
  //  return false;
  // }
  // return true;
  //}

  @Override
  public Object next() {
    return list.get(cursor++); //  후위연산자  현재커서를 꺼내고, 나중에 커서 카운트 증가 
  }
}


// 데이터를 갖고 있는객체 -컬렉션 객체
//동일한 메서드로 데이터를 꺼내주는 일을 함 -이터레이터
// 항상 한쌍으로 호출해야함  
//꺼낼게 있냐고 묻고 