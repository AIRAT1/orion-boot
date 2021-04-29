create table if not exists address_mtm
(
    id     varchar(36)  not null
        primary key,
    city   varchar(255) null,
    street varchar(255) null
);

create table if not exists billing_details
(
    id        varchar(36) not null
        primary key,
    person_id varchar(36) null,
    constraint fk_billing_details_users
        foreign key (person_id) references users (id)
);

create table if not exists bank_account
(
    account         varchar(255) null,
    bank_account_id varchar(36)  not null
        primary key,
    constraint fk_bank_account_billing_details
        foreign key (bank_account_id) references billing_details (id)
);

create table if not exists credit_card
(
    card_number    varchar(255) null,
    credit_card_id varchar(36)  not null
        primary key,
    constraint fk_credit_card_billing_details
        foreign key (credit_card_id) references billing_details (id)
);

create table if not exists person_address_mtm
(
    address_id varchar(36) not null,
    user_id    varchar(36) not null,
    primary key (address_id, user_id),
    constraint fk_person_address_mtm_address_mtm
        foreign key (address_id) references address_mtm (id),
    constraint fk_person_address_users1
        foreign key (user_id) references users (id)
);