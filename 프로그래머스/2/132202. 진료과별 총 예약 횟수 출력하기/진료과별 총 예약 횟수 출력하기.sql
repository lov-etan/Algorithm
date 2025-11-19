-- 코드를 입력하세요
SELECT mcdp_cd as 진료과코드, COUNT(apnt_no) as 5월예약건수
FROM appointment
WHERE YEAR(apnt_ymd) = '2022' && MONTH(apnt_ymd) = '05'
GROUP BY 1
ORDER BY 2, 1