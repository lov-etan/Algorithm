# 3세대를 찾아라
# 풀이 1
# SELECT ID
# FROM ECOLI_DATA
# WHERE PARENT_ID IN (SELECT ID
#                     FROM ECOLI_DATA
#                     WHERE PARENT_ID IN (SELECT ID
#                                         FROM ECOLI_DATA
#                                         WHERE PARENT_ID IS NULL))
# ORDER BY 1

# 풀이2
WITH RECURSIVE cte AS (
    SELECT  ID, PARENT_ID, 
            1 as DEPTH
    FROM    ECOLI_DATA
    WHERE   parent_id IS NULL
    
    UNION ALL
    
    SELECT  e.ID, e.PARENT_ID, c.depth +1
    FROM    ECOLI_DATA as e JOIN cte as c ON e.PARENT_ID = c.ID
    WHERE   depth < 3
)

SELECT ID
FROM CTE
WHERE DEPTH = 3
ORDER BY 1