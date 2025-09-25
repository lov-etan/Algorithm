# 완료된 중고 거래 총금액 70만원 이상인 사람 조회
WITH cte AS (
    SELECT writer_id, SUM(price) as total_sales
    FROM USED_GOODS_BOARD
    WHERE status = 'DONE'
    GROUP BY 1
    HAVING SUM(price) >= 700000
)

SELECT u.user_id, u.nickname, c.total_sales
FROM USED_GOODS_USER as u
    JOIN cte as c ON u.user_id = c.writer_id
ORDER BY 3 
