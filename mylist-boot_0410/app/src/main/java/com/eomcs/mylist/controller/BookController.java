package com.eomcs.mylist.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.mylist.domain.Book;
import com.eomcs.mylist.service.BookService;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@RestController
public class BookController {

  // log를 출력하는 도구 준비 인터페이스이므루 구현체를 만들어야하는데 팩토리메서드로 만든다.
  // private static final Logger log = LogManager.getLogger(BoardController.class); //타입을 줘라 로그를
  // 남길때마다 이 클래스이름으로 남긴다.
  // 내부적으로 만든다음에 교체못하도록 final
  // 보드객체가 2개가 생기든 ,3개가 생기든 무조건 로거객체는 1번만 만들어진다.

  // private static final Logger log = LogManager.getLogger(BookController.class);//클래스로딩할때



  // log를 출력하는 도구 준비 인터페이스이므루 구현체를 만들어야하는데 팩토리메서드로 만든다.
  private static final Logger log = LoggerFactory.getLogger(BookController.class);// 타입을 줘라 로그를 남길때마다 이
  // 클래스이름으로 남긴다.
  // 내부적으로 만든다음에 교체못하도록 final
  // 보드객체가 2개가 생기든 ,3개가 생기든 무조건 로거객체는 1번만 만들어진다.

  // private static final Logger log = LogManager.getLogger(BookController.class);//클래스로딩할때

  @Autowired
  BookService bookService;

  @RequestMapping("/book/list")

  public Object list() {
    log.error("게시물 목록조회!");
    log.info("게시물 목록조회!");
    log.warn("게시물 목록조회!");
    log.info("게시물 목록조회!");
    log.debug("게시물 목록조회!");
    log.trace("게시물 목록조회!");


    // //레벨
    // log.fatal("fatal....");
    // log.error("error...");
    // log.warn("warn....");
    // log.info("info....");
    // log.debug("debug....");
    // log.trace("trace....");

    return bookService.list();
  }


  @RequestMapping("/book/add")
  public Object add(Book book, MultipartFile file) {
    log.info("게시글 등록!"); // 운영자관점에서 확인 - 게시글등록이 되었나 확인
    log.debug(book.toString()); // 개발자 관점에서 확인

    try {
      book.setPhoto(saveFile(file));
      return bookService.add(book);

    } catch (Exception e) {
      // e.printStackTrace();
      // 개발자 운영자 모두봐야할 메세지
      StringWriter out = new StringWriter();
      e.printStackTrace(new PrintWriter(out));
      log.error(out.toString());
      return "error!";
    }
  }


  @RequestMapping("/book/get")
  public Object get(int no) {
    Book book = bookService.get(no);
    return book != null ? book : "";
  }

  @RequestMapping("/book/update")
  public Object update(Book book, MultipartFile file) {
    try {
      book.setPhoto(saveFile(file));
      return bookService.update(book);

    } catch (Exception e) {
      e.printStackTrace();
      return "error!";
    }
  }

  @RequestMapping("/book/delete")
  public Object delete(int no) {
    return bookService.delete(no);
  }

  @RequestMapping("/book/photo")
  public ResponseEntity<Resource> photo(String filename) {

    try {
      // 다운로드할 파일의 입력 스트림 자원을 준비한다.
      File downloadFile = new File("./upload/book/" + filename); // 다운로드 상대 경로 준비
      FileInputStream fileIn = new FileInputStream(downloadFile.getCanonicalPath()); // 다운로드 파일의 실제
      // 경로를 지정하여 입력
      // 스트림 준비
      InputStreamResource resource = new InputStreamResource(fileIn); // 입력 스트림을 입력 자원으로 포장

      // HTTP 응답 헤더를 준비한다.
      HttpHeaders header = new HttpHeaders();
      header.add("Cache-Control", "no-cache, no-store, must-revalidate");
      header.add("Pragma", "no-cache");
      header.add("Expires", "0");

      // 다운로드 파일명을 지정하고 싶다면 다음의 응답 헤더를 추가하라!
      // => 다운로드 파일을 지정하지 않으면 요청 URL이 파일명으로 사용된다.
      header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);



      // // HTTP 응답 생성기를 사용하여 다운로드 파일의 응답 데이터를 준비한다.
      // BodyBuilder http응답생성기 = ResponseEntity.ok(); // 요청 처리에 성공했다는 응답 생성기를 준비한다.
      // http응답생성기.headers(header); // HTTP 응답 헤더를 설정한다.
      // http응답생성기.contentLength(downloadFile.length()); // 응답 콘텐트의 파일 크기를 설정한다.
      // http응답생성기.contentType(MediaType.APPLICATION_OCTET_STREAM); // 응답 데이터의 MIME 타입을 설정한다.
      //
      // // 응답 데이터를 포장한다.
      // ResponseEntity<Resource> 응답데이터 = http응답생성기.body(resource);
      //
      // return 응답데이터; // 포장한 응답 데이터를 클라이언트로 리턴한다.

      return ResponseEntity.ok() // HTTP 응답 프로토콜에 따라 응답을 수행할 생성기를 준비한다.
          .headers(header) // 응답 헤더를 설정한다.
          .contentLength(downloadFile.length()) // 응답할 파일의 크기를 설정한다.
          .contentType(MediaType.APPLICATION_OCTET_STREAM) // 응답 콘텐트의 MIME 타입을 설정한다.
          .body(resource); // 응답 콘텐트를 생성한 후 리턴한다.

    } catch (Exception e) {

      return null;
    }
  }


  private String saveFile(MultipartFile file) throws Exception {
    if (file != null && file.getSize() > 0) {
      // 파일을 저장할 때 사용할 파일명을 준비한다.
      String filename = UUID.randomUUID().toString();

      // 파일명의 확장자를 알아낸다.
      int dotIndex = file.getOriginalFilename().lastIndexOf(".");
      if (dotIndex != -1) {
        filename += file.getOriginalFilename().substring(dotIndex);
      }

      // 파일을 지정된 폴더에 저장한다.
      File photoFile = new File("./upload/book/" + filename); // App 클래스를 실행하는 프로젝트 폴더
      file.transferTo(photoFile.getCanonicalFile()); // 프로젝트 폴더의 전체 경로를 전달한다.

      // 썸네일 이미지 파일 생성
      Thumbnails.of(photoFile).size(50, 50).crop(Positions.CENTER).outputFormat("jpg")
      .toFile(new File("./upload/book/" + "50x50_" + filename));

      return filename;

    } else {
      return null;
    }
  }


}


