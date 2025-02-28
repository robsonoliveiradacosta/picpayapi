create table wallets
(
    id        serial primary key,
    full_name varchar(100),
    cpf       varchar(11),
    cnpj      varchar(14),
    email     varchar(64),
    password  varchar(64)
);

insert into wallets(full_name, cpf, email, password)
values ('Francisco Amancio', '18034393002', 'amancio@mail.com.br', '123456');

insert into wallets(full_name, cnpj, email, password)
values ('Lojista 1', '15389011000182', 'lojista1@mail.com.br', '654321');