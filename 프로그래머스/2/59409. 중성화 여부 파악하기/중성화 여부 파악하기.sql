# Neutered 또는 Spayed 가 포함되면 중성화 O
SELECT  ANIMAL_ID, NAME, 
        (
            CASE 
            WHEN SEX_UPON_INTAKE LIKE '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
            ELSE 'X'
            END
        ) as '중성화'
FROM ANIMAL_INS
ORDER BY 1