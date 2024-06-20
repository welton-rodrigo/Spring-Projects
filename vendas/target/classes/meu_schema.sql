create table cliente (
    id integer primary key auto_increment,
    nome varchar(100)
);

create table produto (
    id integer primary key auto_increment,
    descricao varchar(100),
    preco_unitario numeric (20,2)
);

create table pedido (
    id integer primary key auto_increment,
    cliente_id integer references cliente (id),
    data_pedido timestamp,
    total numeric (20,2),
    produto_id integer references produto (id)
);

CREATE TABLE ITEM_PEDIDO (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    PEDIDO_ID INTEGER REFERENCES PEDIDO (ID),
    PRODUTO_ID INTEGER REFERENCES PRODUTO (ID),
    QUANTIDADE INTEGER
);
