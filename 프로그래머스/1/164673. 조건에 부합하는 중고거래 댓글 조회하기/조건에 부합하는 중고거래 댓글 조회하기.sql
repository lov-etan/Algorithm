SELECT b.title, b.board_id , r.reply_id, r.writer_id, r.contents, date_format(r.created_date, "%Y-%m-%d") as created_date
FROM used_goods_board as b
JOIN used_goods_reply as r ON b.board_id = r.board_id
WHERE substr(b.created_date, 1, 7) = '2022-10'
ORDER BY r.created_date, b.title
