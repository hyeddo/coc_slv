package com.slv.qst.api;

import com.slv.qst.request.*;
import com.slv.qst.response.*;
import com.slv.qst.service.QuestionService;
import com.slv.qst.domain.BaseResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/qustion")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/quest")
    public ResponseEntity<? extends BaseResponseBody> registerQuest(QuestRegPostReq questRegPostReq) {
        questionService.registerQuest(questRegPostReq);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "success"));
    }

    @PatchMapping("/quest")
    public ResponseEntity<? extends BaseResponseBody> updateQuest(QuestModPatchReq questModPatchReq) {
        questionService.updateQuest(questModPatchReq);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "success"));
    }

    @PatchMapping("/status")
    public ResponseEntity<? extends BaseResponseBody> updateStatus(QuestStatusPatchReq questStatusPatchReq) {
        questionService.updateStatus(questStatusPatchReq);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "success"));
    }

    @PatchMapping("/employee")
    public ResponseEntity<? extends BaseResponseBody> updateEmployee(QuestEmpPatchReq questEmpPatchReq) {
        questionService.updateEmployee(questEmpPatchReq);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "success"));
    }

    @DeleteMapping("/quest")
    public ResponseEntity<? extends BaseResponseBody> deleteQuest(@RequestBody Map<String, Long> qstIdMap) {
        questionService.deleteQuest(qstIdMap.get("qstId"));
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "success"));
    }

    @GetMapping("/questlist")
    public ResponseEntity<QuestListRes> getQuestList(){
        List<QuestRes> result = new ArrayList<>();
        List<Question> questList = questionService.getQuestList();
        for(Question question : questList){
            QuestRes questRes = QuestRes.of(question);
            result.add(questRes);
        }
        return ResponseEntity.status(200).body(QuestListRes.of(result.size(), result));
    }

    @GetMapping("/questlistbycate")
    public ResponseEntity<QuestListRes> getQuestListByCate(@RequestParam("maincateid") Long mainCateId, @RequestParam("midcateid") Long midCateId, @RequestParam("subcateid") Long subCateId){
        List<QuestRes> result = new ArrayList<>();
        List<Question> questList = questionService.getQuestListByCate(mainCateId, midCateId, subCateId);
        for(Question question : questList){
            QuestRes questRes = QuestRes.of(question);
            result.add(questRes);
        }
        return ResponseEntity.status(200).body(QuestListRes.of(result.size(), result));
    }

    @GetMapping("/questlistbyrsp")
    public ResponseEntity<QuestListRes> getQuestListByRsp(@RequestParam("rspEmpId") String rspEmpId){
        List<QuestRes> result = new ArrayList<>();
        List<Question> questList = questionService.getQuestListByRsp(rspEmpId);
        for(Question question : questList){
            QuestRes questRes = QuestRes.of(question);
            result.add(questRes);
        }
        return ResponseEntity.status(200).body(QuestListRes.of(result.size(), result));
    }

    @GetMapping("/questlistbyqst")
    public ResponseEntity<QuestListRes> getQuestListByRsp(@RequestParam("qstEmpId") String qstEmpId){
        List<QuestRes> result = new ArrayList<>();
        List<Question> questList = questionService.getQuestListByQst(qstEmpId);
        for(Question question : questList){
            QuestRes questRes = QuestRes.of(question);
            result.add(questRes);
        }
        return ResponseEntity.status(200).body(QuestListRes.of(result.size(), result));
    }

    @GetMapping("/questlistbydep")
    public ResponseEntity<QuestListRes> getQuestListByDep(@RequestParam("depId") Long depId){
        // 1. 타임아웃 설정시 HttpComponentsClientHttpRequestFactory 객체를 생성합니다.
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); // 타임아웃 설정 5초
        factory.setReadTimeout(5000); // 타임아웃 설정 5초

        //Apache HttpComponents : 각 호스트(IP와 Port의 조합)당 커넥션 풀에 생성가능한 커넥션 수
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(50)//최대 커넥션 수
                .setMaxConnPerRoute(20).build();
        factory.setHttpClient(httpClient);

        // 2. RestTemplate 객체를 생성합니다.
        RestTemplate restTemplate = new RestTemplate(factory);

        // HTTP Body로 들어갈 것들 만들기
        Map<String, Long> empRequest = {"depId" : depId};

        // 4. 요청 URL을 정의해줍니다.
        String url = "https://j7a503.p.ssafy.io/api/employee/";

        // 5. postForEntity() 메소드로 api를 호출합니다.
        ResponseEntity<List> response = restTemplate.postForEntity(url, empRequest, List.class);

        List<QuestRes> result = new ArrayList<>();
        List<String> empList = (List) response.getBody().get(0);
        List<Question> questList = questionService.getQuestListByEmpId(empList);
        
        if(response.getStatusCode() == HttpStatus.OK){
            return ResponseEntity.status(200).body(QuestListRes.of(result.size(), result));
        } else
            return ResponseEntity.status(409).body(BaseResponseBody.of(409, "fail"));
    }

    @GetMapping("/questlistbysts")
    public ResponseEntity<QuestListRes> getQuestListBySts(@RequestParam("status") int status){
        List<QuestRes> result = new ArrayList<>();
        List<Question> questList = questionService.getQuestListBySts(qstEmpId);
        for(Question question : questList){
            QuestRes questRes = QuestRes.of(question);
            result.add(questRes);
        }
        return ResponseEntity.status(200).body(QuestListRes.of(result.size(), result));
    }

    @GetMapping("/info")
    public ResponseEntity<QuestRes> getQuestInfo(@RequestParam("qstId") Long qstId){
        Question question = questionService.getQuestInfo(qstId);
        return ResponseEntity.status(200).body(QuestRes.of(question));
    }
}
