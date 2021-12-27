package com.eomcs.mylist;

public class Contact {
  String name;
  String email;
  String tel;
  String comapny;


  @Override
  public String toString() {
    return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + ", comapny=" + comapny
        + "]"; // 이 설계도에 따라서 만든 인스턴스변수의 값을 한줄의 문자열로 만들어서 리턴해주는 메소드
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


  public String getComapny() {
    return comapny;
  }


  public void setComapny(String comapny) {
    this.comapny = comapny;
  }


}
