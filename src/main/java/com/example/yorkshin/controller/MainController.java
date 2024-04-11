package com.example.yorkshin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class MainController {

    @GetMapping("/")
    public String main(){

        //세션 확인
        //statless 상태로 관리되지만, jwt를 통해서 일시적인 요청을 통해서 세션을 잠시 생성하기에 내부 context에서 사용자 정보를 확인가능
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        return "Main Controller : " + username + role;
    }

//    @PostMapping({"/master/api/v2/surveys/assigns"})
//    @Operation(summary = "설문 템플릿 할당하기 (multi)")
//    public ResponseEntity< Result< List<SurveyAssignedDTO> > > assignsNewSurveys ( @RequestBody List< Map<String, String> > req ) {
//        return ResponseEntity.ok()
//                             .body( RESPONSE.getSuccessResult( "SUCCESS",
//                                                               SERVICE_survey.assignSurveyToCompanyMulti( req ) ) );
//    }
}
