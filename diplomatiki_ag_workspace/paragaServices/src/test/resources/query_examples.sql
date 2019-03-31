 select * from 
  sxoleio a 
  inner join taxi b on a.id = b.ID_SXOLEIO
  
  
   SELECT * FROM SXOLEIO
  SELECT * FROM Taxi
  SELECT * FROM MATHITES
  SELECT * FROM TAXI_MATHITIS

  insert TAXI_MATHITIS
  (ID_TAXI,ID_MATHITIS)
  values(18,1002)

  select * FROM Taxi a
  inner join TAXI_MATHITIS b on a.id = b.ID_TAXI
  inner join MATHITES c on c.id=b.ID_MATHITIS