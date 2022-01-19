package com.eomcs.oop.ex05.x2;

public class Engine {
  int cc;
  int valve;

  public void run() {
    // 하이브리드 전기차 구동 기능 추가
    if(kwh >0) {
      System.out.println("전기로 간다!");
      return;
    }

    // 트레일러 장착 기능이 추가되었다면 다음과 같이 run() 메서드를 변경해야 한다.
    if (trailer == null) {
      System.out.println("씽씽달린다!");
    }else {
      System.out.println("느릿느릿 조심히 움직인다. !");//  이미여기저기서 쓰고있는데, 못바꾸니까 2
    }
  }

  // 자동차 기능 추가
  public void start() {
    System.out.println("시동건다!");
  }

  public void stop() {
    System.out.println("시동끈다!");
  }

  //  트럭기능 추가 
  public void dump () {
    System.out.println("짐내린다!");
  }
  // 트레일러
  CampingTrailer trailer;
  public void setTrailer(CampingTrailer trailer) {
    this.trailer  = trailer;
  }//인스턴스변수ㅏㄱ 꼭 위에 갈필ㅇ없음 

  //    // 트레일러 달고달리는 경우와 구분 , 다른데서 쓰니까 변경불가 
  //    // 새로운 메서드 추가 
  //    public void run2() {
  //      //오버라이딩이 필요하겠지?ㅋㅋㅋ 같은 메서드를 또 만드는거니까. 

  // 하이브리드 자동차 기능 추가
  int kwh;
  public void chargeBattery (int kwh) {
    this.kwh = kwh;
  }
}






//기존코드에 덕지덕지 , 버그발생안하더라도 클래스가 무거워지고 있음 , 버그발생 가능성이높아짐 다양한예제를 통해서 보여주곘다. 
//처음 시작은 가벼웠으나
//ㅌ츠럭추가하면서 기존메서드에 덤프추가
//캠핑가 하면서 셋트레일ㄹ러 메서드 추가 , 기존 메서드 run 변경
// 기능 게속 추가되면 난리도 아님 

//수정사항이 생기면 한클래스만 사용 - 단점 엔진클래스에 덕지덕지 붙어있다. 유지보수에 안좋다.
//장점 한군데만 바꿔주면 된다.  - 여러 프로그램들이 엔진클래스를 모두 쓰기때문에- 1번만 바꿔주면 된다. 기능변경은 쉽다