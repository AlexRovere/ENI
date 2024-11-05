

DECLARE @Counter INT 
SET @Counter=1
WHILE ( @Counter <= 100)
BEGIN
INSERT INTO clients VALUES (@counter, 'BOB', 'MARLEY', GETDATE() - 10000, 'toulon', 0364894479,489498494)
    SET @Counter  = @Counter  + 1
END

select * from clients

DELETE clients WHERE date_naissance IS NOT NULL

select year(date_naissance)

DELETE clients WHERE year(GETDATE()) - year(date_naissance) < 16
