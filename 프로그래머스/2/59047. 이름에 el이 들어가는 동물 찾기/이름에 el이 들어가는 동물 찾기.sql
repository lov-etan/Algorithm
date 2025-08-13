# El 이 포함된 이름 찾기
SELECT animal_id, name
FROM ANIMAL_INS
WHERE name LIKE '%el%' AND animal_type = 'Dog'
ORDER BY 2