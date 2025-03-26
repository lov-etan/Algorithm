-- 코드를 입력하세요
SELECT board.title, board.board_id, reply.reply_id, reply.writer_id, reply.contents, date_format(reply.created_date, "%Y-%m-%d") as created_date
FROM USED_GOODS_BOARD as board 
                        JOIN USED_GOODS_REPLY as reply ON board.board_id = reply.board_id
WHERE Year(board.created_date) = 2022 AND Month(board.created_date) = 10
ORDER BY reply.created_date ASC, board.title ASC;