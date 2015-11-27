insert into Cuenta (numeroDeCuenta,descripcion) values (('4000','cuenta 1'),('5000','cuenta 2'));
INSERT INTO asientos (id,descripcion) VALUES ((1,'prueba1'),(2,'prueba2')); 
insert into lineasAsiento (id,cuenta,importe,tipoMovimientoContable,asientoId) values (( 1,'4000',1000,'H',1),( 2,'5000',1000,'D',1));

