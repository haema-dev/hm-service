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
  private String member_id;
  private Timestamp created_by;

  public Board() { }

  @Builder
  public Board(String title, String content, String member_id, Timestamp created_by) {
    this.title = title;
    this.content = content;
    this.member_id = member_id;
    this.created_by = created_by;
  }

}