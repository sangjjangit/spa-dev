package com.demo.controller;

import com.demo.domain.Address;
import com.demo.domain.Card;
import com.demo.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class MemberController {

    @PostMapping(path = "/", produces="text/plain;charset=utf-8")
// 입력값 검증을 할 도메인 클래스에 @Validated를 지정한다.
    public ResponseEntity<String> register(@Validated @RequestBody Member member, BindingResult result) {
        log.info("register");

        // hasErrors() - 에러가 발생한 경우 true를 반환한다.
        // hasGlobalErrors() - 객체 레벨의 에러가 발생한 경우 true를 반환한다.
        // hasFieldErrors() - 필드 레벨의 에러가 발생한 경우 true를 반환한다.
        // hasFieldErrors(String) - 인수에 지정한 필드에서 에러가 발생한 경우 true를 반환한다

        // 입력값 검증 에러가 발생한 경우 true를 반환한다.
        log.info("result.hasErrors() = " + result.hasErrors());

        // 입력값 검증 후 BindingResult가 제공하는 메서드를 이용하여 검사 결과를 확인한다.
        if (result.hasErrors()) {

            List<ObjectError> allErrors = result.getAllErrors();
            List<ObjectError> globalErrors = result.getGlobalErrors();
            List<FieldError> fieldErrors = result.getFieldErrors();

            log.info("allErrors.size() = " + allErrors.size());
            log.info("globalErrors.size() = " + globalErrors.size());
            log.info("fieldErrors.size() = " + fieldErrors.size());

            for (int i = 0; i < allErrors.size(); i++) {
                ObjectError objectError = allErrors.get(i);
                log.info("allError = " + objectError);
            }

            for (int i = 0; i < globalErrors.size(); i++) {
                ObjectError objectError = globalErrors.get(i);
                log.info("globalError = " + objectError);
            }

            for (int i = 0; i < fieldErrors.size(); i++) {
                FieldError fieldError = fieldErrors.get(i);
                log.info("fieldError = " + fieldError);
                log.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
            }
        }
        log.info("member.getUserId() = " + member.getUserId());
        log.info("member.getPassword() = " + member.getPassword());
        log.info("member.getUserName() = " + member.getUserName());
        log.info("member.getEmail() = " + member.getEmail());
        log.info("member.getGender() = " + member.getGender());


        // @Vaild
        Address address = member.getAddress();

        if(address != null) {
            log.info("address != null address.getPostCode() = " + address.getPostCode());
            log.info("address != null address.getLocation() = " + address.getLocation());
        }
        else {
            log.info("address == null");
        }

        List<Card> cardList = member.getCardList();

        if(cardList != null) {
            log.info("cardList != null = " + cardList.size());

            for(int i = 0; i < cardList.size(); i++) {
                Card card = cardList.get(i);
                log.info("card.getNo() = " + card.getNo());
                log.info("card.getValidMonth() = " + card.getValidMonth());
            }
        }
        else {
            log.info("cardList == null");
        }

        if(result.hasErrors()) {
            ResponseEntity<String> entity = new ResponseEntity<String>(result.toString(), HttpStatus.BAD_REQUEST);

            return entity;
        }

        ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        return entity;
    }

}
