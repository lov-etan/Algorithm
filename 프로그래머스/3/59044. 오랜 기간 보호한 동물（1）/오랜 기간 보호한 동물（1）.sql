-- 아직 입양 못 간 동물 중
-- 가장 오래 보호소에 있었던 동물 3마리~!
SELECT i.name, i.datetime
FROM ANIMAL_INS as i
    LEFT JOIN ANIMAL_OUTS as o
    ON i.animal_id = o.animal_id
WHERE o.animal_id IS NULL
ORDER BY i.datetime
LIMIT 3