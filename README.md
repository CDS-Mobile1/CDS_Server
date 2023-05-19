# CDS_Server

> 32th CDS1_Instargram_Server <br>
>
> 합동 세미나 모바일 1조

<br>

## 🖤 CDS-Mobile1 Server Developers


| 조예슬 | 신지연 |
| :---------:|:----------:|
|<img width="300" alt="image" src="https://github.com/CDS-Mobile1/CDS_Server/assets/68415644/419dcac6-e13d-4d65-b058-250fcd869bff"> | <img width="300" alt="image" src="https://github.com/CDS-Mobile1/CDS_Server/assets/68415644/dd390d83-9088-4c83-80a5-36df1002362d">| 
| [yeseul106](https://github.com/yeseul106) | [jiyeoon00](https://github.com/jiyeoon00) |



<br>

## 🗂️ Project Foldering

- **도메인 별로 Architecture를 나눴습니다.**

```
└── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   ├── 📁 common
│   │   │   │   ├── 📁 domain
│   │   │   │   │   └── TimeStamped.java
│   │   │   │   ├── 📁 dto
│   │   │   │   ├── 📁 exception
│   │   │   ├── 📁 config
│   │   │   │   └── JpaAuditingConfig.java
│   │   │   ├── 📁 friend
│   │   │   │   ├── 📁 domain
│   │   │   │   ├── 📁 dto
│   │   │   │   ├── 📁 controller
│   │   │   │   ├── 📁 repository
│   │   │   │   ├── 📁 service
│   │   │   ├── 📁 member
│   │   │   ├── 📁 post
│   │   │   ├── 📁 story
│   │   │   ├── 📁 storyTag
│   │   │   └── InstargramServerApplication.java
│   │   ├── 📁 resources
│   │   │   └── application.yml
└── └── 📁 test
```
<br>

## 📌 ERD
https://www.erdcloud.com/d/2Wv89JpjHMjbmgJ9f

<img width="780" alt="image" src="https://github.com/CDS-Mobile1/CDS_Server/assets/68415644/28b044e3-e6bc-4e2c-9650-7fd2cbf3790f">

<br>
<br>

## 🖇 Api 명세서

https://yesuri-masuri.notion.site/API-22d41d9914fd4bd38d2af8e658739609

<img width="1070" alt="image" src="https://github.com/CDS-Mobile1/CDS_Server/assets/68415644/00e2d89a-14e2-4be1-9357-043aca150736">


## 🙋🏻‍♀️ 역할 분담

<div markdown="1">  
 
| 기능명 | 담당자 | 완료 여부 |
| :-----: | :---: | :---: |
| 프로젝트 세팅 | `지연🍒` | 완료 |
| EC2 세팅 | `예슬🍑` | 완료 |
| RDS 세팅 | `예슬🍑` | 완료 |
| DB 설계 | `예슬🍑` `지연🍒` | 완료 |
| API 명세서 작성 | `예슬🍑` `지연🍒` | 완료 |
| API 개발 | `예슬🍑` `지연🍒` | 완료 |
 
</div>
 <br>

## 📌 Coding Convention
 
<details>
<summary>변수(함수) 명에 대한 Naming Convention</summary>
<div markdown="1"> 

- **변수, 함수, 인스턴스**

변수, 함수, 인스턴스를 작성할 때는 *Camel Case(카멜 케이스)*를 사용합니다.

> ex) camelCase
> 

- **함수명 작성**

함수명을 작성할 때는 동사+명사 형태로 구성합니다.

> ex) getUserInfomation()
> 

- **Class, Constructor**

Class, Constructor를 작성할 때는 *Pascal Case(=upper 카멜 케이스)*를 사용합니다.

> ex) CamelCase
> 

- **Flag로 사용되는 변수**

플래그(Flag)란 '깃발'이란 의미이지만, 프로그래밍에서는 '상태를 기록하고 처리 흐름을 제어하기 위한 boolean 변수'를 의미합니다.

> Boolean의 경우 조동사+flag 종류로 구성됩니다. ex) isNum, hasNum
> 

- **약칭의 사용**

약어는 되도록 사용하지 않는 것이 좋습니다. 부득이하게 약어가 필요하다고 판단되는 경우 팀원과의 상의를 거쳐보아요.

단, 숫자일 경우 max, min, total과같은 단어로 설명하기루 합니다.

```jsx
let idx; // bad
let index; // good

let cnt; // bad
let count; // good

let arr; // bad
let array; // good

let seoul2Bucheon; // bad
let seoulToBucheon; // good
```
</div>
</details>

<details>
<summary>주석 규칙</summary>
<div markdown="1"> 

한줄은 //로 적고, 그 이상은 /** */로 주석을 작성합니다.

> // 한 줄 주석일 때

/**
*여러줄
*주석일 떄
*/
> 

- **함수에 대한 주석**

backend에서 공통적으로 사용하는 함수의 경우, 모듈화를 통해 하나의 파일로 관리합니다. 
하나의 파일의 시작 부분에 주석으로 상세 내용을 작성합니다. 정리해야 하는 부분은 다음과 같습니다.

- **함수의 전체 기능**에 대한 설명
- 예시 코드
    
    ```jsx
    영ㅎ
    
    router.get(
      "/study/:roomNumber/questions",
      [checkParamAndQuery("roomNumber").isNumeric()],
      getQuestions.default
    );
    ```
</div>
</details>
    
<details>
<summary>함수 사용</summary>
<div markdown="1"> 

- **else if의 사용**

불가피한 경우를 제외하고 else if의 사용을 최대한 줄여야 합니다. ex) 조건을 만족하면 탈출하는 if로 구현하는 등

```jsx
if ( a > b ) {
  //...
} else if ( b > a ){   -> bad
  //...
}

if ( a > b) {
  //...
} else {  -> good
  //...     
}
```

- **함수 파라미터 개수 제한**

함수의 인자로 변수를 선언하는 것은 3개까지 가능합니다.

```jsx
function test (a, b, c, d) {
    console.log(a, b, c, d) => bad
}

function test (a, b, c) {
    console.log(a, b, c) => good
}
```

- **비동기 함수의 사용**

Promise함수의 사용은 지양하고 async, await를 사용하도록 합니다. 

- 화살표 함수의 사용

최대한 화살표 함수를 사용해서 코드를 구현한다.
  
</div>
</details>
<br>
 
## ☑️ Git Convention
### 📌 Commit Convention

[💻 Commit Convention](https://yesuri-masuri.notion.site/Git-08bb41f003044937b9cd67b62dc0436b)


### 📌 Branch Convention

- [develop] : 최종 배포
- [feature] : 기능 추가
- [fix] : 에러 수정, 버그 수정
- [refactor] : 코드 리펙토링 (기능 변경 없이 코드만 수정할 때)
- [modify] : 코드 수정 (기능의 변화가 있을 때)
- [chore] : gradle 세팅, 위의 것 이외에 거의 모든 것


### 📌 Branch Strategy

[💻 Git 브랜치 전략](https://yesuri-masuri.notion.site/Git-d3c6adb65f23483397b25f028dbfa31b)

<br>


### 📌 Issue Convention
- [FEAT] : 기능 추가
- [FIX] : 에러 수정, 버그 수정
- [REFACTOR] : 코드 리펙토링 (기능 변경 없이 코드만 수정할 때)
- [MODIFY] : 코드 수정 (기능의 변화가 있을 때)
- [CHORE] : gradle 세팅, 위의 것 이외에 거의 모든 것

`ex) [FEAT] 게시물 생성 API`





