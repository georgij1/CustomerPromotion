create table if not exists customer
(
    id_client serial primary key,
    nick_name text not null unique,
    card_id  text  not null
)