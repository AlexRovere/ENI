select CONVERT(float, ROUND((100.0/3), 2))

select DATEADD(day , 30 , GETDATE())

DECLARE @string AS VARCHAR(100)='SQL SERVER - SQL'
DECLARE @stringToFind AS VARCHAR(100)='SERVER'

select SUBSTRING(@string, CHARINDEX(@stringToFind,  @string), len(@stringToFind))