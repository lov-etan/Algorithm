-- 취소되지 않은 진정한 진료예약내역 <- 2022년 4월 13일 
 SELECT a.apnt_no, p.pt_name, p.pt_no, d.mcdp_cd, d.dr_name, a.apnt_ymd
 FROM patient as p 
     JOIN appointment as a ON p.pt_no = a.pt_no
     JOIN doctor as d ON d.dr_id = a.mddr_id
 WHERE a.apnt_no in (
     select apnt_no 
    from appointment
    where apnt_cncl_yn = 'N' AND mcdp_cd = 'CS'
    AND date(apnt_ymd) = '2022-04-13'
    ) 
ORDER BY apnt_ymd asc;

    