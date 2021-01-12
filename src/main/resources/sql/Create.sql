DROP TABLE IF EXISTS kredit cascade;
DROP TABLE IF EXISTS tip_racuna cascade;
DROP TABLE IF EXISTS klijent cascade;
DROP TABLE IF EXISTS racun cascade;
DROP SEQUENCE IF EXISTS kredit_seq cascade;
DROP SEQUENCE IF EXISTS tip_racuna_seq cascade;
DROP SEQUENCE IF EXISTS klijent_seq cascade;
DROP SEQUENCE IF EXISTS racun_seq cascade;


CREATE TABLE kredit(
	id integer not null,
    naziv varchar(100) not null,
    oznaka varchar(20) not null,
    opis varchar(500) not null
);
alter table kredit add constraint pk_kredit primary key(id);

CREATE TABLE tip_racuna(
	id integer not null,
    naziv varchar(100),
    oznaka varchar(20),
    opis varchar(500)
);
alter table tip_racuna add constraint pk_tip_racuna primary key(id);

CREATE TABLE klijent(
	id integer not null,
    ime varchar(50) not null,
    prezime varchar(50) not null,
	broj_lk integer not null,
    kredit integer not null
);
alter table klijent add constraint pk_klijent primary key(id);
alter table klijent add constraint fk_klijent_kredit foreign key(kredit) references kredit(id);

CREATE TABLE racun(
	id integer not null,
    naziv varchar(100) not null,
    oznaka varchar(20)not null,
    opis varchar(500) not null,
    tip_racuna integer not null,
    klijent integer not null
);
alter table racun add constraint pk_racun primary key(id);
alter table racun add constraint fk_racun_tip_racuna foreign key(tip_racuna) references tip_racuna(id);
alter table racun add constraint fk_racun_klijent foreign key(klijent) references klijent(id);


create index idxfk_racun_klijent on racun(klijent);
create index idxfk_racun_tip_racuna on racun(tip_racuna);
create index idxfk_klijent_kredit on klijent(kredit);


create sequence kredit_seq
increment 1;
create sequence tip_racuna_seq
increment 1;
create sequence klijent_seq
increment 1;
create sequence racun_seq
increment 1;



