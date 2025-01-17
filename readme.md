# Proyecto Forohub

* _Descripción del proyecto_
Este proyecto simula un foro donde un usuario logeado, con un token valido en la aplicación puede realizar la creación de nuevos topicos y dar respuesta a los topicos abiertos por otros usuarios.
## Modelo E/R base de datos forohub
![db_model](https://github.com/user-attachments/assets/f3d9de63-5e54-4a33-95d2-ac7178e62808)

## Logeando un usuario
### El usuario debe estar creado en la base de datos inicialmente, la aplicación es instalada con:
* usuario: admin
* contraseña: Admin2025$

Login del usuario admin
![11 login_admin](https://github.com/user-attachments/assets/0e593c91-8cc9-420f-9793-0cf8e221ca3f)

### La variable de ambiente de la aplicación "Insomnia", debe actualizarse con el token generado
![8 editar_variable_login ](https://github.com/user-attachments/assets/495850e6-76cb-42d3-8281-8a1a19d23f89)

### Los topicos deben estar relacionados con un curso, por esta razón también la aplicación es instalada con: 
* curso: curso basico
* categoria: educacion general

### Con el usuario admin logeado, podrá registrar otros usuarios y con los nuevos usuarios puede realizar:

## Registrar topico

![01 registro_topico](https://github.com/user-attachments/assets/e1c969ac-9fcd-4a77-a03c-c095fb0f0341)

## Listar topico

![02 listar_topico](https://github.com/user-attachments/assets/d57904a0-8c21-4d69-bc53-2cc814776ae8)

## Listar topico especifico

![03 listar_topico_id](https://github.com/user-attachments/assets/9309b029-f4fb-4a74-a69e-61e2f0ef8293)

## Modificar un topico

![04 modificar_topico_id](https://github.com/user-attachments/assets/00d6d403-8baf-4c0b-b1c0-ccd4b66599d1)

## Borrar un topico

![05 borrar_topico_id](https://github.com/user-attachments/assets/19e81a4d-2e3e-4810-ba8a-dbad826f9407)

## Validaciones a tener en cuenta

Validación de los datos de usuario, el login del usuario es el correo electrónico

![06 validar_login](https://github.com/user-attachments/assets/3cf16f67-0e59-404e-9899-b5e5e701df58)

La contraseña del usuario debe cumplir unos requisitos

![12 valida_contrasena](https://github.com/user-attachments/assets/50dbcd10-1eb2-4f53-b54f-6e5198425ae8)



