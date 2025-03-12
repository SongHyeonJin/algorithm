SELECT SUM(B.SCORE) AS SCORE, B.EMP_NO, A.EMP_NAME, A.POSITION, A.EMAIL
FROM HR_EMPLOYEES A
JOIN HR_GRADE B
ON A.EMP_NO = B.EMP_NO
GROUP BY B.EMP_NO, A.EMP_NAME, A.POSITION, A.EMAIL
ORDER BY SCORE DESC
LIMIT 1;