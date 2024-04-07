package me.hmservice.domain.board;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;


@Getter
@Entity
public class Board {

  @Column(name = "board_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;
  @Column(name = "member_id")
  private String memberId;
  @Column(name = "created_by")
  private Timestamp createdBy;

  public Board() { }

  @Builder
  public Board(String title, String content, String memberId, Timestamp createdBy) {
    this.title = title;
    this.content = content;
    this.memberId = memberId;
    this.createdBy = createdBy;
  }
}