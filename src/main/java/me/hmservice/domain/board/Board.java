package me.hmservice.domain.board;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;


@Entity
public class Board {

  @Column(name = "board_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;
  private String member_id;
  private String created_by;

  public Board() { }

  @Builder
  public Board(String title, String content, String member_id, String created_by) {
    this.title = title;
    this.content = content;
    this.member_id = member_id;
    this.created_by = created_by;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getMember_id() {
    return member_id;
  }

  public String getCreated_by() {
    return created_by;
  }
}