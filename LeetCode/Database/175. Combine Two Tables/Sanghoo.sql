-- https://leetcode.com/problems/combine-two-tables/
-- 1번
   SELECT FIRSTNAME
        , LASTNAME
        , CITY
        , STATE
     FROM PERSON P
LEFT JOIN ADDRESS A
       ON (P.PERSONID = A.PERSONID);

-- 2번
SELECT FIRSTNAME
     , LASTNAME
     , CITY
     , STATE
  FROM PERSON P
     , ADDRESS A
 WHERE P.PERSONID = A.PERSONID(+);
