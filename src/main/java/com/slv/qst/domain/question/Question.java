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
    @Column(name = "qst_id")
    private Long qstId;

    @Column(name = "qst_emp_id")
    private String qstEmpId;
    @Column(name = "maincate_id")
    private Long maincateId;
    @Column(name = "midcate_id")
    private Long midcateId;
    @Column(name = "subcate_id")
    private Long subcateId;
    @Column(name = "title")
    private String title;
    @Column(name = "status")
    private int status;
    @Column(name = "content")
    private String content;
    @Column(name = "rsp_emp_id")
    private String rspEmpId;
    @Column(name = "maincate_name")
    private String maincateName;
    @Column(name = "midcateName")
    private String midcateName;
    @Column(name = "subcate_name")
    private String subcateName;

    public Question(String title, String content, String qstEmpId, String rspEmpId, Long maincateId, Long midcateId, Long subcateId, String maincateName, String midcateName, String subcateName) {
        this.title = title;
        this.content = content;
        this.qstEmpId = qstEmpId;
        this.rspEmpId = rspEmpId;
        this.status = 1;
        this.maincateId = maincateId;
        this.midcateId = midcateId;
        this.subcateId = subcateId;
        this.maincateName = maincateName;
        this.midcateName = midcateName;
        this.subcateName = subcateName;
    }

}
