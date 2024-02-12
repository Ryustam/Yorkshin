# Yorkshin
Yorkshin project 

* SecurityConfig 작성

* Form 로그인 방식에서 UsernamePasswordAuthentication 필터에서 회원 검증을 진행을 시작한다. 
* JWT는 SecurityConfig에서 formLogin 방식을 disable = 기본적으로 활성화 되어 있는 해당 필터는 동작하지 않는다.
* 따라서 로그인을 진행하기 위해서 해당 필터를 커스텀하여 등록해야 한다.

