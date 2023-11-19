SELECT AA.HISTORY_ID
     , (DAILY_FEE - (DAILY_FEE * (NVL(DISCOUNT_RATE, 0) * 0.01))) * DURATION AS FEE
FROM (
         SELECT HISTORY_ID
              , A.DAILY_FEE
              , A.CAR_TYPE
              , END_DATE - START_DATE + 1 AS DURATION
              , CASE WHEN END_DATE - START_DATE >= 90
                         THEN '90일 이상'
                     WHEN END_DATE - START_DATE >= 30
                         THEN '30일 이상'
                     WHEN END_DATE - START_DATE >= 7
                         THEN '7일 이상'
                     ELSE '7일 미만'
             end AS DURATION_TYPE
         FROM CAR_RENTAL_COMPANY_CAR A
            , CAR_RENTAL_COMPANY_RENTAL_HISTORY B
         WHERE A.CAR_TYPE = '트럭'
           AND A.CAR_ID = B.CAR_ID
     ) AA
         LEFT OUTER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
                         ON AA.DURATION_TYPE = C.DURATION_TYPE
                             AND C.CAR_TYPE = AA.CAR_TYPE
ORDER BY FEE DESC, HISTORY_ID DESC;