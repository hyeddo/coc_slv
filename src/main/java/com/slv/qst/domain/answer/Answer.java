package com.slv.qst.domain.answer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Answer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id")
    private Long ansId;

    @Column(name = "qst_id")
    private Long qstId;
    @Column(name = "ans_emp_id")
    private String ansEmpId;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    // private int open_yn;

    public Answer(Long qstId, String ansEmpId, String title, String content){
        this.qstId = qstId;
        this.ansEmpId = ansEmpId;
        this.title = title;
        this.content = content;
    }

}
