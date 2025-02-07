## 인수 테스트

인수테스트는 시나리오(사용자 스토리) 기반으로 기능을 테스트 하는 테스트 방법입니다.

인수테스트는 사용자 스토리를 기반으로 테스트 케이스를 작성하기 때문에 QA 팀이 쉽게 이해할 수 있습니다.

## 인수 테스트의 사이클

- 전체적인 인수 시나리오 작성 및 기능 설계
- 인수 테스트 케이스 작성
  - 인수 테스트는 Outside-In 테스트 방법을 사용합니다.
  - Double Loop TDD 방법을 사용합니다.

> Double Loop TDD 방법은 아래와 같은 사이클을 반복합니다.<br/>
> - 처음에는 Acceptance Test를 통과하기 위한 최소한의 코드(Outer Loop)를 작성 <br/>
> - Acceptance Test가 올바른 이유로 실패하면 Inner Loop(단위 테스트)를 작성<br/>
> - 단위 테스트가 통과하면 Acceptance Test도 통과할 것을 기대

## 인수테스트 도구

\[Server Tool\]

- @SpringBootTest

\[Client Tool\]

- MockMvc
- RestAssured

\[Test Tool\]
- JUnit
- AssertJ

## 인수 테스트 특징

- 인수테스트는 내부 구조나 구현 세부 사항을 숨기는 블랙박스(Black Box) 테스트 방법입니다.
  - 즉, 사용자가 기능을 이용하는 것을 테스트 하는 것에 집중한다.


## 테스트 격리

EntityManager를 활용한 TRUNCATE 쿼리를 사용하여 테이블을 초기화 합니다.<br/>
= DatabaseCleanUp

```sql
TRUNCATE TABLE book;
```

참고: https://velog.io/@sanbonai06/Spring-Boot-Test-인수-테스트

## 인수 조건 양식

```graphql
Feature: 소프트웨어의 기능을 설명하거나 연관된 시나리오를 그룹핑 하는 키워드(의도 파악과 의미 전달이 용이한 정도로 작성)
  Scenario: 비지니스 규칙을 설명하는 구체적인 예시. Given, When, Then 등의 step 으로 이루어짐 (참고로 너무 많은 step 은 가독성이 떨어지기 때문에 3 ~ 5 step 을 권장)
    Given: 시스템의 초기 컨텍스트, 즉 초기 시나리오의 장면이나 조건을 설명하는 데 사용. 사용자가 시스템과 상호작용을 시작하기 전에 어떤 상태인지 알려주는 역할
    (And): 추가적인 Given 조건이 있는 경우
    When: 사용자와 시스템간의 상호작용, 다른 시스템에 의해 발생할 수 있는 이벤트. 구현에 대한 세부 사항은 숨깁니다.
    Then: 예상되는 결과나 결과에 대해서 설명. 사용자가 눈으로 확인할 수 있는 것들에 대해서 묘사

예를 들면 다음과 같습니다.
Scenario: 통장의 돈 인출하기
  Given 깨꾹이는 통장이 있다.
  And 깨꾹이의 잔액은 400 만원이다.
  When 돈을 인출할 때
  Then ATM 은 카드를 삼켜야 한다.
  And 돈이 인출되어야 한다.
```

