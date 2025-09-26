# 조회수 가장 높은 게시물? 
# 에 대한 첨부파일 경로!
WITH cte AS (
    SELECT board_id
    FROM USED_GOODS_BOARD
    ORDER BY VIEWS DESC
    LIMIT 1
)

# 기본적인 파일경로는 /home/grep/src/ 이며, 게시글 ID를 기준으로 디렉토리가 구분되고, 파일이름은 파일 ID, 파일 이름, 파일 확장자로 구성되도록 출력
SELECT CONCAT('/home/grep/src/', c.board_id, '/', file_id, file_name, file_ext) as file_path
FROM USED_GOODS_FILE as f
    JOIN cte as c ON f.board_id = c.board_id
ORDER BY file_id DESC