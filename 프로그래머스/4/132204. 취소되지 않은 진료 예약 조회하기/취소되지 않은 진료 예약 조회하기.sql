-- 2022년4월13일 취소되지 않은 CS 진료 예약 내역
WITH apnt AS (
    SELECT *
    FROM appointment 
    WHERE apnt_cncl_yn = 'N' && apnt_ymd LIKE '2022-04-13%'
)

SELECT a.apnt_no, p.pt_name, p.pt_no, d.mcdp_cd, d.dr_name, a.apnt_ymd
FROM apnt as a
LEFT JOIN patient as p
ON a.pt_no = p.pt_no
LEFT JOIN doctor as d
ON a.mddr_id = d.dr_id
WHERE d.mcdp_cd = 'CS'
ORDER BY 6
