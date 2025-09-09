-- out에는 있는데 in에는 없는 애들 찾아라!
SELECT o.animal_id, o.name
FROM ANIMAL_INS as i
    RIGHT JOIN ANIMAL_OUTS as o
    ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.ANIMAL_ID IS NULL
ORDER BY 1,2