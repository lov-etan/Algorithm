# 2022년 5월 예약한 환자 '수'
# 진료과코드 별 조회 
SELECT MCDP_CD as '진료과코드', COUNT(apnt_no) as '5월 예약 건수'
FROM APPOINTMENT
WHERE APNT_YMD LIKE '2022-05%' 
GROUP BY MCDP_CD
ORDER BY 2 , 1