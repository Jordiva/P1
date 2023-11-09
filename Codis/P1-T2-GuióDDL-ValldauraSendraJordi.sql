Drop table TIPUS CASCADE CONSTRAINTS;
Drop table USUARI CASCADE CONSTRAINTS;
Drop table RUTA CASCADE CONSTRAINTS; 
Drop table PUNT CASCADE CONSTRAINTS;
Drop table COMENTARI CASCADE CONSTRAINTS;
Drop table FETES CASCADE CONSTRAINTS;
Drop table COMPANYS CASCADE CONSTRAINTS;


CREATE TABLE TIPUS (
    id_tipus number(10) GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_TIPUS_ID PRIMARY KEY ,
    nom VARCHAR2(50) NOT NULL,
    icona BLOB
);

CREATE TABLE USUARI (
    login VARCHAR2(50) CONSTRAINT PK_USUARI_LOGIN PRIMARY KEY,
    email VARCHAR2(50) CONSTRAINT UN_USUARI_EMAIL UNIQUE NOT NULL CHECK (email like '%@%'),
    nom VARCHAR2(50) NOT NULL,
    cognom VARCHAR2(50) NOT NULL,
    contrasenya VARCHAR2(50) NOT NULL,
    foto BLOB
);

CREATE TABLE RUTA (
    id_ruta NUMBER(10) GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_RUTA_ID PRIMARY KEY ,
    usu_login VARCHAR2(50) CONSTRAINT FK_RUTA_USUARI REFERENCES USUARI(login),
    titol VARCHAR2(50) NOT NULL,
    descripcio VARCHAR2(50) NOT NULL,
    text CLOB NOT NULL,
    distancia NUMBER(10) NOT NULL,
    temps NUMBER(10) NOT NULL,
    moment_temp TIMESTAMP DEFAULT SYSTIMESTAMP,
    desnivell_positiu NUMBER(10) NOT NULL,
    desnivell_negatiu NUMBER(10) NOT NULL,
    dificultat NUMBER(10) NOT NULL,
    num_persones NUMBER(10) DEFAULT 0,
    suma_valoracions NUMBER(10)DEFAULT 0 ,
    num_persones_fet_ruta NUMBER(10)DEFAULT 0 ,
    suma_valoracion_saguretat NUMBER(10)DEFAULT 0 ,
    suma_valoracio_paisatge NUMBER(10)DEFAULT 0 
);

CREATE TABLE PUNT (
    num_punt NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    id_ruta NUMBER(10) CONSTRAINT FK_PUNT_RUTA REFERENCES RUTA(id_ruta),
    id_tipus NUMBER(10) CONSTRAINT FK_PUNT_TIPUS REFERENCES TIPUS(id_tipus),
    nom VARCHAR2(50) NOT NULL,
    descripcio VARCHAR2(50) NOT NULL,
    foto BLOB,
    latitud NUMBER(10,6) NOT NULL CHECK (latitud >= -90 AND latitud <= 90),
    longitud NUMBER(10,6) NOT NULL CHECK (longitud >= -180 AND longitud <= 180),
    altitud NUMBER(10,6) 
);

CREATE TABLE COMENTARI (
    id_comentari NUMBER(10) GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_COMENTARI_ID PRIMARY KEY ,
    usu_login VARCHAR2(50) CONSTRAINT FK_COMENTARI_USUARI REFERENCES USUARI(login),
    id_ruta NUMBER(10) CONSTRAINT FK_COMENTARI_RUTA REFERENCES RUTA(id_ruta),
    text CLOB NOT NULL,
    valoracio_informacio NUMBER(10) NOT NULL,
    feta NUMBER(4) NOT NULL,
    dificultat NUMBER(10) CHECK (dificultat >= 1 AND dificultat <= 5),
    valoracio_paisatge NUMBER(10) CHECK (valoracio_paisatge >= 1 AND valoracio_paisatge <= 5),
    valoracio_seguretat NUMBER(10) CHECK (valoracio_seguretat >= 1 AND valoracio_seguretat <= 5),
    moment_temp TIMESTAMP DEFAULT SYSTIMESTAMP
);

CREATE TABLE FETES (
    usu_login VARCHAR2(50) CONSTRAINT FK_FETES_USUARI REFERENCES USUARI(login),
    id_ruta NUMBER(10) CONSTRAINT FK_FETES_RUTA REFERENCES RUTA(id_ruta),
    moment_temp TIMESTAMP  DEFAULT SYSTIMESTAMP,
    CONSTRAINT PK_FETES_ID PRIMARY KEY (usu_login, moment_temp)
);

CREATE TABLE COMPANYS (
    usu_login VARCHAR2(50) CONSTRAINT FK_COMPANYS_USUARI REFERENCES USUARI(login),
    id_comentar NUMBER(10) CONSTRAINT FK_COMPANYS_COMENTARI REFERENCES COMENTARI(id_comentari),
    CONSTRAINT PK_COMPANYS_ID PRIMARY KEY (usu_login, id_comentar)
);




CREATE OR REPLACE TRIGGER validar_atributos_comentari
BEFORE INSERT OR UPDATE ON COMENTARI
FOR EACH ROW
BEGIN
    IF :NEW.feta = 1 THEN
        IF :NEW.valoracio_seguretat IS NULL OR :NEW.valoracio_paisatge IS NULL OR :NEW.dificultat IS NULL THEN
            RAISE_APPLICATION_ERROR(-20001, 'Los atributos valoracio_seguretat, valoracio_paisatge y dificultat no pueden ser nulos cuando feta es verdadero.');
        END IF;
    END IF;
END;
/



CREATE OR REPLACE TRIGGER control_fetes
BEFORE INSERT or UPDATE ON COMENTARI
FOR EACH ROW
BEGIN
    IF :NEW.feta = 0 THEN
        :NEW.valoracio_seguretat := NULL;
        :NEW.valoracio_paisatge := NULL;
        :NEW.dificultat := NULL;
        
        DELETE FROM COMPANYS WHERE id_comentar = :NEW.id_comentari;
    END IF;
END;
/


CREATE OR REPLACE TRIGGER control_moment_temp
BEFORE INSERT OR UPDATE ON FETES
FOR EACH ROW
BEGIN
    IF :NEW.moment_temp > SYSTIMESTAMP THEN
        RAISE_APPLICATION_ERROR(-20001, 'El campo moment_temp en la tabla FETES no puede estar en el futuro.');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER control_comentari_usuari_ruta
BEFORE INSERT ON COMENTARI
FOR EACH ROW
DECLARE
    ruta_propietario VARCHAR2(50);
BEGIN
    SELECT usu_login INTO ruta_propietario FROM RUTA WHERE id_ruta = :NEW.id_ruta;
    
    IF :NEW.usu_login = ruta_propietario THEN
        RAISE_APPLICATION_ERROR(-20001, 'El usuario que hace el comentario no puede ser el propietario de la ruta.');
    END IF;
END;
/


CREATE OR REPLACE TRIGGER control_comentari_companys 
BEFORE INSERT ON COMPANYS
FOR EACH ROW
DECLARE 
    cursor c_coment is select * from comentari where id_comentari = :NEW.id_comentar;
begin
    for r_coment in c_coment loop
        if r_coment.usu_login = :NEW.usu_login then
            RAISE_APPLICATION_ERROR(-20001, 'El usuario propietario de la ruta no puede ser un compañero de ruta en el comentario.');
        end if;
    end loop;

end;
/



create or replace trigger trig_calcular_columnes BEFORE insert on COMENTARI
for each row
begin
    if :NEW.feta = 1 then
        update ruta set num_persones = num_persones + 1, num_persones_fet_ruta = num_persones_fet_ruta +1 , suma_valoracions = suma_valoracions + :new.valoracio_informacio
        ,suma_valoracion_saguretat = suma_valoracion_saguretat + :new.valoracio_seguretat , suma_valoracio_paisatge = suma_valoracio_paisatge + :new.valoracio_paisatge
        where id_ruta = :new.id_ruta;
    else
        update ruta set num_persones = num_persones + 1 , suma_valoracions = suma_valoracions + :new.valoracio_informacio where id_ruta = :new.id_ruta;
end if;
end;
/
