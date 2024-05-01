### 16. 컨트롤러 요청 매핑

---
1. 요청 경로 매핑
- @RequestMapping(value = "/boards/register")
2. 경로 패턴 매핑 - 동적표현
- @RequestMapping("/read/{boardNo}")

3. Http 메서드 매핑
- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @PatchMapping

4. Header 매핑
- headers 속성을 사용해서 요청을 매핑한다.
- @PutMapping(path = "/{boardNo}", headers = "X-HTTP-Method-Override=PUT")

5. Content Type 매핑
- consumes 속성값을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정된다.
- @PutMapping(path = "/{boardNo}", consumes = "application/json")

6. Accept 매핑
- produces 속성값을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정된다.
- produces 속성값에 "application/json" 미디어 타입을 지정한다.
- @GetMapping(path = "/{boardNo}", produces = "application/json")
---
### 17. 컨트롤러 응답
1. void, String 타입
2. 자바빈즈 클래스 타입(JSON 타입으로 자동으로 변환)
3. 컬렉션 List 타입(JSON 객체 배열 타입으로 자동으로 변환)
4. 컬렉션 Map 타입(JSON 객체 타입으로 자동으로 변환)
5. ResponseEntity
- ResponseEntity<Void> 타입
- ResponseEntity<String> 타입
- ResponseEntity<자바빈즈> 타입
- ResponseEntity<List> 타입
- ResponseEntity<Map> 타입
- ResponseEntity<byte[]> 타입
- ResponseEntity<Map> 타입
- response 할 때 Http 헤더 정보와 <T> 타입 및 내용을 전달하는 용도로 사용

6. 컨트롤러 메서드 반환 값
- @ResponseBody, HttpEntity<B>,
  ResponseEntity<B>, HttpHeaders, String, View, Model, @ModelAttribute, DeferredResult<V> ...
---
### 18. 컨트롤러 요청 처리
- Model : 이동 대상에 전달할 데이터를 가지고 있는 인터페이스
- RedirectAttributes : 리다이렉트 대상에 전달할 데이터를 가지고 있는 인터페이스
- 자바빈즈 클래스 : 요청 파라미터를 가지고 있는 자바빈즈 클래스
- MultipartFile : 멀티파트 요청을 사용해 업로드된 파일 정보를 가지고 있는 인터페이스
- BidingResult : 도메인 클래스의 입력값 검증 결과를 가지고 있는 인터페이스
- java.util.Locale : 클라이언트 로컬
- java.security.Principal : 클라이언트 인증을 위한 사용자 정보를 가지고 있는 인터페이스

- 요청 데이터 처리 어노테이션
- @PathVariable : URL에서 경로 변수 값을 가져오기 위한 어노테이션
- @RequestParam : 요청 파라미터 값을 가져오기 위한 어노테이션
- @RequestHeader : 요청 헤더 값을 가져오기 위한 어노테이션
- @RequestBody : 요청 본문 내용을 가져오기 위한 어노테이션
- @CookieValue : 쿠키 값을 가져오기 위한 어노테이션

- @JsonFormat 어노테이션
- @JsonFormat(pattern="yyyyMMdd")
- private LocalDate dateOfBirth;

- 파일업로드 요청 처리
- MultipartFile
- public ResponseEntity<String> upload(MultipartFile file) throws Exception {
---
### 입력값 검증 규칙
1. Bean Validation 표준 제약 어노테이선
2. 서드파티에서 구현한 제약 어노테이션
3. 직접 구현한 제약 어노테이션
--- 
### 메시지
1. 국제화
2. MessageSource
---
### 예외 처리
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

### 인터셉터

인터셉터(Interceptor)는 웹 애플리케이션 내에서 특정한 URI 호출을 가로채는 역할을 한다.

- 필터(Filter)와 인터셉터

서블릿 기술의 필터와 스프링 MVC의 인터셉터는 특정 URI에 접근할 때 제어하는 용도로 사용된다는 공통점이 있다.

하지만 실행 시점에 속하는 영역(Context)에 차이점이 있다.

인터셉터의 경우 스프링에서 관리하기 때문에 스프링 내의 모든 객체에 접근이 가능하지만

필터는 웹 애플리케이션 영역 내의 자원들은 활용할 수 있지만 스프링 내의 객체에는 접근이 불가능하다.


- 스프링 AOP와 인터셉터

특정 객체 동작의 사전 혹은 사후 처리는 AOP 기능을 활용할 수 있지만 컨트롤러의 처리는 인터셉터를 활용하는 경우가 더 많다.

AOP의 어드바이스와 인터셉터의 가장 큰 차이는 파라미터의 차이라고 할 수 있다.

어드바이스의 경우 JoinPoint나 ProceedingJoinPoint 등을 활용해서 호출 대상이 되는 메서드의 파라미터 등을 처리하는 방식이다.

인터셉터는 필터와 유사하게 HttpServletRequest, HttpServletResponse를 파라미터로 받는 구조이다.

- HandlerInterceptorAdapter 클래스

HandlerInterceptorAdapter는 HandlerInterceptor를 쉽게 사용하기 위해서 인터페이스의 메서드를 미리 구현한 클래스이다.

HandlerInterceptor의 메서드는 다음과 같다.

■ preHandle

지정된 컨트롤러의 동작 이전에 가로채는 역할로 사용한다.

■ postHandle

지정된 컨트롤러의 동작 이후에 처리, DispatcherServlet이 화면을 처리하기 전에 동작한다.

■ afterCompletion

DispatcherServlet의 화면 처리가 완료된 상태에서 처리한다.