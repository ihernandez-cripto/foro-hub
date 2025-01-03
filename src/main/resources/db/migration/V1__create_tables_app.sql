CREATE TABLE usuario (
  id 			     bigint 		NOT NULL auto_increment PRIMARY KEY,
  nombre 		     VARCHAR(45) 	NOT NULL,
  correo_electronico VARCHAR(45) 	NOT NULL UNIQUE,
  contrasena 		 VARCHAR(45) 	NOT NULL
);

CREATE TABLE perfil (
  id 			bigint 		    NOT NULL auto_increment PRIMARY KEY,
  nombre 		VARCHAR(45) 	NOT NULL
);

CREATE TABLE perfil_has_usuario (
  usuario_id    bigint 		    NOT NULL,
  perfil_id 	bigint 		    NOT NULL,

  FOREIGN KEY   (usuario_id)    REFERENCES usuario(id),
  FOREIGN KEY   (perfil_id)     REFERENCES perfil(id)
);

CREATE TABLE curso (
  id 			bigint 		    NOT NULL auto_increment PRIMARY KEY,
  nombre 		VARCHAR(45) 	NOT NULL,
  categoria 	VARCHAR(45) 	NOT NULL
);

CREATE TABLE topico (
  id 			    bigint 		    not null auto_increment PRIMARY KEY,
  titulo 		    VARCHAR(100) 	NOT NULL UNIQUE,
  mensaje 		    VARCHAR(250) 	NOT NULL UNIQUE,
  fecha_creacion    TIMESTAMP	    NOT NULL,
  status 		    VARCHAR(10) 	NOT NULL,
  usuario_id	 	bigint 		    NOT NULL,
  curso_id 		    bigint 		    NOT NULL,

  FOREIGN KEY   (usuario_id)    REFERENCES usuario(id),
  FOREIGN KEY   (curso_id)      REFERENCES curso(id)
);

CREATE TABLE respuesta (
  id 			    bigint 		    NOT NULL auto_increment PRIMARY KEY,
  mensaje 		    VARCHAR(100) 	NOT NULL,
  fecha_creacion 	TIMESTAMP	    NOT NULL,
  solucion 		    VARCHAR(200) 	NOT NULL,
  usuario_id 		bigint 		    NOT NULL,
  topico_id 		bigint 		    NOT NULL,

  FOREIGN KEY (usuario_id)  REFERENCES usuario(id),
  FOREIGN KEY (topico_id)   REFERENCES topico(id)
);

