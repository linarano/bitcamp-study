package com.eomcs.net.ex12.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ChatClient() {
    //기본생성자말고
    super(" 채팅");
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    Panel topPanel = new Panel();//(new FlowLayout(FlowLayout.LEFT);
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 추가 기본생성자로 해도되지만 이해됩기 위해서 
    // this.setSize(400,300); - 절대그냥호출하는 것 없다. 메서드호출하는데 주소없으면 스태틱메서드 호출하거나, this 생략
    setSize(400,300); // 정보를 설정해달라고 파라미터로 넘겼으니까 어디위치의 변수에 바꿔야하는지 알려줘야지
    TextField addressTf = new TextField(4); // 입력상자 만듬 
    topPanel.add(addressTf); //센터영역에 들어간다. 

    TextField portTf =new TextField();
    topPanel.add(portTf); // 

    Button connectBtn = new Button("연결!");
    topPanel.add(connectBtn);

    add(topPanel, BorderLayout.NORTH);
    TextArea messageListTa = new TextArea();
    add(messageListTa, BorderLayout.CENTER);

    Panel bottomPanel = new Panel();

    TextField messageTf = new TextField(40);
    bottomPanel.add(messageTf);

    Button sendBtn = new Button();
    bottomPanel.add(sendBtn);

    add(bottomPanel, BorderLayout.SOUTH);
    this.setVisible(true);
  }
  public static void main(String[] args) {
    new ChatClient();

  }
}

//자바클래스 안에 놓여지면- CahtClient 메인이라는 메서드 안에서만 사용하는 클래스구나 직관적 이해 
//인터페이스 구현은 모든 메서드를 오버라이드해서 만들어야 ->단점극복  adopter 직접구현하지말고 상속받아라




// 익명클래스 (중첩클래스의 한종류- 클래스 안에 클래스 ) - 더 직관적이다. 

//Frame f = new Frame("계산기");
// f.addWindowListener(new WindowAdapter(){ //익명클래스-클래스정의한후, 객체만든다음, 객체주소를 준다는 의미 // 슈퍼클래스 생성자 호출 - 클래스이름이 없다. - 생성자에 이름이 없는게 존재 못하므로 슈퍼클래스의 생성자를 호출할 수 밖에 없다.
//@Override
// public void windowClosing(WindowEvent e) {
// 윈도우의 X버튼을 눌렀을 떄 - 닫아야지 이벤트가 발생한다.
// System.exit(0);// 정상적종료 -0(파라미터) // a nonzero statuscode indicates abnormal termination. 
//}

//    });// 인스턴스 주소 주면 - 무조건 인스턴스 메서드로 만들어 나중에 대응하기 위해서 혹시 사용할지모르므로 
//  f.setSize(400, 300); //사이즈 지정 
//프로엠인스턴스 안에 설정된 정보대로 윈도우 만들어달라고 윈도우에 요청
//f.setVisible(true);
//}


//윈도우에 관d련된 정보가 셋팅- 그 저오를 담을 인스턴스필드가 만들어지고 값들이 설정 
//내부에서만 쓴다. 딱 한번만 쓰이는 마이윈도우리스너 -> 중첩클래스로 만들어 밖에따로 두지말고 - 메서드안에 퍼플릭이고 안됨 -로컬중첩클래스는 퍼블릭안됨

//컴파일할때 따로 클래스 만듬 - 별도로 잘라내지면서 클래스를 따로만든다ㅏ. 또,  클래스 정보가 붙는것  - 제약조건 이 클래스는 ChatClient의 main()에서만 사용할 수 있습니다. 

//일반클래스 =>패키지멤버 클래스는 아무데서나 만들 수 있다. 같은 패키지에서만 접근하는게 아니라 딴놈들은 접근할수 없고, 특정 클래스만 접근 고민하다 나온결과
// 가위를 601호라고 적고 복도에 둘거냐 밖에둘거냐 

//언어를 만드는 개발자들의 고민 - main() 안에서 딱1번만 쓰는데, 밖에서 쓰지도않고, 못쓰게 말도록 제어. 밖에서 쓸수있게 안쓸수 있게냐의 고민 
// 어떤 클래스는 안에서만 밖에서만 ,또는 특정클래스의 특정메서드 안에서만 사용하도록 

//자바가 아니라 윈도우에서 띄우는거 기때문에 인코딩이안맞으므로 인코딩을 설정해줘야한다. ㅕㅆㄹ-8 => MS949

//패널은 컨테이너인데 모든 컨테이너는 기본레이아웃 관리자가 있음  - 여기서 설정 바꿔주면 된다. 