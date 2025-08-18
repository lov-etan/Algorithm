-- 자식이 없는 개체 수와 세대!
WITH RECURSIVE tree AS (
    SELECT  ID, PARENT_ID, 
            1 as GENERATION
    FROM    ECOLI_DATA
    WHERE   PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT  e.ID, e.PARENT_ID, t.generation+1
    FROM    ECOLI_DATA as e JOIN tree as t ON e.parent_id = t.id
)

SELECT count(distinct t.ID) as count, t.generation
FROM tree as t
LEFT JOIN ECOLI_DATA as child ON child.parent_id = t.id
WHERE child.id IS NULL 
GROUP BY 2
ORDER BY 2