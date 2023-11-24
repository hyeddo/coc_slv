package com.slv.qst.domain.question;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
