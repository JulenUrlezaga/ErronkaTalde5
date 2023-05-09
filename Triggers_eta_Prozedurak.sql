Delimiter $$
DROP TRIGGER IF EXISTS Delete_bezero $$
CREATE TRIGGER Delete_bezero
before DELETE
ON bezeroa FOR EACH ROW
BEGIN
INSERT into Bezero_historikoak
VALUES(old.nan,old.izena,old.abizenak,old.telefono,old.email,old.ordainketa_metodoa);
end $$

Delimiter $$
DROP TRIGGER IF EXISTS Update_bezero $$
CREATE TRIGGER Update_bezero
BEFORE UPDATE
ON bezeroa for EACH ROW
BEGIN
INSERT INTO Bezero_historikoak
VALUES (old.nan, old.izena, old.abizenak, old.telefono, old.email, old.ordainketa_metodoa);
end $$

delimiter $$
drop PROCEDURE IF EXISTS lista_bezero $$
CREATE PROCEDURE lista_bezero ( in vnombre VARCHAR(50))
begin
SELECT DISTINCT *
FROM bezeroa b, Erreserba_O eo, ostatua o
WHERE b.nan=eo.NAN
and eo.ID_ostatua=o.ID_ostatua
AND vnombre=b.izena

 ;

end $$