-- 코드를 입력하세요
SELECT (MCDP_CD) as 진료과코드, count(*) as 5월예약건수
FROM appointment
WHERE date(apnt_ymd) between '2022-05-01' and '2022-05-31'
GROUP BY MCDP_CD 
ORDER BY 5월예약건수, MCDP_CD;
