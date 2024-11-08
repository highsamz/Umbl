CREATE SEQUENCE SEQ_PONTO_COLETA
    START WITH 1
    INCREMENT BY 1 NOCACHE
    NOCYCLE;

CREATE TABLE TB_PONTO_COLETA
(
    id integer default SEQ_PONTO_COLETA.nextval not null,
    capacidade varchar(20) not null,
    nome varchar(100) not null,
    material_aceito varchar(20) not null,
    email varchar(100) not null,
    telefone varchar(20) not null,

    logradouro varchar(100) not null,
    cep varchar(9) not null,
    numero varchar(20),
    cidade varchar(100) not null,
    bairro varchar(100) not null,
    estado char(20) not null,
    primary key(id)
);