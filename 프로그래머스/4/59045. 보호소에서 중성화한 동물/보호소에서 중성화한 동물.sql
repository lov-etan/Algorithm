-- 코드를 입력하세요
SELECT i.animal_id, i.animal_type, i.name
FROM ANIMAL_INS as i
    JOIN ANIMAL_OUTS as o
    ON i.animal_id = o.animal_id
WHERE i.SEX_UPON_INTAKE LIKE 'Intact%' 
    AND (o.SEX_UPON_OUTCOME LIKE 'Spayed%' OR o.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY 1