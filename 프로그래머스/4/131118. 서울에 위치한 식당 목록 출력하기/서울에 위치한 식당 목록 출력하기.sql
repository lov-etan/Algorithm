-- 서울에 위치 
SELECT info.rest_id, info.rest_name, 
    info.food_type, info.favorites, info.address, ROUND(AVG(rev.review_score),2) as score
FROM rest_info as info
    JOIN rest_review as rev
    ON info.rest_id = rev.rest_id
GROUP BY 1
HAVING info.address LIKE '서울%'
ORDER BY 6 DESC, 4 DESC
