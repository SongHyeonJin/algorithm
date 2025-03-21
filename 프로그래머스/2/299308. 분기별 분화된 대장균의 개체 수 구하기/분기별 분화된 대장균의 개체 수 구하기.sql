SELECT CASE 
         WHEN MONTH(DIFFERENTIATION_DATE) <= 3 THEN CONCAT(1, 'Q')
         WHEN MONTH(DIFFERENTIATION_DATE) <= 6 THEN CONCAT(2, 'Q')
         WHEN MONTH(DIFFERENTIATION_DATE) <= 9 THEN CONCAT(3, 'Q')
         WHEN MONTH(DIFFERENTIATION_DATE) <= 12 THEN CONCAT(4, 'Q')
       END AS QUARTER, COUNT(*) AS ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY QUARTER
ORDER BY QUARTER ASC;