# JWT-SPRING

### 시큐리티 설정 HTTP, web접근 설정
* SecurityConfig
* applicaton.yml
* build.gradle

### entity 설정 추가
* User
* Authority

### JWT 설정추가
* TokenProvider 토큰의 생성, 유효성검사
* JwtFilter 토큰의 인증정보를 SecurityContext에 저장하는 역할 수행
* JwtSecurityConfig TokenProvider, JwtFilter를 SecurityConfig에 적용할때 사용할 JwtSecurityConfig 클래스
* JwtAccessDeniedHandler 403 Error handle
* JwtAuthenticationEntryPoint 유효한 자격증명을 제공하지 않고 접근하려 할때 401

### DTO
* LoginDto
* TokenDto
* UserDto

### Repository
* AuthorityRepository
* UserRepository

### Service
* CustomUserDetailsService 로그인시에 DB에서 유저정보와 권한정보를 가져오게 된다. 해당 정보를 기반으로 userdetails.User 객체를 생성해서 리턴한다.
* UserService username이 db에 존재하지 않으면 Authority와 User 정보를 생성해서 UserRepository의 save메소드를 통해 DB에 정보를 저장한다.

### controller
* AuthController 토큰 발급
* HelloController api test
* UserController 회원가입/검증

### 회원가입
* POST http://localhost:8080/api/signup
{
    "username":"gos1004",
    "password":"gos1004",
    "nickname":"nickname"
}

### 토큰 발급
* POST http://localhost:8080/api/authenticate
{
  "username" : "admin",
  "password" : "admin"
}

### API TEST
* http://localhost:8080/api/hello

### GET User
* http://localhost:8080/api/user/admin
* Authorization:Bearer [token]
### GET User All
* http://localhost:8080/api/user
* Authorization:Bearer [token]
