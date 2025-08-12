# 2022년 4월 13일 / 취소 안 된! / CS 진료 예약 내역
WITH cte AS (
    SELECT *
    FROM APPOINTMENT
    WHERE mcdp_cd = 'CS' AND DATE_FORMAT(apnt_ymd, "%Y-%m-%d") = '2022-04-13' AND apnt_cncl_yn = 'N'
)

SELECT APNT_NO, PT_NAME, p.PT_NO, a.MCDP_CD, DR_NAME, APNT_YMD
FROM cte as a
    JOIN doctor as d ON a.mddr_id = d.dr_id
    JOIN patient as p ON a.pt_no = p.pt_no
ORDER BY 6
