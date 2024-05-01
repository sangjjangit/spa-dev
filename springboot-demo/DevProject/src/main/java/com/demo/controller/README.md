### 16. 컨트롤러 요청 매핑

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
   1. ResponseEntity<Void> 타입
   2. ResponseEntity<String> 타입
   3. ResponseEntity<자바빈즈> 타입
   4. ResponseEntity<List> 타입
   5. ResponseEntity<Map> 타입
   6. ResponseEntity<byte[]> 타입
   7. ResponseEntity<Map> 타입
   - response 할 때 Http 헤더 정보와 <T> 타입 및 내용을 전달하는 용도로 사용


6. 컨트롤러 메서드 반환 값
- @ResponseBody, HttpEntity<B>,
  ResponseEntity<B>, HttpHeaders, String, View, Model, @ModelAttribute, DeferredResult<V> ...

---

### 18. 컨트롤러 요청 처리
- 주요 파라메터
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

### 19. 입력값 검증 규칙
1. Bean Validation 표준 제약 어노테이선
2. 서드파티에서 구현한 제약 어노테이션
3. 직접 구현한 제약 어노테이션
--- 