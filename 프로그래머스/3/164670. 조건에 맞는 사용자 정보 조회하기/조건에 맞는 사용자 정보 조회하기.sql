# 중고 거래 게시물 3건 이상 등록
WITH cte AS (
    SELECT writer_id
    FROM used_goods_board
    GROUP BY 1
    HAVING COUNT(board_id) >= 3
)

SELECT u.user_id, nickname, concat(city, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) as '전체주소', concat(LEFT(tlno, 3), '-', SUBSTR(tlno, 4, 4), '-', RIGHT(tlno, 4)) as '전화번호'
FROM USED_GOODS_USER as u
    JOIN cte as c
    ON u.USER_ID = c.writer_id
ORDER BY 1 DESC