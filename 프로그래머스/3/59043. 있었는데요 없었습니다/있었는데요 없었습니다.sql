-- 코드를 입력하세요
SELECT ins.animal_id, outs.name
FROM animal_ins as ins 
    JOIN animal_outs as outs ON ins.animal_id = outs.animal_id
WHERE ins.datetime  > outs.datetime
ORDER BY ins.datetime ASC;