# 몇 시에 입양 가장 활발?
# 0-23시까지 
# 각 시간대별로 입양이 몇 건이나 발생?

WITH RECURSIVE cte (h) AS 
(
    SELECT 0
    UNION ALL   
    SELECT h+1 FROM cte WHERE h < 23
)

# SELECT * FROM cte 

SELECT c.h as HOUR, count(a.animal_id) as count
FROM ANIMAL_OUTS as a
    RIGHT JOIN CTE as c 
    ON hour(a.datetime) = c.h
GROUP BY 1
ORDER BY 1