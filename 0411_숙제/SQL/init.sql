CREATE TABLE IF NOT EXISTS devices
(
    device_uuid VARCHAR(10) NOT NULL PRIMARY KEY COMMENT '디바이스 고유번호',
    fw_version VARCHAR(10) NOT NULL COMMENT '펌웨어 버전',
    model_name VARCHAR(20) COMMENT '디바이스 모델이름',
    is_use BOOLEAN COMMENT '디바이스 사용여부 (true: 사용, false, 미사용)',
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '디바이스 등록날짜'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS devices_history
(
    history_no BIGINT(20) AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '히스토리 번호',
    packet_id INTEGER(2) CHECK (packet_id IN (0, 1, 2, 3, 4, 5)) COMMENT '패킷 ID',
    device_uuid VARCHAR(10) NOT NULL COMMENT '디바이스 고유번호',
    cell_id VARCHAR(10) COMMENT '기지국 아이디'
    battery INTEGER(4) COMMENT '배터리',
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '수신 날짜',
    FOREIGN KEY (device_uuid) REFERENCES devices (device_uuid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('1388300', '0.1', 'MODEL_100', TRUE);
INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('3188320', '0.1', 'MODEL_100', TRUE);
INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('2188330', '0.1', 'MODEL_100', TRUE);
INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('1688340', '0.1', 'MODEL_100', TRUE);
INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('1388350', '0.1', 'MODEL_100', TRUE);
INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('2598300', '0.1', 'MODEL_100', TRUE);
INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('1988311', '0.1', 'MODEL_100', TRUE);
INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('1288320', '0.1', 'MODEL_100', TRUE);
INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('1588310', '0.1', 'MODEL_100', TRUE);
INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('2288330', '0.1', 'MODEL_100', FALSE);
INSERT INTO devices(device_uuid, fw_version,  model_name, is_use) VALUES('3288320', '0.1', 'MODEL_100', FALSE);


INSERT INTO devices_history(packet_id, device_uuid, cell_id, battery, create_at) VALUES(0,'1388300','39991',83, '2021-12-07 06:30:13');
INSERT INTO devices_history(packet_id, device_uuid, cell_id, battery, create_at) VALUES(1,'1388300','39991',75, '2021-12-07 07:00:23');
INSERT INTO devices_history(packet_id, device_uuid, cell_id, battery, create_at) VALUES(3,'1388300','39991',25, '2021-12-07 09:30:37');
INSERT INTO devices_history(packet_id, device_uuid, cell_id, battery, create_at) VALUES(3,'1388300','39991',22, '2021-12-07 10:20:29');
INSERT INTO devices_history(packet_id, device_uuid, cell_id, battery, create_at) VALUES(3,'1388300','39991',8, '2021-12-07 11:10:37');
INSERT INTO devices_history(packet_id, device_uuid, cell_id, battery, create_at) VALUES(5,'1388300','39991',1, '2021-12-07 12:55:31');

INSERT INTO devices_history(packet_id, device_uuid, cell_id, battery, create_at) VALUES(0,'2288330','39991',32, '2021-12-07 15:30:37');
INSERT INTO devices_history(packet_id, device_uuid, cell_id, battery, create_at) VALUES(1,'2288330','39991',30, '2021-12-07 16:12:40');
INSERT INTO devices_history(packet_id, device_uuid, cell_id, battery, create_at) VALUES(1,'2288330','39991',30, '2021-12-07 16:40:11');
INSERT INTO devices_history(packet_id, device_uuid, cell_id, battery, create_at) VALUES(5,'2288330','39991',30, '2021-12-07 17:30:00');