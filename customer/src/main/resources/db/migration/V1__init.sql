create table if not exists customer
(
    IdClient serial primary key,
    NickName text not null,
    card_id  text  not null
)