USE 세계무역;

-- *은 모든 컬럼을 가져온다.
SELECT * FROM 고객;

-- 출력되는 행의 개수
SELECT COUNT(*) AS '행의 갯수' FROM 고객;

SELECT 고객번호, 담당자명, 고객회사명, 마일리지 AS 포인트,
	마일리지 * 1.1 AS `10% 인상된 마일리지`
FROM 고객;

SELECT 고객번호, 담당자명, 마일리지 AS 포인트
FROM 고객 WHERE 마일리지 >= 100000;

SELECT 고객번호, 담당자명, 도시, 마일리지 AS 포인트
FROM 고객
WHERE 도시 = '서울특별시'
ORDER BY 마일리지 DESC;

-- limit
SELECT * FROM 고객
LIMIT 3;

-- 마일리지 상위 3명 / 하위 3명
SELECT * FROM 고객
ORDER BY 마일리지 DESC
LIMIT 3

SELECT * FROM 고객
ORDER BY 마일리지 ASC
LIMIT 3;

-- 중복 제거 distinct
SELECT DISTINCT 도시
FROM 고객;

-- 산술 연산자
SELECT 23 + 5 AS 더하기
	,23 - 5 AS 빼기
	,23 * 5 AS 곱하기
	,23 / 5 AS 실수나누기
	,23 DIV 5 AS 정수나누기
	,23 % 5 AS 나머지1
	,23 MOD 5 AS 나머지2;

-- 비교 연산자   0: FALSE, 1: TRUE
SELECT 23 > 23
	, 23 < 23
	, 23 = 23
	, 23 <> 23 -- 23 != 23과 동일
	, 23 != 23
	, 23 >= 5
	, 23 <= 5;

SELECT *
FROM 고객
WHERE 담당자직위 <> '대표 이사';

SELECT *
FROM 고객
WHERE 도시 = '부산광역시'
AND 마일리지 < 1000;

-- 집합연산자 UNION, UNION ALL
-- UNION : 두개의 SELECT 결과를 합쳐줌
--		 : 컬럼의 갯수와 타입을 일치시켜야 됨
-- UNION ALL : 중복되는 레코드도 다 출력해 줌
SELECT 고객번호, 도시, 마일리지
FROM 고객
WHERE 도시 = '부산광역시';


-- IN : ~중에 하나가 있으면 TRUE( 여러개의 OR를 대체 )
-- BETWEEN AND : ~이상 ~이하 범위를 지정할 때 ( 비교, AND를 대체 )
SELECT 고객번호
		,담당자명
		, 담당자직위
FROM 고객
WHERE 담당자직위 BETWEEN 100000 AND 200000;

-- LIKE : 문자열의 일부를 검사할 때 사용
-- 		: % 여러 문자열을 대체
--		: _ 한 글자를 대체
SELECT *
FROM 고객
WHERE 도시 LIKE '%광역시'
AND (고객번호 LIKE '_C%' OR 고객번호 LIKE '__SC%');


-- 실전문제
-- 1. 제품 테이블에서 세계무역이 취급하는 제품 중에서 '주스' 제품에 대한 모든 정보를 검색하시오.
SELECT *
FROM 제품
WHERE 제품명 LIKE '%주스';
-- 2. 제품 테이블에서 단가가 5,000원 이상 10,000원 이하인 '주스'제품에는 무엇이 있는지 검색하시오.
SELECT *
FROM 제품
WHERE 단가 BETWEEN 5000 AND 10000
AND 제품명 LIKE '%주스';
-- 3. 제품 테이블에서 제품번호가 1,2,4,7,11,20인 제품의 모든 정보를 보이시오.
SELECT *
FROM 제품
WHERE 제품번호 IN (1, 2, 4, 7, 11, 20);
-- 4. 제품 테이블에서 재고금액이 높은 상위 10개 제품에 대해 제품번호, 제품명, 
-- 단가, 재고, 재고금액(단가 * 재고)을 보이시오.
SELECT 제품번호
		,제품명
		,단가
		,재고
		,단가 * 재고 AS 재고금액
FROM 제품
ORDER BY 재고금액 DESC
LIMIT 10;

