-- 코드를 작성해주세요
SELECT it.item_id, ii.item_name, ii.rarity

FROM item_info as ii 
    JOIN item_tree as it ON ii.item_id = it.item_id
    
WHERE it.parent_item_id IN (select item_id from item_info where rarity = 'RARE')
ORDER BY item_id DESC;