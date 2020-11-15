CREATE TABLE userAccount
(
    id         bigint primary key not null,
    first_name varchar(255)       not null,
    last_name  varchar(255)       not null,
    hash_password   varchar(255)       not null,
    email      varchar(255)       not null,
    created_at date               not null,
    role       varchar(255)       not null
);
ALTER TABLE userAccount OWNER TO postgres;

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE userAccount OWNER TO postgres;
ALTER SEQUENCE user_id_seq OWNED BY userAccount.id;

CREATE TABLE public.trader (
 abstract_user_id bigint NOT NULL
);

insert into userAccount(id, first_name, last_name, hash_password, email, created_at, role)
VALUES (1,'Maks', 'Titok', 'admin', 'admin', '15-11-2020','ROLE_ADMIN');

select email, hash_password
from userAccount