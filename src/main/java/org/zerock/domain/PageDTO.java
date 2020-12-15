package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

  private int startPage;
  private int endPage;
  private boolean prev, next;

  private int total;
  private Criteria cri;   //몇 개의 데이터와 몇개의 페이지로 할건지

  public PageDTO(Criteria cri, int total) {                //생성자

    this.cri = cri;
    this.total = total;

    this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;  //끝번호 10이냐 20이냐 30이냐

    this.startPage = this.endPage - 9;   //시작번호 (1이냐 11이냐 21이냐)

    int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));   //실제 마지막페이지

    if (realEnd <= this.endPage) {      //마지막 페이지가 10이 안될때
      this.endPage = realEnd;
    }

    this.prev = this.startPage > 1;        //이전(prev)
    

    this.next = this.endPage < realEnd; //다음(next)
  }
  
}

