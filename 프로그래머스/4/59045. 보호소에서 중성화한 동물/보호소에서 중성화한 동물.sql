# INS(중성화x - Intact) OUTS(중성화O - Spayed, Neutered) 인 친구들
SELECT ins.animal_id, ins.animal_type, ins.name
FROM animal_ins as ins
    JOIN animal_outs as outs
    ON ins.animal_id = outs.animal_id
WHERE ins.sex_upon_intake LIKE 'Intact%' 
    AND (outs.sex_upon_outcome LIKE 'Spayed%' OR outs.sex_upon_outcome LIKE 'Neutered%')