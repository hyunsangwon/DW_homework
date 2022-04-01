-- Mysql DDL
CREATE TABLE food(
    foodNo INTEGER(4) AUTO_INCREMENT PRIMARY KEY COMMENT '음식 번호',
    foodName VARCHAR(20) NOT NULL COMMENT '음식 이름',
    foodPrice INTEGER(4) NOT NULL COMMENT '음식 가격',
);
    
CREATE TABLE restaurant(
    restaurantNo INTEGER(4) AUTO_INCREMENT PRIMARY KEY COMMENT '레스토랑 번호',
    restaurantName VARCHAR(20) NOT NULL COMMENT '레스토랑 이름',
    foodNo INTEGER(4) NOT NULL COMMENT '음식 번호',
    FOREIGN KEY(foodNo) REFERENCES food(foodNo)
);

SELECT * FROM restaurant WHERE foodNo = 30 AND restaurantName= '빠스타스';
/* 문제 1.
레스토랑 테이블에 데이터가 일일 1000만건 저장된다. 
레스토랑 테이블에서 위에 작성한 select쿼리 호출 시간이 오래 걸리기 시작했다.
가장 먼저해야하는 바람직한 행동은?
답안 작성 => foodNo 컬럼에 인덱스를 추가한다.
*/

DELETE FROM food
WHERE foodNo = 30;
/* 문제 2.
음식 테이블에 30번 음식 데이터를 지우려고 한다.
하지만 레스토랑 테이블에 30번 데이터가 있어서 지울 수가 없다. 
음식 테이블에 30번 데이터를 지울 방법은 무엇일까?
답안 작성 => on delete cascade
    -- 이벤트 종류
    -- cascade : 자식 데이터 삭제or 수정
    -- set null : 자식 데이터 null로 업데이트
    -- set default : 자식 데이터 참조 컬럼을 Default 값으로 업데이트
    -- restrict(default) : 자식 테이블이 참조하고 있을 경우, 데이터 삭제or 수정 불가
    -- no action : 자식 테이블의 데이터는 변경되지 않습니다.
*/