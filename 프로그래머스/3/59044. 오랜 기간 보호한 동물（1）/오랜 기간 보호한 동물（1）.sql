# 아직 입양 못 간 동물 - outs엔 없는 애들 is null
# 가장 오래된 친구 3마리
SELECT ins.name, ins.datetime
FROM animal_ins as ins
    LEFT JOIN animal_outs as outs
    ON ins.animal_id = outs.animal_id
WHERE outs.animal_id IS NULL
ORDER BY ins.datetime
LIMIT 3