-- 코드를 입력하세요
SELECT animal_id, name, 
    (CASE
     WHEN sex_upon_intake LIKE 'Neutered%' OR sex_upon_intake LIKE 'Spayed%' THEN 'O'
     ELSE 'X'
     END
    ) as 중성화
FROM animal_ins as ins