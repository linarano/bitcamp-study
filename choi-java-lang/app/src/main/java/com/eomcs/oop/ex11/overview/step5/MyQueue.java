package com.eomcs.oop.ex11.overview.step5;

public class MyQueue extends MyList {

  public void offer(Object obj) {
    this.add(obj);
  }

  public Object poll() {
    if (size == 0) {
      return null;
    }
    return remove(0);
  }

  @Override
  public Iterator iterator() //리턴타입   Iterator
  {
    return new QueueIterator(); // myQueue.iterator(); //빌트인 파라미터 This
  }


  class QueueIterator implements Iterator {

    // 커서 필요없다 팝으로 꺼낼꺼니까 



    @Override
    public boolean hasNext() {
      return MyQueue.this.size() > 0; // 비교연산자의 리턴값 
    }


    @Override
    public Object next() {
      return MyQueue.this.poll();
    }

  }
}

