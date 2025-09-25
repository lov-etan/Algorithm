# '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션 포함된 자동차
# 종류별로 몇 대?
SELECT car_type, count(car_id) as cars
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%' OR OPTIONS LIKE '%열선시트%' OR OPTIONS LIKE '%가죽시트%'
GROUP BY 1
ORDER BY 1