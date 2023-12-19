create table if not exists customer
(
    id_client serial primary key,
    nick_name varchar(15) not null unique,
    card_id  text  not null
)