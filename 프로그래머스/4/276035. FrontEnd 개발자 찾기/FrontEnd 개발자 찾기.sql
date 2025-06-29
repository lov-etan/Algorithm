SELECT DISTINCT d.id, d.email, d.first_name, d.last_name
FROM developers as d
JOIN (SELECT * FROM skillcodes WHERE category = 'Front End') as s
ON d.skill_code & s.code
ORDER BY 1