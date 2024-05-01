package com.demo.common.exception;

import com.demo.exception.BoardRecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
// ResponseEntityExceptionHandler를 상속받고 클래스에 @ControllerAdvice를 붙인다.
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    // 시스템 예외를 처리할려면 사용자가 예외 처리 메서드를 구현해야 한다.
    @ExceptionHandler
    public ResponseEntity<Object> handleSystemException(Exception ex, WebRequest request) {
        log.info("handleSystemException");

        ApiErrorInfo apiErrorInfo = new ApiErrorInfo();
        apiErrorInfo.setMessage(ex.getClass().getSimpleName());

        return super.handleExceptionInternal(ex, apiErrorInfo, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    // 사용자 정의 예외를 처리할려면 사용자가 예외 처리 메서드를 구현해야 한다.
    @ExceptionHandler
    // 메서드 매개변수에 처리해야 하는 예외 클래스를 선언한다.
    public ResponseEntity<Object> handleBoardRecordNotFoundException(BoardRecordNotFoundException ex, WebRequest request) {
        log.info("handleBoardRecordNotFoundException");

        ApiErrorInfo apiErrorInfo = new ApiErrorInfo();
        apiErrorInfo.setMessage("BoardRecord Not Found");

        return super.handleExceptionInternal(ex, apiErrorInfo, null, HttpStatus.NOT_FOUND, request);
    }

    // 응답 본문에 오류 정보를 표시하려면 handleExceptionInternal 메서드를 재정의해야 한다.
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             Object body,
                                                             HttpHeaders headers,
                                                             HttpStatusCode statusCode,
                                                             WebRequest request) {

        log.info("handleExceptionInternal");

        ApiErrorInfo apiErrorInfo = new ApiErrorInfo();
        apiErrorInfo.setMessage(ex.getClass().getSimpleName());

        return super.handleExceptionInternal(ex, apiErrorInfo, headers, statusCode, request);
//        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }
}
