-- 코드를 입력하세요
SELECT ins.name, ins.datetime
FROM animal_ins as ins # 입양간 기록 위주 
    LEFT JOIN animal_outs as outs ON ins.animal_id = outs.animal_id
-- WHERE ins.animal_id = (SELECT animal_id FROM animal_ins ORDER BY datetime asc LIMIT 3)
WHERE outs.datetime is null
ORDER BY ins.datetime asc
LIMIT 3