-- 조회수가 가장 높은 중고거래 게시물(1)의 첨부파일 경로
SELECT concat("/home/grep/src/",f.board_id, "/", f.file_id, f.file_name, f.file_ext ) as file_path
FROM used_goods_file as f
WHERE f.board_id = 
    (SELECT board_id FROM used_goods_board ORDER BY views desc LIMIT 1)
ORDER BY file_id desc;