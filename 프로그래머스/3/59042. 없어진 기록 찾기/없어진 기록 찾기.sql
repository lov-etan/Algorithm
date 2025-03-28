-- 입양 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물
SELECT outs.animal_id, outs.name
FROM animal_outs as outs
LEFT JOIN animal_ins as ins ON ins.animal_id = outs.animal_id
WHERE ins.animal_id is null
ORDER BY animal_id

