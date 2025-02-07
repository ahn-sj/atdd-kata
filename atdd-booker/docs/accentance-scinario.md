# 인수 조건

## Feature: 도서 등록
```gherkin
Scenario: 새로운 도서 등록하기
  Given 
  When 새로운 도서를 등록하면:
    | 제목 | 저자 | 출판일 | 등록일 |
  Then 도서가 등록되어야 한다

Scenario: 중복된 도서 이름으로 도서 등록 시도
  Given 이미 등록된 도서가 있다
  When 동일한 도서 이름으로 도서를 등록하려고 한다
  Then 중복 도서 등록 오류가 발생해야 한다
```

## Feature: 도서 대출
```gherkin
Scenario: 정상적인 도서 대출
  Given 대출 가능한 도서가 있다
  When 도서를 대출 신청한다
  Then 도서가 성공적으로 대출되어야 한다
```
  
## Feature: 도서 반납
```gherkin
Scenario: 정상적인 도서 반납
  Given 회원이 대출한 도서가 있다
  When 도서를 반납한다
  Then 도서가 성공적으로 반납되어야 한다
```
  
## Feature: 도서 조회
```gherkin
Scenario: 도서 목록 조회
  Given 등록된 도서가 있다
  When 도서 목록을 요청한다
  Then 등록된 모든 도서 목록이 표시되어야 한다
```
  
## Feature: 도서 즐겨찾기
```gherkin
Scenario: 도서 즐겨찾기 등록
  Given 등록된 도서가 있다
  When 도서를 즐겨찾기에 추가한다
  Then 즐겨찾기 목록에 도서가 추가되어야 한다

Scenario: 도서 즐겨찾기 해제
  Given 즐겨찾기에 등록된 도서가 있다
  When 도서를 즐겨찾기에서 제거한다
  Then 즐겨찾기 목록에서 도서가 제거되어야 한다
```
