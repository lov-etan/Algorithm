SELECT CONCAT('/home/grep/src/', f.board_id, '/', f.file_id, f.file_name ,f.file_ext) as file_path
FROM used_goods_board as b
    JOIN used_goods_file as f
    ON b.board_id = f.board_id
WHERE b.board_id = (SELECT board_id FROM used_goods_board ORDER BY views DESC LIMIT 1)
ORDER BY f.file_id DESC