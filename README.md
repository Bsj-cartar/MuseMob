# MUSEMOB 
<img src="https://user-images.githubusercontent.com/50193137/116794509-6a832600-ab08-11eb-8450-77ac193f5c18.png" width="100%"> 


musemob은 '예술적 영감'이란 뜻의 muse와 '폭도'란 뜻의 mob의 합성어로 밴드음악을 기초로 한 이들이 모여서 자신들의 작품을 공유하고, 포인트를 걸고 하는 배틀을 할 수 있습니다.  

## 기능
1. 회원가입, 로그인
    - 단순한 문자열 비교로 동작  
    <img src="https://user-images.githubusercontent.com/50193137/116794504-6820cc00-ab08-11eb-955a-7e9d24792292.png" height="200">
    <img src="https://user-images.githubusercontent.com/50193137/116794507-69ea8f80-ab08-11eb-95b2-3c91d09833bb.png" height="200">
2. 밴드음악 동영상 게시판
    - 유투브 API 사용으로 게시가능
    - page navigation 동작  
    <img src="https://user-images.githubusercontent.com/50193137/116794505-6951f900-ab08-11eb-9e91-08206106b68e.png" height="200">
    <img src="https://user-images.githubusercontent.com/50193137/116794517-6e16ad00-ab08-11eb-9083-eae2a351f42b.png" height="200">
    <img src="https://user-images.githubusercontent.com/50193137/116794519-6eaf4380-ab08-11eb-8037-fea5444802bf.png" height="200">
3. 사이트 내 사용가능한 포인트
    - 로그인 시 5포인트씩 지급
    - 현재 진행 중인 Musemob 게시물에 응원  
    <img src="https://user-images.githubusercontent.com/50193137/116794510-6bb45300-ab08-11eb-82bf-b9ac2492d94d.png" height="200">  
    <img src="https://user-images.githubusercontent.com/50193137/116794514-6d7e1680-ab08-11eb-926d-afd56579eec9.PNG" height="60">
4. 사용자가 지정하는 게시물과 배틀(Musemob)
    - Musemob을 게시할 때 100포인트를 차감
    - Musemob에 승리할 시 응원 포인트를 전부 획득  
    - 일정시간 후 집계를 통해 승패자 결정  
    <img src="https://user-images.githubusercontent.com/50193137/116794512-6ce58000-ab08-11eb-95c3-886618d0f6c5.png" height="200">
    <img src="https://user-images.githubusercontent.com/50193137/116794513-6ce58000-ab08-11eb-9163-8efe2edeaca2.PNG" height="60">

### <기능 보완>
    - 자체적인 동영상 서버 구축
    - 자신의 youtube 영상만을 등록할 수 있도록 수정
    - view구현 jsp -> thymeleaf
    - frontend framework 사용(vue, angular)
    - css 반응형 적용(일부 수정 요망)
    - 관리자 페이지 개발
    - 스프링 시큐리티 적용
    - JUnit을 통한 테스트 케이스 적용 및 자동화
    - Mapper xml 방식 -> spring data JPA로 구현
    - (기능 1) 비밀번호 암호화, 복호화 동작 구현
    - (기능 1) 로그인 페이지, 회원가입 페이지 버그수정 및 오류페이지 개선
    - (기능 2) 게시판 css 오류 수정
    - (기능 3) 포인트 수급처 다양화
    - (기능 4) 집계 시스템에 대한 구체적인 기준 수립과 방식 수정
    - 에러 페이지 디자인 및 해당 에러 발생 시 매칭

## 기술 스택

- FE : HTML, CSS, JS, jsp/jstl(SSR)
- BE : JAVA(Spring), Spring boot, tomcat, maven
- DB : MySQL, mybatis
- Tools : devtools, lombok
- IDE : STS

## 기타

- css 템플릿은 https://templated.co/ 에서 Industrious 디자인을 사용하여 작성했습니다.




