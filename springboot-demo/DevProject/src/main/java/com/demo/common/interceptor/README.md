
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