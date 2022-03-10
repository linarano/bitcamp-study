-- 회원
DROP TABLE IF EXISTS member RESTRICT;

-- 크리에이터
DROP TABLE IF EXISTS creator RESTRICT;

-- 이용자
DROP TABLE IF EXISTS user RESTRICT;

-- 강좌
DROP TABLE IF EXISTS class RESTRICT;

-- 지역
DROP TABLE IF EXISTS location RESTRICT;

-- 강좌문의
DROP TABLE IF EXISTS myclass_ask RESTRICT;

-- 소모임
DROP TABLE IF EXISTS party RESTRICT;

-- 챌린지
DROP TABLE IF EXISTS challenge RESTRICT;

-- 운동성향
DROP TABLE IF EXISTS ex_type RESTRICT;

-- 운동
DROP TABLE IF EXISTS exercise RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS notice RESTRICT;

-- FAQ
DROP TABLE IF EXISTS faq RESTRICT;

-- 쿠폰
DROP TABLE IF EXISTS coupon RESTRICT;

-- 결제
DROP TABLE IF EXISTS payment RESTRICT;

-- 1:1문의
DROP TABLE IF EXISTS ask RESTRICT;

-- 강좌이미지
DROP TABLE IF EXISTS class_image RESTRICT;

-- 소모임이미지
DROP TABLE IF EXISTS party_image RESTRICT;

-- 챌린지댓글
DROP TABLE IF EXISTS challenge_comment RESTRICT;

-- 회원유형
DROP TABLE IF EXISTS member_type RESTRICT;

-- 강좌신청자
DROP TABLE IF EXISTS myclass_list RESTRICT;

-- 소모임참여자
DROP TABLE IF EXISTS party_user RESTRICT;

-- 강좌분류
DROP TABLE IF EXISTS class_type RESTRICT;

-- SNS
DROP TABLE IF EXISTS SNS RESTRICT;

-- 강좌찜
DROP TABLE IF EXISTS class_wishlist RESTRICT;

-- 쿠폰적용유형
DROP TABLE IF EXISTS coupon_type RESTRICT;

-- 챌린지좋아요
DROP TABLE IF EXISTS challenge_like RESTRICT;

-- 소모임찜
DROP TABLE IF EXISTS party_wishlist RESTRICT;

-- 챌린지신고
DROP TABLE IF EXISTS challenge_claim RESTRICT;

-- 소모임신고
DROP TABLE IF EXISTS party_claim RESTRICT;

-- 새 테이블
DROP TABLE IF EXISTS tag1 RESTRICT;

-- 새 테이블2
DROP TABLE IF EXISTS tag2 RESTRICT;

-- 내 스키마
CREATE SCHEMA MY_SCHEMA;

-- 회원
CREATE TABLE member (
  member_no   INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  name        VARCHAR(20) NOT NULL COMMENT '이름', -- 이름
  email       VARCHAR(40) NOT NULL COMMENT '이메일', -- 이메일
  phone       VARCHAR(30) NOT NULL COMMENT '휴대폰', -- 휴대폰
  nickname    VARCHAR(20) NOT NULL COMMENT '닉네임', -- 닉네임
  use_check   INTEGER     NOT NULL COMMENT '상태', -- 상태
  login_date  TIMESTAMP   NOT NULL COMMENT '최종접속일시', -- 최종접속일시
  join_date   TIMESTAMP   NOT NULL COMMENT '가입일시', -- 가입일시
  modify_date TIMESTAMP   NULL     COMMENT '정보수정일시', -- 정보수정일시
  admin_check BOOLEAN     NOT NULL COMMENT '관리자여부', -- 관리자여부
  password    VARCHAR(50) NOT NULL COMMENT '비밀번호', -- 비밀번호
  birth       VARCHAR(8)  NULL     COMMENT '생년월일', -- 생년월일
  gender      INTEGER     NOT NULL COMMENT '성별', -- 성별
  sns_no      INTEGER     NULL     COMMENT 'SNS번호' -- SNS번호
)
COMMENT '회원';

-- 회원
ALTER TABLE member
  ADD CONSTRAINT PK_member -- 회원 기본키
    PRIMARY KEY (
      member_no -- 회원번호
    );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_member
  ON member ( -- 회원
    email ASC -- 이메일
  );

-- 회원 유니크 인덱스2
CREATE UNIQUE INDEX UIX_member2
  ON member ( -- 회원
    phone ASC -- 휴대폰
  );

-- 회원 유니크 인덱스3
CREATE UNIQUE INDEX UIX_member3
  ON member ( -- 회원
    nickname ASC -- 닉네임
  );

-- 회원 인덱스
CREATE INDEX IX_member
  ON member( -- 회원
    name ASC -- 이름
  );

ALTER TABLE member
  MODIFY COLUMN member_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 크리에이터
CREATE TABLE creator (
  creator_no INTEGER     NOT NULL COMMENT '크리에이터번호', -- 크리에이터번호
  info       TEXT        NULL     COMMENT '소개', -- 소개
  bank       VARCHAR(20) NULL     COMMENT '입금은행명', -- 입금은행명
  account    VARCHAR(30) NULL     COMMENT '계좌번호' -- 계좌번호
)
COMMENT '크리에이터';

-- 크리에이터
ALTER TABLE creator
  ADD CONSTRAINT PK_creator -- 크리에이터 기본키
    PRIMARY KEY (
      creator_no -- 크리에이터번호
    );

-- 이용자
CREATE TABLE user (
  user_no      INTEGER      NOT NULL COMMENT '이용자번호', -- 이용자번호
  image        VARCHAR(255) NULL     COMMENT '사진', -- 사진
  ex_type_name VARCHAR(20)  NULL     COMMENT '운동성향명' -- 운동성향명
)
COMMENT '이용자';

-- 이용자
ALTER TABLE user
  ADD CONSTRAINT PK_user -- 이용자 기본키
    PRIMARY KEY (
      user_no -- 이용자번호
    );

-- 강좌
CREATE TABLE class (
  class_no      INTEGER      NOT NULL COMMENT '강좌번호', -- 강좌번호
  location_no   INTEGER      NOT NULL COMMENT '지역번호', -- 지역번호
  name          VARCHAR(100) NOT NULL COMMENT '강좌명', -- 강좌명
  content       TEXT         NOT NULL COMMENT '강좌내용', -- 강좌내용
  start_date    DATE         NOT NULL COMMENT '시작일', -- 시작일
  end_date      DATE         NOT NULL COMMENT '종료일', -- 종료일
  max_member    INTEGER      NOT NULL DEFAULT 0 COMMENT '최대인원', -- 최대인원
  class_price   INTEGER      NOT NULL DEFAULT 0 COMMENT '강좌료', -- 강좌료
  start_time    TIMESTAMP    NOT NULL COMMENT '시작시간', -- 시작시간
  end_time      TIMESTAMP    NOT NULL COMMENT '종료시간', -- 종료시간
  class_info    TEXT         NOT NULL COMMENT '수업소개', -- 수업소개
  register_date TIMESTAMP    NOT NULL COMMENT '등록일', -- 등록일
  status        INTEGER      NOT NULL COMMENT '상태', -- 상태
  admin_message VARCHAR(255) NULL     COMMENT '비고', -- 비고
  creator_no    INTEGER      NOT NULL COMMENT '크리에이터번호', -- 크리에이터번호
  class_type_no INTEGER      NOT NULL COMMENT '강좌분류번호', -- 강좌분류번호
  ex_no         INTEGER      NOT NULL COMMENT '운동번호', -- 운동번호
  total_rate    INTEGER      NOT NULL DEFAULT 0 COMMENT '전체평점' -- 전체평점
)
COMMENT '강좌';

-- 강좌
ALTER TABLE class
  ADD CONSTRAINT PK_class -- 강좌 기본키
    PRIMARY KEY (
      class_no -- 강좌번호
    );

-- 강좌 인덱스
CREATE INDEX IX_class
  ON class( -- 강좌
    name ASC -- 강좌명
  );

ALTER TABLE class
  MODIFY COLUMN class_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '강좌번호';

-- 지역
CREATE TABLE location (
  location_no INTEGER      NOT NULL COMMENT '지역번호', -- 지역번호
  do          VARCHAR(20)  NULL     COMMENT '도/광역시', -- 도/광역시
  si          VARCHAR(20)  NULL     COMMENT '시', -- 시
  gun         VARCHAR(20)  NULL     COMMENT '군', -- 군
  gu          VARCHAR(20)  NULL     COMMENT '구', -- 구
  address     VARCHAR(100) NULL     COMMENT '상세주소' -- 상세주소
)
COMMENT '지역';

-- 지역
ALTER TABLE location
  ADD CONSTRAINT PK_location -- 지역 기본키
    PRIMARY KEY (
      location_no -- 지역번호
    );

ALTER TABLE location
  MODIFY COLUMN location_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '지역번호';

-- 강좌문의
CREATE TABLE myclass_ask (
  myclass_ask_no       INTEGER      NOT NULL COMMENT '강좌문의번호', -- 강좌문의번호
  class_no             INTEGER      NOT NULL COMMENT '강좌번호', -- 강좌번호
  user_no              INTEGER      NOT NULL COMMENT '이용자번호', -- 이용자번호
  name                 VARCHAR(100) NOT NULL COMMENT '문의명', -- 문의명
  ask_content          TEXT         NOT NULL COMMENT '문의내용', -- 문의내용
  register_date        TIMESTAMP    NOT NULL COMMENT '작성일시', -- 작성일시
  answer_content       TEXT         NULL     COMMENT '답변내용', -- 답변내용
  answer_modify_date   TIMESTAMP    NULL     COMMENT '답변수정일시', -- 답변수정일시
  answer_register_date TIMESTAMP    NULL     COMMENT '답변일시' -- 답변일시
)
COMMENT '강좌문의';

-- 강좌문의
ALTER TABLE myclass_ask
  ADD CONSTRAINT PK_myclass_ask -- 강좌문의 기본키
    PRIMARY KEY (
      myclass_ask_no -- 강좌문의번호
    );

ALTER TABLE myclass_ask
  MODIFY COLUMN myclass_ask_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '강좌문의번호';

-- 소모임
CREATE TABLE party (
  party_no      INTEGER      NOT NULL COMMENT '소모임번호', -- 소모임번호
  location_no   INTEGER      NOT NULL COMMENT '지역번호', -- 지역번호
  name          VARCHAR(100) NOT NULL COMMENT '소모임명', -- 소모임명
  content       TEXT         NOT NULL COMMENT '소모임내용', -- 소모임내용
  start_date    TIMESTAMP    NOT NULL COMMENT '시작일', -- 시작일
  end_date      TIMESTAMP    NOT NULL COMMENT '종료일', -- 종료일
  max_member    INTEGER      NOT NULL DEFAULT 0 COMMENT '최대인원', -- 최대인원
  in_out_ex     INTEGER      NOT NULL COMMENT '실내외운동', -- 실내외운동
  register_date TIMESTAMP    NOT NULL COMMENT '등록일', -- 등록일
  modify_date   TIMESTAMP    NULL     COMMENT '수정일' -- 수정일
)
COMMENT '소모임';

-- 소모임
ALTER TABLE party
  ADD CONSTRAINT PK_party -- 소모임 기본키
    PRIMARY KEY (
      party_no -- 소모임번호
    );

-- 소모임 인덱스
CREATE INDEX IX_party
  ON party( -- 소모임
    name ASC -- 소모임명
  );

ALTER TABLE party
  MODIFY COLUMN party_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '소모임번호';

-- 챌린지
CREATE TABLE challenge (
  challenge_no  INTEGER      NOT NULL COMMENT '챌린지번호', -- 챌린지번호
  class_no      INTEGER      NOT NULL COMMENT '강좌번호', -- 강좌번호
  user_no       INTEGER      NOT NULL COMMENT '작성자', -- 작성자
  name          VARCHAR(100) NOT NULL COMMENT '챌린지명', -- 챌린지명
  content       VARCHAR(255) NOT NULL COMMENT '챌린지내용', -- 챌린지내용
  image         VARCHAR(255) NOT NULL COMMENT '이미지', -- 이미지
  register_date TIMESTAMP    NOT NULL COMMENT '작성일', -- 작성일
  modify_date   TIMESTAMP    NULL     COMMENT '수정일시', -- 수정일시
  view_count    INTEGER      NOT NULL DEFAULT 0 COMMENT '조회수' -- 조회수
)
COMMENT '챌린지';

-- 챌린지
ALTER TABLE challenge
  ADD CONSTRAINT PK_challenge -- 챌린지 기본키
    PRIMARY KEY (
      challenge_no -- 챌린지번호
    );

-- 챌린지 인덱스
CREATE INDEX IX_challenge
  ON challenge( -- 챌린지
    name ASC -- 챌린지명
  );

ALTER TABLE challenge
  MODIFY COLUMN challenge_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '챌린지번호';

-- 운동성향
CREATE TABLE ex_type (
  ex_type_name VARCHAR(20) NOT NULL COMMENT '운동성향명' -- 운동성향명
)
COMMENT '운동성향';

-- 운동성향
ALTER TABLE ex_type
  ADD CONSTRAINT PK_ex_type -- 운동성향 기본키
    PRIMARY KEY (
      ex_type_name -- 운동성향명
    );

-- 운동
CREATE TABLE exercise (
  ex_no        INTEGER     NOT NULL COMMENT '운동번호', -- 운동번호
  name         VARCHAR(20) NOT NULL COMMENT '운동명', -- 운동명
  ex_type_name VARCHAR(20) NOT NULL COMMENT '운동성향명' -- 운동성향명
)
COMMENT '운동';

-- 운동
ALTER TABLE exercise
  ADD CONSTRAINT PK_exercise -- 운동 기본키
    PRIMARY KEY (
      ex_no -- 운동번호
    );

-- 운동 유니크 인덱스
CREATE UNIQUE INDEX UIX_exercise
  ON exercise ( -- 운동
    name ASC -- 운동명
  );

-- 운동 인덱스
CREATE INDEX IX_exercise
  ON exercise( -- 운동
    name ASC -- 운동명
  );

ALTER TABLE exercise
  MODIFY COLUMN ex_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '운동번호';

-- 공지사항
CREATE TABLE notice (
  notice_no      INTEGER      NOT NULL COMMENT '공지사항번호', -- 공지사항번호
  member_type_no INTEGER      NOT NULL COMMENT '회원유형번호', -- 회원유형번호
  critical_check BOOLEAN      NOT NULL COMMENT '중요도체크', -- 중요도체크
  register_date  TIMESTAMP    NOT NULL COMMENT '작성일', -- 작성일
  view_count     INTEGER      NOT NULL DEFAULT 0 COMMENT '조회수', -- 조회수
  name           VARCHAR(100) NOT NULL COMMENT '공지제목', -- 공지제목
  content        TEXT         NOT NULL COMMENT '공지내용', -- 공지내용
  modify_date    TIMESTAMP    NULL     COMMENT '수정일' -- 수정일
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE notice
  ADD CONSTRAINT PK_notice -- 공지사항 기본키
    PRIMARY KEY (
      notice_no -- 공지사항번호
    );

-- 공지사항 인덱스
CREATE INDEX IX_notice
  ON notice( -- 공지사항
    name ASC -- 공지제목
  );

ALTER TABLE notice
  MODIFY COLUMN notice_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '공지사항번호';

-- FAQ
CREATE TABLE faq (
  faq_no         INTEGER   NOT NULL COMMENT 'FAQ질문번호', -- FAQ질문번호
  member_type_no INTEGER   NOT NULL COMMENT '회원유형번호', -- 회원유형번호
  ask            TEXT      NOT NULL COMMENT '질문내용', -- 질문내용
  answer         TEXT      NOT NULL COMMENT '답변내용', -- 답변내용
  register_date  TIMESTAMP NOT NULL COMMENT '작성일', -- 작성일
  modify_date    TIMESTAMP NULL     COMMENT '수정일' -- 수정일
)
COMMENT 'FAQ';

-- FAQ
ALTER TABLE faq
  ADD CONSTRAINT PK_faq -- FAQ 기본키
    PRIMARY KEY (
      faq_no -- FAQ질문번호
    );

-- FAQ 인덱스
CREATE INDEX IX_faq
  ON faq( -- FAQ
  );

ALTER TABLE faq
  MODIFY COLUMN faq_no INTEGER NOT NULL AUTO_INCREMENT COMMENT 'FAQ질문번호';

-- 쿠폰
CREATE TABLE coupon (
  coupon_no      INTEGER      NOT NULL COMMENT '쿠폰번호', -- 쿠폰번호
  code           VARCHAR(40)  NOT NULL COMMENT '쿠폰코드', -- 쿠폰코드
  user_no        INTEGER      NOT NULL COMMENT '이용자번호', -- 이용자번호
  name           VARCHAR(100) NOT NULL COMMENT '쿠폰명', -- 쿠폰명
  create_date    TIMESTAMP    NOT NULL COMMENT '발급일', -- 발급일
  valid_date     TIMESTAMP    NOT NULL COMMENT '유효일자', -- 유효일자
  use_check      INTEGER      NOT NULL COMMENT '사용여부', -- 사용여부
  use_date       TIMESTAMP    NULL     COMMENT '사용날짜', -- 사용날짜
  content        VARCHAR(255) NOT NULL COMMENT '쿠폰내용', -- 쿠폰내용
  price          INTEGER      NOT NULL DEFAULT 0 COMMENT '쿠폰금액', -- 쿠폰금액
  modify_date    TIMESTAMP    NULL     COMMENT '수정일시', -- 수정일시
  coupon_type_no INTEGER      NOT NULL COMMENT '쿠폰적용유형번호' -- 쿠폰적용유형번호
)
COMMENT '쿠폰';

-- 쿠폰
ALTER TABLE coupon
  ADD CONSTRAINT PK_coupon -- 쿠폰 기본키
    PRIMARY KEY (
      coupon_no, -- 쿠폰번호
      code       -- 쿠폰코드
    );

-- 쿠폰 인덱스
CREATE INDEX IX_coupon
  ON coupon( -- 쿠폰
    name ASC -- 쿠폰명
  );

ALTER TABLE coupon
  MODIFY COLUMN coupon_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '쿠폰번호';

-- 결제
CREATE TABLE payment (
  payment_no      INTEGER     NOT NULL COMMENT '결제번호', -- 결제번호
  COL             INTEGER     NULL     COMMENT '강좌신청자번호', -- 강좌신청자번호
  coupon_no       INTEGER     NOT NULL COMMENT '쿠폰번호', -- 쿠폰번호
  class_price     INTEGER     NULL     DEFAULT 0 COMMENT '강좌료', -- 강좌료
  pay_type        INTEGER     NOT NULL COMMENT '결제방식', -- 결제방식
  pay_date        TIMESTAMP   NOT NULL COMMENT '결제일시', -- 결제일시
  pay_price       INTEGER     NOT NULL DEFAULT 0 COMMENT '최종결제금액', -- 최종결제금액
  refund_date     TIMESTAMP   NULL     COMMENT '환불일자', -- 환불일자
  refund_status   INTEGER     NOT NULL COMMENT '환불상태', -- 환불상태
  calculate_date  TIMESTAMP   NULL     COMMENT '정산일자', -- 정산일자
  calculate_price INTEGER     NULL     DEFAULT 0 COMMENT '정산금액', -- 정산금액
  commission      INTEGER     NULL     DEFAULT 0 COMMENT '수수료', -- 수수료
  code            VARCHAR(40) NULL     COMMENT '쿠폰코드' -- 쿠폰코드
)
COMMENT '결제';

-- 결제
ALTER TABLE payment
  ADD CONSTRAINT PK_payment -- 결제 기본키
    PRIMARY KEY (
      payment_no -- 결제번호
    );

ALTER TABLE payment
  MODIFY COLUMN payment_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '결제번호';

-- 1:1문의
CREATE TABLE ask (
  ask_no             INTEGER      NOT NULL COMMENT '1:1문의번호', -- 1:1문의번호
  user_no            INTEGER      NOT NULL COMMENT '이용자번호', -- 이용자번호
  creator_no         INTEGER      NOT NULL COMMENT '크리에이터번호', -- 크리에이터번호
  register_date      TIMESTAMP    NOT NULL COMMENT '작성일', -- 작성일
  ask_content        TEXT         NOT NULL COMMENT '문의내용', -- 문의내용
  display            INTEGER      NOT NULL COMMENT '공개여부', -- 공개여부
  image              VARCHAR(255) NULL     COMMENT '이미지', -- 이미지
  ask_modify_date    TIMESTAMP    NULL     COMMENT '문의수정일시', -- 문의수정일시
  answer_content     TEXT         NULL     COMMENT '답변내용', -- 답변내용
  answer_date        TIMESTAMP    NULL     COMMENT '답변일시', -- 답변일시
  answer_modify_date TIMESTAMP    NULL     COMMENT '답변수정일시' -- 답변수정일시
)
COMMENT '1:1문의';

-- 1:1문의
ALTER TABLE ask
  ADD CONSTRAINT PK_ask -- 1:1문의 기본키
    PRIMARY KEY (
      ask_no -- 1:1문의번호
    );

ALTER TABLE ask
  MODIFY COLUMN ask_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '1:1문의번호';

-- 강좌이미지
CREATE TABLE class_image (
  class_image_no <데이터 타입 없음> NOT NULL COMMENT '강좌이미지번호', -- 강좌이미지번호
  class_no       INTEGER            NOT NULL COMMENT '강좌번호', -- 강좌번호
  image          <데이터 타입 없음> NOT NULL COMMENT '강좌이미지명' -- 강좌이미지명
)
COMMENT '강좌이미지';

-- 강좌이미지
ALTER TABLE class_image
  ADD CONSTRAINT PK_class_image -- 강좌이미지 기본키
    PRIMARY KEY (
      class_image_no -- 강좌이미지번호
    );

-- 소모임이미지
CREATE TABLE party_image (
  party_image_no INTEGER      NOT NULL COMMENT '소모임이미지번호', -- 소모임이미지번호
  party_no       INTEGER      NOT NULL COMMENT '소모임번호', -- 소모임번호
  image          VARCHAR(255) NOT NULL COMMENT '이미지' -- 이미지
)
COMMENT '소모임이미지';

-- 소모임이미지
ALTER TABLE party_image
  ADD CONSTRAINT PK_party_image -- 소모임이미지 기본키
    PRIMARY KEY (
      party_image_no -- 소모임이미지번호
    );

ALTER TABLE party_image
  MODIFY COLUMN party_image_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '소모임이미지번호';

-- 챌린지댓글
CREATE TABLE challenge_comment (
  challenge_comment_no INTEGER      NOT NULL COMMENT '챌린지댓글번호', -- 챌린지댓글번호
  challenge_no         INTEGER      NOT NULL COMMENT '챌린지번호', -- 챌린지번호
  user_no              INTEGER      NOT NULL COMMENT '이용자번호', -- 이용자번호
  content              VARCHAR(255) NOT NULL COMMENT '댓글내용' -- 댓글내용
)
COMMENT '챌린지댓글';

-- 챌린지댓글
ALTER TABLE challenge_comment
  ADD CONSTRAINT PK_challenge_comment -- 챌린지댓글 기본키
    PRIMARY KEY (
      challenge_comment_no -- 챌린지댓글번호
    );

ALTER TABLE challenge_comment
  MODIFY COLUMN challenge_comment_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '챌린지댓글번호';

-- 회원유형
CREATE TABLE member_type (
  member_type_no INTEGER NOT NULL COMMENT '회원유형번호', -- 회원유형번호
  member_type    INTEGER NOT NULL COMMENT '회원유형' -- 회원유형
)
COMMENT '회원유형';

-- 회원유형
ALTER TABLE member_type
  ADD CONSTRAINT PK_member_type -- 회원유형 기본키
    PRIMARY KEY (
      member_type_no -- 회원유형번호
    );

-- 회원유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_member_type
  ON member_type ( -- 회원유형
    member_type ASC -- 회원유형
  );

ALTER TABLE member_type
  MODIFY COLUMN member_type_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원유형번호';

-- 강좌신청자
CREATE TABLE myclass_list (
  COL             INTEGER      NOT NULL COMMENT '강좌신청자번호', -- 강좌신청자번호
  user_no         INTEGER      NOT NULL COMMENT '이용자번호', -- 이용자번호
  class_no        INTEGER      NOT NULL COMMENT '강좌번호', -- 강좌번호
  start_date      DATE         NOT NULL COMMENT '시작일시', -- 시작일시
  end_date        DATE         NOT NULL COMMENT '종료일시', -- 종료일시
  register_member INTEGER      NOT NULL DEFAULT 0 COMMENT '신청인원', -- 신청인원
  pay_status      INTEGER      NOT NULL COMMENT '상태', -- 상태
  content         VARCHAR(255) NULL     COMMENT '후기', -- 후기
  register_date   TIMESTAMP    NULL     COMMENT '후기작성일', -- 후기작성일
  rate            INTEGER      NOT NULL DEFAULT 0 COMMENT '평점' -- 평점
)
COMMENT '강좌신청자';

-- 강좌신청자
ALTER TABLE myclass_list
  ADD CONSTRAINT PK_myclass_list -- 강좌신청자 기본키
    PRIMARY KEY (
      COL -- 강좌신청자번호
    );

-- 강좌신청자 유니크 인덱스
CREATE UNIQUE INDEX UIX_myclass_list
  ON myclass_list ( -- 강좌신청자
    user_no ASC,    -- 이용자번호
    class_no ASC,   -- 강좌번호
    start_date ASC  -- 시작일시
  );

ALTER TABLE myclass_list
  MODIFY COLUMN COL INTEGER NOT NULL AUTO_INCREMENT COMMENT '강좌신청자번호';

-- 소모임참여자
CREATE TABLE party_user (
  user_no     INTEGER   NOT NULL COMMENT '이용자번호', -- 이용자번호
  party_no    INTEGER   NOT NULL COMMENT '소모임번호', -- 소모임번호
  party_maker BOOLEAN   NOT NULL COMMENT '방장여부', -- 방장여부
  join_date   TIMESTAMP NOT NULL COMMENT '소모임참가일시' -- 소모임참가일시
)
COMMENT '소모임참여자';

-- 소모임참여자
ALTER TABLE party_user
  ADD CONSTRAINT PK_party_user -- 소모임참여자 기본키
    PRIMARY KEY (
      user_no,  -- 이용자번호
      party_no  -- 소모임번호
    );

-- 강좌분류
CREATE TABLE class_type (
  class_type_no INTEGER     NOT NULL COMMENT '강좌분류번호', -- 강좌분류번호
  name          VARCHAR(20) NOT NULL COMMENT '강좌분류명' -- 강좌분류명
)
COMMENT '강좌분류';

-- 강좌분류
ALTER TABLE class_type
  ADD CONSTRAINT PK_class_type -- 강좌분류 기본키
    PRIMARY KEY (
      class_type_no -- 강좌분류번호
    );

-- 강좌분류 유니크 인덱스
CREATE UNIQUE INDEX UIX_class_type
  ON class_type ( -- 강좌분류
    name ASC -- 강좌분류명
  );

ALTER TABLE class_type
  MODIFY COLUMN class_type_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '강좌분류번호';

-- SNS
CREATE TABLE SNS (
  sns_no INTEGER     NOT NULL COMMENT 'SNS번호', -- SNS번호
  name   VARCHAR(20) NOT NULL COMMENT '이름' -- 이름
)
COMMENT 'SNS';

-- SNS
ALTER TABLE SNS
  ADD CONSTRAINT PK_SNS -- SNS 기본키
    PRIMARY KEY (
      sns_no -- SNS번호
    );

ALTER TABLE SNS
  MODIFY COLUMN sns_no INTEGER NOT NULL AUTO_INCREMENT COMMENT 'SNS번호';

-- 강좌찜
CREATE TABLE class_wishlist (
  user_no  INTEGER NOT NULL COMMENT '이용자번호', -- 이용자번호
  class_no INTEGER NOT NULL COMMENT '강좌번호' -- 강좌번호
)
COMMENT '강좌찜';

-- 강좌찜
ALTER TABLE class_wishlist
  ADD CONSTRAINT PK_class_wishlist -- 강좌찜 기본키
    PRIMARY KEY (
      user_no,  -- 이용자번호
      class_no  -- 강좌번호
    );

-- 쿠폰적용유형
CREATE TABLE coupon_type (
  coupon_type_no INTEGER     NOT NULL COMMENT '쿠폰적용유형번호', -- 쿠폰적용유형번호
  name           VARCHAR(20) NOT NULL COMMENT '쿠폰유형명' -- 쿠폰유형명
)
COMMENT '쿠폰적용유형';

-- 쿠폰적용유형
ALTER TABLE coupon_type
  ADD CONSTRAINT PK_coupon_type -- 쿠폰적용유형 기본키
    PRIMARY KEY (
      coupon_type_no -- 쿠폰적용유형번호
    );

ALTER TABLE coupon_type
  MODIFY COLUMN coupon_type_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '쿠폰적용유형번호';

-- 챌린지좋아요
CREATE TABLE challenge_like (
  user_no      INTEGER NOT NULL COMMENT '이용자번호', -- 이용자번호
  challenge_no INTEGER NOT NULL COMMENT '챌린지번호' -- 챌린지번호
)
COMMENT '챌린지좋아요';

-- 챌린지좋아요
ALTER TABLE challenge_like
  ADD CONSTRAINT PK_challenge_like -- 챌린지좋아요 기본키
    PRIMARY KEY (
      user_no,      -- 이용자번호
      challenge_no  -- 챌린지번호
    );

-- 소모임찜
CREATE TABLE party_wishlist (
  party_no INTEGER NOT NULL COMMENT '소모임번호', -- 소모임번호
  user_no  INTEGER NOT NULL COMMENT '이용자번호' -- 이용자번호
)
COMMENT '소모임찜';

-- 소모임찜
ALTER TABLE party_wishlist
  ADD CONSTRAINT PK_party_wishlist -- 소모임찜 기본키
    PRIMARY KEY (
      party_no, -- 소모임번호
      user_no   -- 이용자번호
    );

-- 챌린지신고
CREATE TABLE challenge_claim (
  challenge_no INTEGER NOT NULL COMMENT '챌린지번호', -- 챌린지번호
  user_no      INTEGER NOT NULL COMMENT '이용자번호' -- 이용자번호
)
COMMENT '챌린지신고';

-- 챌린지신고
ALTER TABLE challenge_claim
  ADD CONSTRAINT PK_challenge_claim -- 챌린지신고 기본키
    PRIMARY KEY (
      challenge_no, -- 챌린지번호
      user_no       -- 이용자번호
    );

-- 소모임신고
CREATE TABLE party_claim (
  party_no INTEGER NOT NULL COMMENT '소모임번호', -- 소모임번호
  user_no  INTEGER NOT NULL COMMENT '이용자번호' -- 이용자번호
)
COMMENT '소모임신고';

-- 소모임신고
ALTER TABLE party_claim
  ADD CONSTRAINT PK_party_claim -- 소모임신고 기본키
    PRIMARY KEY (
      party_no, -- 소모임번호
      user_no   -- 이용자번호
    );

-- 새 테이블
CREATE TABLE tag1 (
  tag_no INTEGER     NOT NULL COMMENT '태그번호', -- 태그번호
  tag    VARCHAR(20) NOT NULL COMMENT '태그' -- 태그
)
COMMENT '새 테이블';

-- 새 테이블
ALTER TABLE tag1
  ADD CONSTRAINT PK_tag1 -- 새 테이블 기본키
    PRIMARY KEY (
      tag_no -- 태그번호
    );

-- 새 테이블2
CREATE TABLE tag2 (
  tag_no   INTEGER NOT NULL COMMENT '태그번호', -- 태그번호
  party_no INTEGER NOT NULL COMMENT '소모임번호' -- 소모임번호
)
COMMENT '새 테이블2';

-- 새 테이블2
ALTER TABLE tag2
  ADD CONSTRAINT PK_tag2 -- 새 테이블2 기본키
    PRIMARY KEY (
      tag_no,   -- 태그번호
      party_no  -- 소모임번호
    );

-- 회원
ALTER TABLE member
  ADD CONSTRAINT FK_SNS_TO_member -- SNS -> 회원
    FOREIGN KEY (
      sns_no -- SNS번호
    )
    REFERENCES SNS ( -- SNS
      sns_no -- SNS번호
    );

-- 크리에이터
ALTER TABLE creator
  ADD CONSTRAINT FK_member_TO_creator -- 회원 -> 크리에이터
    FOREIGN KEY (
      creator_no -- 크리에이터번호
    )
    REFERENCES member ( -- 회원
      member_no -- 회원번호
    );

-- 이용자
ALTER TABLE user
  ADD CONSTRAINT FK_member_TO_user -- 회원 -> 이용자
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES member ( -- 회원
      member_no -- 회원번호
    );

-- 이용자
ALTER TABLE user
  ADD CONSTRAINT FK_ex_type_TO_user -- 운동성향 -> 이용자
    FOREIGN KEY (
      ex_type_name -- 운동성향명
    )
    REFERENCES ex_type ( -- 운동성향
      ex_type_name -- 운동성향명
    );

-- 강좌
ALTER TABLE class
  ADD CONSTRAINT FK_location_TO_class -- 지역 -> 강좌
    FOREIGN KEY (
      location_no -- 지역번호
    )
    REFERENCES location ( -- 지역
      location_no -- 지역번호
    );

-- 강좌
ALTER TABLE class
  ADD CONSTRAINT FK_creator_TO_class -- 크리에이터 -> 강좌
    FOREIGN KEY (
      creator_no -- 크리에이터번호
    )
    REFERENCES creator ( -- 크리에이터
      creator_no -- 크리에이터번호
    );

-- 강좌
ALTER TABLE class
  ADD CONSTRAINT FK_class_type_TO_class -- 강좌분류 -> 강좌
    FOREIGN KEY (
      class_type_no -- 강좌분류번호
    )
    REFERENCES class_type ( -- 강좌분류
      class_type_no -- 강좌분류번호
    );

-- 강좌
ALTER TABLE class
  ADD CONSTRAINT FK_exercise_TO_class -- 운동 -> 강좌
    FOREIGN KEY (
      ex_no -- 운동번호
    )
    REFERENCES exercise ( -- 운동
      ex_no -- 운동번호
    );

-- 강좌문의
ALTER TABLE myclass_ask
  ADD CONSTRAINT FK_class_TO_myclass_ask -- 강좌 -> 강좌문의
    FOREIGN KEY (
      class_no -- 강좌번호
    )
    REFERENCES class ( -- 강좌
      class_no -- 강좌번호
    );

-- 강좌문의
ALTER TABLE myclass_ask
  ADD CONSTRAINT FK_user_TO_myclass_ask -- 이용자 -> 강좌문의
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 소모임
ALTER TABLE party
  ADD CONSTRAINT FK_location_TO_party -- 지역 -> 소모임
    FOREIGN KEY (
      location_no -- 지역번호
    )
    REFERENCES location ( -- 지역
      location_no -- 지역번호
    );

-- 챌린지
ALTER TABLE challenge
  ADD CONSTRAINT FK_class_TO_challenge -- 강좌 -> 챌린지
    FOREIGN KEY (
      class_no -- 강좌번호
    )
    REFERENCES class ( -- 강좌
      class_no -- 강좌번호
    );

-- 챌린지
ALTER TABLE challenge
  ADD CONSTRAINT FK_user_TO_challenge -- 이용자 -> 챌린지
    FOREIGN KEY (
      user_no -- 작성자
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 운동
ALTER TABLE exercise
  ADD CONSTRAINT FK_ex_type_TO_exercise -- 운동성향 -> 운동
    FOREIGN KEY (
      ex_type_name -- 운동성향명
    )
    REFERENCES ex_type ( -- 운동성향
      ex_type_name -- 운동성향명
    );

-- 공지사항
ALTER TABLE notice
  ADD CONSTRAINT FK_member_type_TO_notice -- 회원유형 -> 공지사항
    FOREIGN KEY (
      member_type_no -- 회원유형번호
    )
    REFERENCES member_type ( -- 회원유형
      member_type_no -- 회원유형번호
    );

-- FAQ
ALTER TABLE faq
  ADD CONSTRAINT FK_member_type_TO_faq -- 회원유형 -> FAQ
    FOREIGN KEY (
      member_type_no -- 회원유형번호
    )
    REFERENCES member_type ( -- 회원유형
      member_type_no -- 회원유형번호
    );

-- 쿠폰
ALTER TABLE coupon
  ADD CONSTRAINT FK_user_TO_coupon -- 이용자 -> 쿠폰
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 쿠폰
ALTER TABLE coupon
  ADD CONSTRAINT FK_coupon_type_TO_coupon -- 쿠폰적용유형 -> 쿠폰
    FOREIGN KEY (
      coupon_type_no -- 쿠폰적용유형번호
    )
    REFERENCES coupon_type ( -- 쿠폰적용유형
      coupon_type_no -- 쿠폰적용유형번호
    );

-- 결제
ALTER TABLE payment
  ADD CONSTRAINT FK_coupon_TO_payment -- 쿠폰 -> 결제
    FOREIGN KEY (
      coupon_no, -- 쿠폰번호
      code       -- 쿠폰코드
    )
    REFERENCES coupon ( -- 쿠폰
      coupon_no, -- 쿠폰번호
      code       -- 쿠폰코드
    );

-- 결제
ALTER TABLE payment
  ADD CONSTRAINT FK_myclass_list_TO_payment -- 강좌신청자 -> 결제
    FOREIGN KEY (
      COL -- 강좌신청자번호
    )
    REFERENCES myclass_list ( -- 강좌신청자
      COL -- 강좌신청자번호
    );

-- 1:1문의
ALTER TABLE ask
  ADD CONSTRAINT FK_user_TO_ask -- 이용자 -> 1:1문의
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 1:1문의
ALTER TABLE ask
  ADD CONSTRAINT FK_creator_TO_ask -- 크리에이터 -> 1:1문의
    FOREIGN KEY (
      creator_no -- 크리에이터번호
    )
    REFERENCES creator ( -- 크리에이터
      creator_no -- 크리에이터번호
    );

-- 강좌이미지
ALTER TABLE class_image
  ADD CONSTRAINT FK_class_TO_class_image -- 강좌 -> 강좌이미지
    FOREIGN KEY (
      class_no -- 강좌번호
    )
    REFERENCES class ( -- 강좌
      class_no -- 강좌번호
    );

-- 소모임이미지
ALTER TABLE party_image
  ADD CONSTRAINT FK_party_TO_party_image -- 소모임 -> 소모임이미지
    FOREIGN KEY (
      party_no -- 소모임번호
    )
    REFERENCES party ( -- 소모임
      party_no -- 소모임번호
    );

-- 챌린지댓글
ALTER TABLE challenge_comment
  ADD CONSTRAINT FK_challenge_TO_challenge_comment -- 챌린지 -> 챌린지댓글
    FOREIGN KEY (
      challenge_no -- 챌린지번호
    )
    REFERENCES challenge ( -- 챌린지
      challenge_no -- 챌린지번호
    );

-- 챌린지댓글
ALTER TABLE challenge_comment
  ADD CONSTRAINT FK_user_TO_challenge_comment -- 이용자 -> 챌린지댓글
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 강좌신청자
ALTER TABLE myclass_list
  ADD CONSTRAINT FK_user_TO_myclass_list -- 이용자 -> 강좌신청자
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 강좌신청자
ALTER TABLE myclass_list
  ADD CONSTRAINT FK_class_TO_myclass_list -- 강좌 -> 강좌신청자
    FOREIGN KEY (
      class_no -- 강좌번호
    )
    REFERENCES class ( -- 강좌
      class_no -- 강좌번호
    );

-- 소모임참여자
ALTER TABLE party_user
  ADD CONSTRAINT FK_user_TO_party_user -- 이용자 -> 소모임참여자
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 소모임참여자
ALTER TABLE party_user
  ADD CONSTRAINT FK_party_TO_party_user -- 소모임 -> 소모임참여자
    FOREIGN KEY (
      party_no -- 소모임번호
    )
    REFERENCES party ( -- 소모임
      party_no -- 소모임번호
    );

-- 강좌찜
ALTER TABLE class_wishlist
  ADD CONSTRAINT FK_user_TO_class_wishlist -- 이용자 -> 강좌찜
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 강좌찜
ALTER TABLE class_wishlist
  ADD CONSTRAINT FK_class_TO_class_wishlist -- 강좌 -> 강좌찜
    FOREIGN KEY (
      class_no -- 강좌번호
    )
    REFERENCES class ( -- 강좌
      class_no -- 강좌번호
    );

-- 챌린지좋아요
ALTER TABLE challenge_like
  ADD CONSTRAINT FK_user_TO_challenge_like -- 이용자 -> 챌린지좋아요
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 챌린지좋아요
ALTER TABLE challenge_like
  ADD CONSTRAINT FK_challenge_TO_challenge_like -- 챌린지 -> 챌린지좋아요
    FOREIGN KEY (
      challenge_no -- 챌린지번호
    )
    REFERENCES challenge ( -- 챌린지
      challenge_no -- 챌린지번호
    );

-- 소모임찜
ALTER TABLE party_wishlist
  ADD CONSTRAINT FK_user_TO_party_wishlist -- 이용자 -> 소모임찜
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 소모임찜
ALTER TABLE party_wishlist
  ADD CONSTRAINT FK_party_TO_party_wishlist -- 소모임 -> 소모임찜
    FOREIGN KEY (
      party_no -- 소모임번호
    )
    REFERENCES party ( -- 소모임
      party_no -- 소모임번호
    );

-- 챌린지신고
ALTER TABLE challenge_claim
  ADD CONSTRAINT FK_challenge_TO_challenge_claim -- 챌린지 -> 챌린지신고
    FOREIGN KEY (
      challenge_no -- 챌린지번호
    )
    REFERENCES challenge ( -- 챌린지
      challenge_no -- 챌린지번호
    );

-- 챌린지신고
ALTER TABLE challenge_claim
  ADD CONSTRAINT FK_user_TO_challenge_claim -- 이용자 -> 챌린지신고
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 소모임신고
ALTER TABLE party_claim
  ADD CONSTRAINT FK_party_TO_party_claim -- 소모임 -> 소모임신고
    FOREIGN KEY (
      party_no -- 소모임번호
    )
    REFERENCES party ( -- 소모임
      party_no -- 소모임번호
    );

-- 소모임신고
ALTER TABLE party_claim
  ADD CONSTRAINT FK_user_TO_party_claim -- 이용자 -> 소모임신고
    FOREIGN KEY (
      user_no -- 이용자번호
    )
    REFERENCES user ( -- 이용자
      user_no -- 이용자번호
    );

-- 새 테이블2
ALTER TABLE tag2
  ADD CONSTRAINT FK_party_TO_tag2 -- 소모임 -> 새 테이블2
    FOREIGN KEY (
      party_no -- 소모임번호
    )
    REFERENCES party ( -- 소모임
      party_no -- 소모임번호
    );

-- 새 테이블2
ALTER TABLE tag2
  ADD CONSTRAINT FK_tag1_TO_tag2 -- 새 테이블 -> 새 테이블2
    FOREIGN KEY (
      tag_no -- 태그번호
    )
    REFERENCES tag1 ( -- 새 테이블
      tag_no -- 태그번호
    );