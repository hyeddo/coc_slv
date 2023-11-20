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
    private Long ans_id;

    private Long qst_id;
    private String ans_emp_id;
    private String title;
    private String content;
    // private int open_yn;

    public Answer(Long qst_id, String ans_emp_id, String title, String content){
        this.qst_id = qst_id;
        this.ans_emp_id = ans_emp_id;
        this.title = title;
        this.content = content;
    }

}
