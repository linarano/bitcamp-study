// local class에서 바깥 메서드의 로컬 변수 접근
package com.eomcs.oop.ex11.d;

// 계산기 사용법을 정의한다. 
interface Calculator{
  double compute(int money);
}

class CalculatorFactory {

  static Calculator create(float interest) { // - 바깥함수의 로컬변수 //스태틱이므로 굳이 바깥클래스 주소 필요없고 

    class CalculatorIml implements Calculator {

      @Override
      public  double compute(int money) {
        // TODO Auto-generated method stub
        return money +(money * interest);
        //interests는 create() 함수의 로컬변수이다.
        //CalculatorImpl 객체를 생성하여 리턴한후에는 interst 로컬 변수는 스택에서 사라진 상탤 것이다.
        // 나중에 compute()를 호출할 떄 interest  변수는 없을 텐데 어떻게 된건가?
        // => 로컬클래스에서 메서드의 로컬 변수를 사용한다면 
        //컴파일러는 로컬클래스에 바깥 메서드의 로컬 변수 값을 저장할 필드를 추가한다. 
        //또한 로컬 클래스의 객체를 생성할 떄 생성자에 로컬 변수의 값을 넘겨 준다. 
      }
    }
    return new CalculatorIml(); // 객체를 만들때 로컬변수값을 넘겨준다. - 객체의 주소 -> 이걸받으려면 생성자만들어야지 -> 받은걸 인스턴스 변수에 담아야지 ->그래서 사용가능
  }
}

public class Exam0310 {

  public static void main(String[] args) {
    Calculator c1 = CalculatorFactory.create(0.02f); //더블이므로 f타입
    Calculator c2 = CalculatorFactory.create(0.08f); 

    //로컬변수니까 사라져야하는게 맞지만 사라지지않도록 컴파일러가 
    System.out.printf("%.2f\n",c1.compute(1230_0000)); // 7자리를 넘어가서 플롯을 쓰면 안됨 -> 웬만하면 더블을 써라. 
    System.out.printf("%.2f\n",c2.compute(1230_0000));
  }
}


//자바스크립트 펑션인 클로저랑 똑같다

//컨퓨트호출 -> 컴파일이 끝나면 이 클래스는 별도의 클래스들로 분리된다. (중첩클래스든 뭐든 마찬가지) -> 따라서 객체를 리턴받으면 로컬변수가 존재하지않음 -> 근데 정확히 계산이 잘되는 이유는?>

//- 클로저에서 바깥쪽 함수에 로컬변수를 쓰게되면 -사라지기 전에 백업해둔다 (클로저 메모리에 백업해둔다)

//인터레

// 자바와 자바스크립트가 동일한 원리 - 클로저와 로컬클래스의 바깥클래스 접근 - 랭귀지배울 때 제대로 배우라는 이유 - 내부적으로 사용할수 있도록 복제해둔다**
//원래킄 메서드 호출이 끝나면 스택에 있던 로컬변수가 다 사라져야하지만
//나중에 컴퓨트가 호출됐을때 인터레스트 변수는 없을 뗀데 불가능 - 그래 서 컴파일러가 우릴 위해 백업한다. -> 함수안에 있는 함수 클로저- 바깥함수의 변수를 사용한다고 하면 내부적으로 클로저내부메모리에 클론해놓는다. 
//로컬변수, 생성자, 객체를 생성할떄 넘겨준다.

//뭔가 자동으로하는건 없다. -> 컴파일러가 기계어로 바꿔준다. 그래서 우리가 편하게 개발한다. 그러나 이해하려면그 원리를 알아야할 필요가 있따. 컴파일러가 변형해준다.

//그렇게 동작하도록

//되는데 어떻게 되는데? -> 자율주행차 그렇게 돌아가도록 코드를 짜도록 우리가 만들었음
// 프로그램이 프로그램 스스로를 짤수없다. 스스로 코드개선 아직까지 --> 그날은 멸망...ㅋ
//스스로 기능확장 

// 조종할 수 있도록 컴퓨터를 짠다면 어떻게 될까. - 매트릭스 - 사람을 밧데리처럼 쓰는 것 -> 기계가 돌아가기 위한 