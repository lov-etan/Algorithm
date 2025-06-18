SELECT t.item_id, i.item_name, i.rarity
FROM item_tree as t
    JOIN item_info as i ON t.item_id = i.item_id
WHERE t.parent_item_id
    IN (SELECT item_id
        FROM item_info
        WHERE rarity = 'RARE')
ORDER BY t.item_id DESC