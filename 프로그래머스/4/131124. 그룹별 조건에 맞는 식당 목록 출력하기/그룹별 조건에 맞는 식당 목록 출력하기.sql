# 리뷰 가장 많이 작성한 회원 
WITH cte AS (
    SELECT member_id
    FROM rest_review
    GROUP BY 1
    ORDER BY COUNT(review_id) DESC
    LIMIT 1
)

SELECT p.member_name, r.review_text, date_format(r.review_date, "%Y-%m-%d") as review_date
FROM MEMBER_PROFILE as p
    JOIN cte as c ON p.member_id = c.member_id
    JOIN REST_REVIEW as r ON c.member_id = r.member_id
ORDER BY r.review_date, r.review_text