# AVO-back
청각장애를 가진 부모님들을 위한 육아 보조 서비스, AVO의 backend repository입니다.

## 💡 사용 기술
- Java
- Spring Boot
- AWS EC2, Lambda, S3

## 구조 설명
- AvoController : EC2에 배포가 잘 되었는지 테스트하기 위한 용도
- FCM : Firebase와 연동하여 백그라운드에서도 프론트에 알람을 보낼 수 있기 위한 용도
- Flask : EC2에 Flask 배포가 잘 되었는지 테스트하기 위한 용도
