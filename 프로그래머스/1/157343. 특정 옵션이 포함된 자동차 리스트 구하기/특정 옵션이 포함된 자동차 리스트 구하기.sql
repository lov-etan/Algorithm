# 네비게이션 옵션 포함 자동차 리스트
SELECT *
FROM CAR_RENTAL_COMPANY_CAR
WHERE options LIKE '%네비게이션%'
ORDER BY car_id DESC