SELECT i.animal_id, i.name
FROM ANIMAL_INS as i
    JOIN ANIMAL_OUTS as o
    ON i.animal_id = o.animal_id
WHERE i.datetime > o.datetime
ORDER BY i.datetime