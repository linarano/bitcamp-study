package com.eomcs.oop.ex05.x1.upgrade5;

// 5) 계산기 기능 확장 방법5 - 의존 객체 주입 방식을 적용하여 기능 확장
//    - 곱하기 계산 기능 추가
//    - 기존의 Calculator 객체를 포함한 후 새 기능을 추가하기
//
public class CalculatorTest {
  public static void main(String[] args) {

    com.eomcs.oop.ex05.x1.Calculator calculator = new com.eomcs.oop.ex05.x1.Calculator(); 

    Calculator2 upgradeCalculator = new Calculator2(calculator);

    upgradeCalculator.plus(100);
    upgradeCalculator.minus(200);
    upgradeCalculator.multiple(2);

    System.out.println(upgradeCalculator.getResult());
  }
}


// 위임
//-상속은 코드가 경직 (상속관계의 경우, 불필요한 기능을 자유롭게 뺄수 없다. 유연성이 부족하다.)
//  필요한 객체만 포함 불필요하면 뺴버리면 된다. 

//4과 차이 - 이미 계산기객체를 내장하고 있음 4번은 - Cal와 Cal2는 생명주기같다. (사람과 심장의 관계 - 자동차와 엔진처럼) - Composition관계 연결이 강함
//2를 만들때 1도 같이 만들어진다. 만들어질때 같이 만들어진다.  따로 안만들어준다. 4

//의존객체주임  5번 - 계산기 객체를 밖에서 - 주소를 잊어버리더라도 계속 존재한다. 연결이 느슨 - Aggregation Calculator2와  Cal과 같지않음. 라이프사이클이 다르다. 
// 각각 따로만들어진다. 블랙박스와 자동차처럼  자동차 구매후 블랙박스 포함시킨다. 장착하면 계속 자동차에서사용 뗴지않고, 블랙박스소속은 자동차가 맞다. (포함하지만 자동차폐차로, 블랙박스가 폐차아님)(
// 자동차가 굴러갈때 블랙박스도 달려서 함께 굴러간다. 포함관계 
//포함하는데 외부에서 주임받는다.  name = new ();
// 이점이 있다. 번거롭지만 