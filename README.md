# AVO-back

## AVO
> #### 🥑 청각장애를 가진 부모님들의 육아를 도와주는 서비스  <br>
> #### 🥑 사용자 맞춤 진동 서비스. 각 상황별로 사용자가 설정한 진동과 함께 푸시알림을 보내주는 기능 탑재
>       - 우는 상황, 소리지르는 상황, 엄마,아빠를 부르는 상황: 총 3가지 상황
>       - 한 번 진동, 두 번 진동, 세 번 진동, 연속 진동: 총 4가지 진동 설정 가능

## 💡 Backend 사용 기술
- Java, Python
- Spring Boot, Flask
- AWS EC2, Lambda, S3
- raspberry

## 코드 간단 설명
- raspberry/rasp.py : 라즈베리파이의 마이크에서 음성을 2초간 녹음 후 녹음 데이터를 s3 버킷에 업로드
- lambda/lambda_function.py : s3에 새로운 객체가 업로드됨을 감지하면 flask서버, 즉 5000포트로 http request보냄
- flask/total.py : Flask로 요청이 오면 S3 객체를 amazon transcribe와 AI repository의 model로 분석 + 분류 결과값을 spring boot의 fcm으로 전송
- src/fcm : Firebase와 연동하여 백그라운드에서도 프론트에 알람을 보낼 수 있기 위한 용도
- src/controller/AvoController : EC2에 배포가 잘 되었는지 테스트하기 위한 용도
- src/flask : EC2에 Flask 배포가 잘 되었는지 테스트하기 위한 용도
