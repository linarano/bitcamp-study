package com.eomcs.oop.ex11.overview.step7;

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
  public Iterator iterator() {


    return new Iterator() { //  이터레이터 

      // 커서 필요없다 팝으로 꺼낼꺼니까 



      @Override
      public boolean hasNext() {
        return MyQueue.this.size() > 0; // 비교연산자의 리턴값 
      }


      @Override
      public Object next() {
        return MyQueue.this.poll();
      }

    }; // myQueue.iterator(); //빌트인 파라미터 This
  }


}

//익명클래스는 객체생성을 나주엥 따로 할 수 없다. 이름이 없기 때문
// 객체생성 문법과 클래스 정의가 합쳐진다. 
