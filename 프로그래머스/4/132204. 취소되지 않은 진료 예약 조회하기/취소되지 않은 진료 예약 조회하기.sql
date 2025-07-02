-- 2022-04-13 취소되지 않은 'CS' 진료 예약 내약

SELECT a.apnt_no, p.pt_name, p.pt_no, d.mcdp_cd, d.dr_name, a.apnt_ymd
FROM appointment as a
    LEFT JOIN patient as p ON a.pt_no = p.pt_no
    LEFT JOIN doctor as d ON a.mddr_id = d.dr_id
WHERE DATE_FORMAT(a.apnt_ymd, "%Y-%m-%d") = '2022-04-13' 
    AND a.apnt_cncl_yn = 'N'
    AND d.mcdp_cd = 'CS'
ORDER BY 6 