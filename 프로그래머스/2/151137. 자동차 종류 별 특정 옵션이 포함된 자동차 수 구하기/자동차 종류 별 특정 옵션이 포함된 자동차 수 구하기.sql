# 자동차 종류 별 - (통풍시트, 열선시트, 가죽시트) 중 하나 이상의 옵션이 포함된 자동차 몇 대?
SELECT car_type, count(*) as cars
FROM CAR_RENTAL_COMPANY_CAR
WHERE options LIKE "%통풍시트%" OR options LIKE "%열선시트%" OR options LIKE "%가죽시트%"
GROUP BY 1
ORDER BY 1