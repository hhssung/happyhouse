DROP TABLE IF EXISTS `ssafyweb`.`qna` ;

/* 
q_no : QNA 번호
q_userid : 작성자의 id
q_title : 제목
q_content : 질문 내용
hit : 조회수
q_regtime : 질문 등록한 시간
a_userid : 답변한 사람 (관리자)
a_content : 답변 내용
a_regtime : 답변 등록한 시간
answer_status : 답변 여부 (F : 0 / 1)
open_status : 공개 여부 (F : 0 / 1)
*/
CREATE TABLE IF NOT EXISTS `ssafyweb`.`qna` (
  `q_no` INT NOT NULL AUTO_INCREMENT,
  `q_userid` VARCHAR(16) NULL DEFAULT NULL,
  `q_title` VARCHAR(100) NULL DEFAULT NULL,
  `q_content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `q_regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `a_userid` VARCHAR(16) NULL DEFAULT NULL,
  `a_content` VARCHAR(2000) NULL DEFAULT NULL,
  `a_regtime` TIMESTAMP NULL DEFAULT NULL,
  `answer_status` BOOLEAN NOT NULL DEFAULT 0,	
  `open_status` BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (`q_no`),
  CONSTRAINT `qna_to_member_fk1`
    FOREIGN KEY (`q_userid`)
    REFERENCES `ssafyweb`.`ssafy_member` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `qna_to_member_fk2`
    FOREIGN KEY (`a_userid`)
    REFERENCES `ssafyweb`.`ssafy_member` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

alter table board drop foreign key board_to_member_fk;
alter table qna drop foreign key qna_to_member_fk1;
alter table qna drop foreign key qna_to_member_fk2;



alter table board add foreign key (`userid`) references `ssafy_member` (`userid`) on delete cascade;
alter table qna add foreign key (`q_userid`) references `ssafy_member` (`userid`) on delete cascade;
alter table qna add foreign key (`a_userid`) references `ssafy_member` (`userid`) on delete cascade;

