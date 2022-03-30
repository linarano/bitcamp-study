package com.eomcs.web.html;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@Controller
public class FormController {

  @Autowired
  ServletContext sc; //서버에 배포된 웹 어플리케이션의 경로다루는 객체

  @RequestMapping("/html/form/exam01")
  //@ResponseBody //클라이언트에게 보내줘야할 데이터야 라는 의미
  public Object exam01() {
    return "Hello!";
  }

  @RequestMapping("/html/form/exam02")
  //@ResponseBody //클라이언트에게 보내줘야할 데이터야 라는 의미
  public Object exam02(String name,int age) {
    HashMap<String,Object> map = new HashMap<>();
    map.put("name", name);
    map.put("get", age);

    return map;
  }


  @RequestMapping("/html/form/exam11")
  //@ResponseBody //클라이언트에게 보내줘야할 데이터야 라는 의미
  public Object exam11(String name, int age, MultipartFile photo) {
    System.out.println(name);
    System.out.println(age);
    System.out.println(photo.getOriginalFilename());//오리지널 파일이름 출력

    //    //톰캣 서버에 배치한 웹 애플리케이션의 실제폴더 경로 알아내기 
    //    String uploadFilePath = sc.getRealPath("./temp/" + photo.getOriginalFilename());
    //    System.out.println(uploadFilePath);

    try {
      File photoFile = new File("c:/upload/" + photo.getOriginalFilename()); // 현재폴더(보통 프로젝트폴더)
      photo.transferTo(photoFile);
      //파일을 받았으니 저장 
    }catch(Exception e){
      e.printStackTrace();//에러메세지가 먼지 서버에 띄우자
      return "error";
    }return "okok";
  }


  @RequestMapping("/html/form/exam12")
  //@ResponseBody //클라이언트에게 보내줘야할 데이터야 라는 의미
  public Object exam12(String name, int age, MultipartFile[] photo) { //여러파일은 배열로 받아라
    System.out.println(name);
    System.out.println(age);


    for(MultipartFile part: photo) {

      //    //톰캣 서버에 배치한 웹 애플리케이션의 실제폴더 경로 알아내기 
      //    String uploadFilePath = sc.getRealPath("./temp/" + photo.getOriginalFilename());
      //    System.out.println(uploadFilePath);

      try {
        File photoFile = new File("c:/upload/" + part.getOriginalFilename()); // 현재폴더(보통 프로젝트폴더)
        part.transferTo(photoFile);
        //파일을 받았으니 저장 
      }catch(Exception e){
        e.printStackTrace();//에러메세지가 먼지 서버에 띄우자
        return "error";
      }
    }return "okok";
  }


  @RequestMapping("/html/form/exam21")
  //@ResponseBody //클라이언트에게 보내줘야할 데이터야 라는 의미
  public Object exam21(String name, int age) throws Exception { //여러파일은 배열로 받아라
    System.out.println(name);
    System.out.println(age);

    //비동기 요청이 필요한 이유를 실험한 것
    //Thread.sleep(10000);//10초

    return "okok";
  }


  @RequestMapping("/html/form/exam31")
  //@ResponseBody //클라이언트에게 보내줘야할 데이터야 라는 의미
  public Object exam31(String name, int age, MultipartFile photo) {
    System.out.println(name);
    System.out.println(age);

    if(photo !=null && photo.getSize() > 0) {
      System.out.println(photo.getOriginalFilename());
    }


    try { 
      File photoFile = new File("c:/upload/" + photo.getOriginalFilename());
      photo.transferTo(photoFile);

    }catch(Exception e) { 
      e.printStackTrace(); 
      return "error"; 
    }
    return "okok";
  }



  @RequestMapping("/html/form/exam32")
  //@ResponseBody //클라이언트에게 보내줘야할 데이터야 라는 의미
  public Object exam32(String name, int age, MultipartFile[] photo) { //여러파일은 배열로 받아라
    System.out.println(name);
    System.out.println(age);

    if (photo != null) {
      for(MultipartFile part: photo) {

        //    //톰캣 서버에 배치한 웹 애플리케이션의 실제폴더 경로 알아내기 
        //    String uploadFilePath = sc.getRealPath("./temp/" + photo.getOriginalFilename());
        //    System.out.println(uploadFilePath);

        try {
          File photoFile = new File("c:/upload/" + part.getOriginalFilename()); // 현재폴더(보통 프로젝트폴더)
          part.transferTo(photoFile);
          //파일을 받았으니 저장 
        }catch(Exception e){
          e.printStackTrace();//에러메세지가 먼지 서버에 띄우자
          return "error";
        }
      }
    }
    return "okok";
  }


  //서버 컨트롤이 달라짐 

  @RequestMapping("/html/form/exam41")
  //@ResponseBody //클라이언트에게 보내줘야할 데이터야 라는 의미
  public Object exam41(String name, int age, MultipartFile[] photo) { //여러파일은 배열로 받아라
    System.out.println(name);
    System.out.println(age);

    if (photo != null) { //혹시나 클라이언트가 안넘길수도있으니 항상 넣어, 파일은 안넣어도 서버에 넘김, 파일명은 없고
      for(MultipartFile part: photo) {
        if(part.getSize() == 0)
          continue; // 다음 파일

        try {


          File photoFile = new File("c:/upload/" + part.getOriginalFilename()); // 현재폴더(보통 프로젝트폴더)
          part.transferTo(photoFile);
          //파일을 받았으니 저장 
        }catch(Exception e){
          e.printStackTrace();//에러메세지가 먼지 서버에 띄우자
          return "error";
        }
      }
    }
    return "okok";
  }



  @RequestMapping("/html/form/exam51")
  //@ResponseBody //클라이언트에게 보내줘야할 데이터야 라는 의미
  public Object exam51(String name, int age, MultipartFile[] photo) { //여러파일은 배열로 받아라
    System.out.println(name);
    System.out.println(age);

    if (photo != null) { //혹시나 클라이언트가 안넘길수도있으니 항상 넣어, 파일은 안넣어도 서버에 넘김, 파일명은 없고
      for(MultipartFile part: photo) {
        if(part.getSize() == 0)
          continue; // 다음 파일

        try {

          String fileName = UUID.randomUUID().toString();// 동일한 파일명을 저장하더라도 클라이언트가 임의의파일명을 주는 것 데이터베이스에도 동일하게 저장 
          int dotIndex = part.getOriginalFilename().lastIndexOf(".");//파일명 추출 - 마지막 .
          if (dotIndex !=-1) {
            fileName += part.getOriginalFilename().substring(dotIndex);
          }
          File photoFile = new File("c:/upload/" + fileName); // 현재폴더(보통 프로젝트폴더)
          part.transferTo(photoFile);
          //파일을 받았으니 저장 
        }catch(Exception e){
          e.printStackTrace();//에러메세지가 먼지 서버에 띄우자
          return "error";
        }
      }
    }
    return "okok";
  }

}

