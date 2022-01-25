# 🧑🏻‍💻SpringBoot-petition(국민청원 사이트)🇰🇷

### 1. Description

최근 스프링 부트 강의를 듣고 공부하면서 공부한 내용을 가지고 어떤 미니프로젝트를 만들지 고민하였습니다.</br>
보통 게시판이나 todoList등을 많이 만든다고 하지만 다른 흥미로운 것을 만들어 보고 싶었고,</br>
최근 백신패스, 애완동물 학대 문제 등 사회적 이슈를 청와대 국민청원으로 올리는 것을 보게 되었습니다.</br>
청와대 국민청원 페이지를 모방해 본다면 기본적인 CRUD, 로그인, 회원가입 등 배운 모든 내용을 사용할 수 있고</br>
재밌는 미니 프로젝트가 될 것이라 생각되어 시작하게 되었습니다.</br>


### 2. Environment

OS: MAC</br>
Programming Language: JAVA (version 11)</br>
FrameWork: Spring Boot(version 2.5.8)</br>


### 3. Prerequisite

프로젝트 세팅시 Spring Web, Thymeleaf, Lombok을 추가했습니다.


### 4. Files 

petition 패키지 하위 패키지로 domain과 web 패키지가 중요하다고 생각하여 간단히 소개하겠습니다.</br>
domain패키지에는 DB에서의 엔티티 저장되어야 하는 데이터, 예를 들어 회원 클래스(이름, 아이디, 비밀번호), 청원 클래스(청원 제목, 분야)등의 데이터와</br>
Repository, 서비스 로직에 대한 코드가 들어있고, web패키지에는 URL 매핑정보 및 기능과 관련된 컨트롤러,<br>
로그인 회원가입을 위한 Spring interceptor 코드, Form 데이터 누락을 막아주는 Validation 코드 등이 있습니다.</br>
추가적으로 view와 관련된 코드는 resources 패키지에 있습니다.</br>

### Usage

