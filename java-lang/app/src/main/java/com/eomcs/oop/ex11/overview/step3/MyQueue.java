package com.eomcs.oop.ex11.overview.step3;

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
    return new QueueIterator(this); // myQueue.iterator(); //빌트인 파라미터 This
  }

}

