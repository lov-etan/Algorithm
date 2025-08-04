# 기준점수 = 평균점수
WITH avg_cte AS (
    SELECT emp_no, AVG(score) as avg_score
    FROM HR_GRADE
    GROUP BY 1
)

SELECT  a.emp_no, e.emp_name,
        (
            CASE
            WHEN a.avg_score >= 96 THEN 'S'
            WHEN a.avg_score >= 90 THEN 'A'
            WHEN a.avg_score >= 80 THEN 'B'
            ELSE 'C'
            END
        ) as GRADE,
        (
            CASE
            WHEN a.avg_score >= 96 THEN e.sal*20/100
            WHEN a.avg_score >= 90 THEN e.sal*15/100
            WHEN a.avg_score >= 80 THEN e.sal*10/100
            ELSE e.sal*0/100
            END
        ) as BONUS
FROM avg_cte as a 
    JOIN  HR_EMPLOYEES as e ON a.emp_no = e.emp_no
ORDER BY 1