# 가장 조회수가 높은 게시물?
# 그 게시물의 첨부파일 경로!
 WITH 
 cte AS (
    SELECT MAX(views) as max_view
    FROM USED_GOODS_BOARD
 ), 
 cte2 AS (
    SELECT board_id
    FROM USED_GOODS_BOARD
    WHERE views = (SELECT max_view FROM cte)
 )

SELECT concat('/home/grep/src/', board_id, '/', file_id, file_name, file_ext) as file_path
FROM USED_GOODS_FILE as f
WHERE board_id = (SELECT board_id FROM cte2)
ORDER BY file_id DESC