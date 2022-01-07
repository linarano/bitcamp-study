package com.eomcs.mylist.domain;

public class Contact {
  String name;
  String email;
  String tel;
  String company;

  public Contact() {
    System.out.println("Contact() 호출됨!");
  }


  public Contact(String csvStr) { //객체를 만들어 파라미터로 들어오 csv
    // 예) "홍길동,hong@test.com,010-1111-2222,비트캠프"
    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com","010-1111-2222","비트캠프"]
    this.setName(values[0]); // 배열에 들어 있는 각 항목을 객체의 필드에 저장한다.
    this.setEmail(values[1]);
    this.setTel(values[2]);
    this.setCompany(values[3]);


  }

  //적용 기술
  // => 스태틱 메서드 : 특정 인스턴스에 종속되지않고 사용하는 메서드
  //= > GoF의 'Factory Method' 패턴
  // 객체 생성 과정이 복잡할 경우 new 명령을 통해 직접객체를 생성하는 대신에
  //메서드를 통해 객체를 리턴받는다.

  public static Contact valueOf(String csvStr) { // 직관적이게 우리도 만들어보자. 팩토리메서드 적용해라는 말의 의미 복잡한코드를 캡슐화(감춘다)- 메서드안에 숨긴다.
    // 예) "홍길동,hong@test.com,010-1111-2222,비트캠프" // 복잡한 코드를 메서드로 감추고 그걸 다시 클래스로 감추는 것 //value of는 팩토리 메서드 파라미터만 넘겨준다면 
    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com","010-1111-2222","비트캠프"]

    Contact contact = new Contact();
    contact.setName(values[0]); // 배열에 들어 있는 각 항목을 객체의 필드에 저장한다.
    contact.setEmail(values[1]);
    contact.setTel(values[2]);
    contact.setCompany(values[3]);

    return contact;


  }

  // 적용 기술
  // => 인스턴스 메서드
  // 인스턴스 메서드: 특정인스턴스를 사용한다면 인스턴스 메서드로 만들라!
  //  => + GRASP: Information Expert
  // 데이터를 가공하는 기능은 그 데이터를 갖고있는 클래스에 둬야한다.
  //
  public String toCsvString() {//현재 연락처정보를 사용할것이므로 인스턴스메소드
    return String.format("%s,%s,%s,%s",//모든인스턴스메서드 this , 순수하게 하나의 문자열로 리턴
        this.getName(), 
        this.getEmail(), 
        this.getTel(),
        this.getCompany()) ;
  }

  @Override
  public String toString() {
    return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + ", company=" + company
        + "]";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }


}
