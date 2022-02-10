package com.eomcs.oop.ex11.overview.step4;

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


  static public class QueueIterator implements Iterator {
    MyQueue queue;
    // 커서 필요없다 팝으로 꺼낼꺼니까 

    public QueueIterator (MyQueue queue) {
      this.queue = queue;
    }

    @Override
    public boolean hasNext() {
      return queue.size() > 0; // 비교연산자의 리턴값 
    }


    @Override
    public Object next() {
      return queue.poll();
    }

  }
}

