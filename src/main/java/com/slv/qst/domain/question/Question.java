package com.slv.qst.domain.question;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qst_id;

    private String qst_emp_id;
    private Long maincate_id;
    private Long midcate_id;
    private Long subcate_id;
    private String title;
    private int status;
    private String content;
    private String rsp_emp_id;
    private String maincate_name;
    private String midcate_name;
    private String subcate_name;

    public Question(String title, String content, String qst_emp_id, String rsp_emp_id, Long maincate_id, Long midcate_id, Long subcate_id, String maincate_name, String midcate_name, String subcate_name) {
        this.title = title;
        this.content = content;
        this.qst_emp_id = qst_emp_id;
        this.rsp_emp_id = rsp_emp_id;
        this.status = 1;
        this.maincate_id = maincate_id;
        this.midcate_id = midcate_id;
        this.subcate_id = subcate_id;
        this.maincate_name = maincate_name;
        this.midcate_name = midcate_name;
        this.subcate_name = subcate_name;
    }

}
