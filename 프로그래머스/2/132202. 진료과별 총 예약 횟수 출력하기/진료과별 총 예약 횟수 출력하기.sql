# 2022년 5월에 예약한 환자 수 <- 진료과코드별 조회
SELECT MCDP_CD as '진료과코드', COUNT(apnt_no) as '5월예약건수'
FROM APPOINTMENT
WHERE apnt_ymd LIKE "2022-05%"
GROUP BY 1
ORDER BY 2, 1