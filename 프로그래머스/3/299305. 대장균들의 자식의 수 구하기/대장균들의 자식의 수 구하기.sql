-- 본인의 자식수는?
SELECT a.id, count(b.id) as child_count
FROM ecoli_data as a
    LEFT JOIN ecoli_data as b 
    ON a.id = b.parent_id
GROUP BY a.id -- 부모 기준으로 그룹 묶고 자식 count
ORDER BY a.id