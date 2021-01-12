insert into"kredit"("id","naziv","oznaka","opis")
values(nextval('kredit_seq'),'Bezgotovinski','BG','Kredit po tekucem racunu');
insert into"kredit"("id","naziv","oznaka","opis")
values(nextval('kredit_seq'),'Gotovinski','GG','Kredit po tekucem racunu');
insert into"kredit"("id","naziv","oznaka","opis")
values(nextval('kredit_seq'),'Stambeni','ST','Namenski kredit');

insert into"tip_racuna"("id","naziv","oznaka","opis")
values(nextval('tip_racuna_seq'),'Tekuci racun','TR','vrlo tekuci racun');
insert into"tip_racuna"("id","naziv","oznaka","opis")
values(nextval('tip_racuna_seq'),'Devizni racun','DR','vrlo devizni racun');
insert into"tip_racuna"("id","naziv","oznaka","opis")
values(nextval('tip_racuna_seq'),'Studentski racun','SR','vrlo studentski racun');

insert into"klijent"("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'Vuk','Karadzic',1807995,1);
insert into"klijent"("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'Dositej','Obradovic',125487,2);
insert into"klijent"("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'Filip','Visnjic',321548,3);

insert into"racun"("id","naziv","oznaka","opis","tip_racuna","klijent")
values(nextval('racun_seq'),'racun1','r1','prvi racun',1,1);
insert into"racun"("id","naziv","oznaka","opis","tip_racuna","klijent")
values(nextval('racun_seq'),'racun2','r2','prvi racun',2,1);
insert into"racun"("id","naziv","oznaka","opis","tip_racuna","klijent")
values(nextval('racun_seq'),'racun3','r3','prvi racun',3,1);





