# Outside In TDD, ATDD를 예제를 통해서 알아봅니다.

link: https://youtu.be/EFB-h5jMFDk?si=RC8aAmiQ3lWKG3LU

**Acceptance Test**

- MockMvc
- TestRestTemplate
- RestAssured
- Spock RestAssured (Groovy)
- Spock HttpBuilder (Groovy)

### Acceptance Test Sample - Bank Kata

https://github.com/sandromancuso/Bank-kata

### ATDD 기반 웹 애플리케이션 개발

https://github.com/msbaek/atdd-example

**Double Loop TDD**

- 처음에는 Acceptance Test를 통과하기 위한 최소한의 코드(Outer Loop)를 작성
- Acceptance Test가 올바른 이유로 실패하면 Inner Loop(단위 테스트)를 작성
- 단위 테스트가 통과하면 Acceptance Test도 통과할 것을 기대

### TDD Techniques TIP

- subclass and override method

related link: https://medium.com/android-testing-daily/subclass-and-override-1492f0564b35

![Image](https://github.com/user-attachments/assets/9756a574-30e5-4fbd-bcb1-3b7485757237)
