create table wallet
(
    id        serial primary key,
    full_name varchar(100),
    cpf       varchar(11),
    cnpj      varchar(14),
    email     varchar(64),
    password  varchar(64),
    balance   numeric(11, 2) default 0
);

create table transaction
(
    id              serial primary key,
    payer_wallet_id integer        not null,
    payee_wallet_id integer        not null,
    amount          numeric(11, 2) not null,
    created_at      timestamp      not null,
    foreign key (payer_wallet_id) references wallet,
    foreign key (payee_wallet_id) references wallet
);

insert into wallet(full_name, cpf, email, password, balance)
values ('Usuario 1', '88006866058', 'usuario1@mail.com.br', '123456', 1200.0);

insert into wallet(full_name, cpf, email, password)
values ('Usuario 2', '18034393002', 'usuario2@mail.com.br', '123456');

insert into wallet(full_name, cnpj, email, password, balance)
values ('Lojista 1', '15389011000182', 'lojista1@mail.com.br', '654321', 5000.0);

insert into wallet(full_name, cnpj, email, password)
values ('Lojista 2', '87810728000167', 'lojista2@mail.com.br', '654321');