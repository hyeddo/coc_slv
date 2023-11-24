package com.slv.qst.domain.question;

import com.slv.qst.domain.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllOrderByQstIdDesc();
    List<Question> findAllByMaincateIdOrderByQstIdDesc(Long maincateId);
    List<Question> findAllByMaincateIdAndMidcateIdOrderByQstIdDesc(Long maincateId, Long midcateId);
    List<Question> findAllByMaincateIdAndMidcateIdAndSubcateIdOrderByQstIdDesc(Long maincateId, Long midcateId, Long subcateId);
    List<Question> findAllByRspEmpIdOrderByQstIdDesc(String rspEmpId);
    List<Question> findAllByQstEmpIdOrderByQstIdDesc(String qstEmpId);
    List<Question> findAllByRspEmpIdInOrderByQstIdDesc(List<String> empList);
    List<Question> findAllByStatusOrderByQstIdDesc(int status);
    Question findOneByQstId(Long qstId);
}
