### 테이블 설명
    devices 테이블은 IoT 장비를 저장하는 테이블이다.
    IoT 장비로부터 수신받은 데이터를 devices_history 테이블에 저장한다.
    devices테이블에 등록된 IoT 장비들만 devices_history 테이블에 데이터를 저장할 수 있다.

### devices_history 테이블
    cell_id는 기지국(KT) 고유번호를 의미한다.
    battery는 현재 디바이스 배터리 잔량을 의미한다.
    packet_id는 1~5까지 있고, 설명은 아래 테이블을 참고하자.

|packet_id|설명|
|---|---|
|0|신호 시작|
|1|정상 신호|
|2|이동 감지|
|3|배터리 부족|
|4|탈착 감지|
|5|신호 종료|

## 문제

1.  현재 사용중인 디바이스의 uuid와 등록날짜 조회
2.  device_euid가 '1388300'인 수신내역 cell_id, packet_id, battery, create_at 조회
3.  '2021-12-07'에 수신 내역이 있는 디바이스별 pakcet_id 카운트.
    단, packet_id 0,5는 제외
4.  현재 사용중인 디바이스 중 한번도 수신신호를 보낸적이 없는 디바이스의 uuid 조회.
5.  '2021-12-07'에 5번 이상 수신을 받은 디바이스의 uuid와 fw_version, model_name을 조회.