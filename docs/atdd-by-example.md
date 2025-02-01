# ATDD by Example

link: https://youtu.be/APC-G8EfqLM?si=mCZJBoMdI8MGUTFo

```
Feature: 구매
  Scenario: 상품과 수량을 선택하여 가주문(PendingOrder)을 생성한다
    Given 상품이 준비되어 있다
    When 상품을 구매한다
    Then 상품이 판매된다
```
![Image](https://github.com/user-attachments/assets/5cef2f26-4593-45af-89b7-f1412d0c63c9)

- Acceptance Test를 위해 Outside In 방식으로 ControllerTest 작성
- Acceptance Test를 통과하기 위한 ServiceTest 작성

---

## keyword
 
- API First
