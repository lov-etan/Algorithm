# 리프 노드가 궁금해
# <- child가 없어야 함
WITH cte AS (
    SELECT tree.item_id as id, child.item_id as child_id
    FROM ITEM_TREE as child
        RIGHT JOIN ITEM_TREE as tree
        ON child.parent_item_id = tree.item_id
    WHERE child.item_id IS NULL
)

SELECT item_id, item_name, rarity
FROM ITEM_INFO
WHERE item_id IN (SELECT id FROM cte)
ORDER BY 1 DESC