package com.eomcs.mylist.domain;

public class ContactTel {

  int no;
  int contactNo;
  int telTypeNo;
  String tel;

  public ContactTel() {} // 기본생성자는 꼭 만들어줘야돼 ,값을 안만들수도있으니
  //  public ContactTel(int contactNo, int telTypeNo, String tel) { //포린키가 빠지면 인서트가 안됨 ㅡmlcontact 값이 들어갔으나, 연락처 정보는 인스트해야 프라이머리키값을 알수있고, 그 번호를 가지고 인서트하는것  
  //  this.contactNo =contactNo; //select  * from ml_cont_tel;값이 안들어감 
  //  this.telTypeNo =telTypeNo;
  //   this.tel = tel;
  // } 
  public ContactTel(int telTypeNo, String tel) {
    this.telTypeNo = telTypeNo;
    this.tel = tel;
  }

  public ContactTel(int contactNo, int telTypeNo, String tel) {
    this(telTypeNo, tel); // 중복코드해결 - 다른 생성자에서 맡기자 (트럭예제확인 - 상속쪽)
    this.contactNo = contactNo;
  }


  @Override
  public String toString() {
    return "ContactTel [no=" + no + ", contactNo=" + contactNo + ", telTypeNo=" + telTypeNo
        + ", tel=" + tel + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getContactNo() {
    return contactNo;
  }

  public void setContactNo(int contactNo) {
    this.contactNo = contactNo;
  }

  public int getTelTypeNo() {
    return telTypeNo;
  }

  public void setTelTypeNo(int telTypeNo) {
    this.telTypeNo = telTypeNo;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }



}
