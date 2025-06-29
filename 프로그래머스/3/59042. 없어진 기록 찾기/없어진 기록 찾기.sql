# 보호소 들어온 기록 X + 입양 간 기록 O
SELECT outs.animal_id, outs.name
FROM animal_ins as ins
    RIGHT JOIN animal_outs as outs 
    ON ins.animal_id = outs.animal_id
WHERE ins.animal_id IS NULL
ORDER BY 1,2