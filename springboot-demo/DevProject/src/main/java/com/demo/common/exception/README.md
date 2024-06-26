# 예외 처리
- 스프링 프레임워크 예외, 사용자 정의 예외, 의존 라이브러리에서 발생한 예외, 시스템 예외
- 예외 처리 어노테이션
- ResponseEntityExceptionHandler를 상속받고 @ControllerAdvice를 이용하여 처리
- @ControllerAdvice 어노테이션은 스프링 컨트롤러에서 발생하는 예외를 처리하는 핸들러 클래스임을 명시한다.
- 처리할 수 있는 예외 : 등록할 때 빈값의 유효값 검증 예외
- 처리할 수 없는 예외 : 존재하지 않는 게시물을 조회할 때 사용자가 정의한 예외 발생(throw new BoardRecordNotFoundException("Not Found boardNo = " + boardNo);)
- 사용자 정의 예외 처리
- @ExceptionHandler와 @ControllerAdvice를 이용하여 처리한다.
- @ControllerAdvice 어노테이션은 스프링 컨트롤러에서 발생하는 예외를 처리하는 핸들러 클래스임을 명시한다.
- @ExceptionHandler 어노테이션은 괄호 안에 설정한 예외 타입을 해당 메서드가 처리한다는 것을 의미한다.
- BindingResult 타입의 매개변수를 지정하지 않으면 입력값 검증 예외를 외부로 던진다.
- public ResponseEntity<String> register(@Validated @RequestBody Board board) throws Exception {