# ๐ง๐ปโ๐ปSpringBoot-petition(๊ตญ๋ฏผ์ฒญ์ ์ฌ์ดํธ)๐ฐ๐ท

### 1. Description

์ต๊ทผ ์คํ๋ง ๋ถํธ ๊ฐ์๋ฅผ ๋ฃ๊ณ  ๊ณต๋ถํ๋ฉด์ ๊ณต๋ถํ ๋ด์ฉ์ ๊ฐ์ง๊ณ  ์ด๋ค ๋ฏธ๋ํ๋ก์ ํธ๋ฅผ ๋ง๋ค์ง ๊ณ ๋ฏผํ์์ต๋๋ค.</br>
๋ณดํต ๊ฒ์ํ์ด๋ todoList๋ฑ์ ๋ง์ด ๋ง๋ ๋ค๊ณ  ํ์ง๋ง ๋ค๋ฅธ ํฅ๋ฏธ๋ก์ด ๊ฒ์ ๋ง๋ค์ด ๋ณด๊ณ  ์ถ์๊ณ ,</br>
์ต๊ทผ ๋ฐฑ์ ํจ์ค, ์ ์๋๋ฌผ ํ๋ ๋ฌธ์  ๋ฑ ์ฌํ์  ์ด์๋ฅผ ์ฒญ์๋ ๊ตญ๋ฏผ์ฒญ์์ผ๋ก ์ฌ๋ฆฌ๋ ๊ฒ์ ๋ณด๊ฒ ๋์์ต๋๋ค.</br>
์ฒญ์๋ ๊ตญ๋ฏผ์ฒญ์ ํ์ด์ง๋ฅผ ๋ชจ๋ฐฉํด ๋ณธ๋ค๋ฉด ๊ธฐ๋ณธ์ ์ธ CRUD, ๋ก๊ทธ์ธ, ํ์๊ฐ์ ๋ฑ ๋ฐฐ์ด ๋ชจ๋  ๋ด์ฉ์ ์ฌ์ฉํ  ์ ์๊ณ </br>
์ฌ๋ฐ๋ ๋ฏธ๋ ํ๋ก์ ํธ๊ฐ ๋  ๊ฒ์ด๋ผ ์๊ฐ๋์ด ์์ํ๊ฒ ๋์์ต๋๋ค.</br>


### 2. Environment

OS: MAC</br>
Programming Language: JAVA (version 11)</br>
FrameWork: Spring Boot(version 2.5.8)</br>


### 3. Prerequisite

ํ๋ก์ ํธ ์ธํ์ Spring Web, Thymeleaf, Lombok์ ์ถ๊ฐํ์ต๋๋ค.


### 4. Files 

petition ํจํค์ง ํ์ ํจํค์ง๋ก domain๊ณผ web ํจํค์ง๊ฐ ์ค์ํ๋ค๊ณ  ์๊ฐํ์ฌ ๊ฐ๋จํ ์๊ฐํ๊ฒ ์ต๋๋ค.</br>
domainํจํค์ง์๋ DB์์์ ์ํฐํฐ ์ ์ฅ๋์ด์ผ ํ๋ ๋ฐ์ดํฐ, ์๋ฅผ ๋ค์ด ํ์ ํด๋์ค(์ด๋ฆ, ์์ด๋, ๋น๋ฐ๋ฒํธ),</br> 
์ฒญ์ ํด๋์ค(์ฒญ์ ์ ๋ชฉ, ๋ถ์ผ)๋ฑ์ ๋ฐ์ดํฐ์ Repository, ์๋น์ค ๋ก์ง์ ๋ํ ์ฝ๋๊ฐ ๋ค์ด์๊ณ , </br> 
webํจํค์ง์๋ URL ๋งคํ์ ๋ณด ๋ฐ ๊ธฐ๋ฅ๊ณผ ๊ด๋ จ๋ ์ปจํธ๋กค๋ฌ, ๋ก๊ทธ์ธ ํ์๊ฐ์์ ์ํ Spring interceptor ์ฝ๋,</br>
Form ๋ฐ์ดํฐ ๋๋ฝ์ ๋ง์์ฃผ๋ Validation ์ฝ๋ ๋ฑ์ด ์์ต๋๋ค.</br>
์ถ๊ฐ์ ์ผ๋ก view์ ๊ด๋ จ๋ ์ฝ๋๋ resources ํจํค์ง์ ์์ต๋๋ค.</br>


### 5. Usage

์คํ ์์

https://hnet.com/video-to-gif/viewimage/20220124-16-UUNwRkmyvnSQ2TWB-soKdAO-HNET


### 6. Things to improve

1. ๋ก๊ทธ์ธ ์ ๋ค๋น๊ฒ์ด์ ๋ฐ ๋์์ธ
2. ์ฒญ์์ ์ ์นด์ดํธ ๊ธฐ๋ฅ
3. RDBMS ์ ์ฉ
4. Error Page
