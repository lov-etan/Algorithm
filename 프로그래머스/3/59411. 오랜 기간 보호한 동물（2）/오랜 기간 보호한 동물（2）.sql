# # 보호 기간이 가장 길었던 두 마리
# WITH cte AS (
#     SELECT i.animal_id, i.name, DATEDIFF(o.datetime, i.datetime)+1 as diff
#     FROM ANIMAL_INS as i
#         JOIN ANIMAL_OUTS as o ON i.animal_id = o.animal_id
# )

# SELECT animal_id, name
# FROM cte
# ORDER BY diff DESC
# LIMIT 2

SELECT I.ANIMAL_ID, I.NAME 
FROM ANIMAL_INS I 
JOIN ANIMAL_OUTS O 
ON I.ANIMAL_ID = O.ANIMAL_ID 
ORDER BY DATEDIFF(I.DATETIME, O.DATETIME) 
LIMIT 2