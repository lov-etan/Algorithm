# 부서별 평균 연봉
SELECT e.dept_id, d.dept_name_en, ROUND(AVG(SAL),0) as avg_sal
FROM hr_department as d
    JOIN hr_employees as e
    ON d.dept_id = e.dept_id
GROUP BY 1
ORDER BY 3 DESC