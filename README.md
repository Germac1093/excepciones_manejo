Entre a la raiz 
`docker compose up` tiene que tener isntalada docker y docker compose.

luego para el ingresar contenedor y verificar la persistencia de datos en una terminal
`docker exec -it postgres_db psql -U usuario -d db_spring`

ya en el prompt 
`\d+` para confirmar la existencia de la tabla

`select * from produts` para verificar que no tiene registros

vaya a cualquier navegador y ingrese `http://localhost:8080/api/import/products` esto iniciara el proceso y transferira los datos

luego en la terminal verifique la presencia de los datos
