drop table if exists beer;
drop table if exists customer;

  create table beer (
    id varchar(36) not null,
     beer_name varchar(50) not null,
     beer_style smallint not null,
     created_date timestamp(6),
     price numeric(38,2) not null,
     quantity_on_hand integer,
     upc varchar(255) not null,
     update_date timestamp(6),
     version integer,
     primary key (id)
  ) engine=InnoDB;


  create table customer (
    id varchar not null,
     created_date timestamp(6),
     name varchar(255),
     update_date timestamp(6),
     version integer,
     primary key (id)
  ) engine=InnoDB;
