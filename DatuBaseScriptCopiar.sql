create database BidaiAgentzia;
create table Bezeroa(
NAN varchar(9) primary key,
Izena VARCHAR(50),
Abizenak VARCHAR(50),
Telefono VARCHAR(11),
Email VARCHAR(50),
Ordainketa_metodoa int 
);
create table Garraioa(
ID_Garraioa VARCHAR(10) PRIMARY key,
Enpresa VARCHAR(50),
Jatorria varchar(50),
Helmuga varchar(50)
); 
create table Erreserba_G(
NAN varchar(9),
ID_Garraioa VARCHAR(10),
Irteera_data DATE,
Helmuga_data date,
prezioa int,
primary key (NAN,ID_Garraioa),
FOREIGN key (ID_Garraioa) REFERENCES Garraioa(ID_Garraioa),
FOREIGN key (NAN) REFERENCES Bezeroa(NAN)
);
create table Itsasontzia(
ID_Garraioa VARCHAR(10) PRIMARY KEY,
Portua VARCHAR(50),
Kamaroteak int,

FOREIGN key (ID_Garraioa) REFERENCES Garraioa(ID_Garraioa)
);
create table hegazkina(
ID_Garraioa VARCHAR(10) PRIMARY KEY,
FOREIGN key (ID_Garraioa) REFERENCES Garraioa(ID_Garraioa),
H_Jesarlekua int,
Aireportua varchar(50)
);
create table bus(
ID_Garraioa VARCHAR(10) PRIMARY KEY,
FOREIGN key (ID_Garraioa) REFERENCES Garraioa(ID_Garraioa),
geltokiak VARCHAR(50),
B_jesarlekuak int
);
create table Ostatua(
ID_Ostatua int PRIMARY key,
izena varchar(50),
lekua varchar (50),
ostatu_mota varchar(50),
izarrak DOUBLE
);
create table Erreserba_O(
NAN varchar(9),
FOREIGN key (NAN) REFERENCES Bezeroa(NAN),
ID_Ostatua int,
FOREIGN key (ID_Ostatua) REFERENCES Ostatua(ID_Ostatua),
Sarrera_data date,
Irteera_data DATE,
prezioa double,

primary key (NAN,ID_Ostatua)
);

INSERT into Bezeroa
values ("78696442B","Eustaquio","Flamenco","667779892","Eusfla@gmail.com",666660999)
;
INSERT into Bezeroa
values ("55120002O","Francisca","Montenegro","000000092","FraMon@hotmail.com",1010121110)
;
INSERT into Bezeroa
values ("98020202E","Willbert","Stalton","889024146","WiSta@hotspot.com",88882000176)
;
Insert into bezeroa
values ("31010221N","Oscar Osvaldo Amor","Rodriguez Solis","778811181","ososamoroso@outlook.com",90293919191)
;
insert into Garraioa
values ("1p13c3","Mugiwara","EastBlue","Laughtale")
;
insert into Garraioa
values("2e1w0","Rayoinazuma","RaimonInstitutua","RoyalAcademy")
;
insert into Garraioa
values ("11s9","G-comandAirline","Japonia","Pazko Uharteak")
;
insert into Garraioa
values ("1c3r52","Titanic","Londres","Bermeo")
;
INSERT into Garraioa
values ("4ww59","AutobusMagikoa","Donostia","Cadiz")
;
INSERT into Garraioa
values ("72ss2","F21Airline","Egipto","Roma")
;
insert into Itsasontzia
values ("1p13c3","ArlongPark,Arabasta,Dressrosa",45)
;
INSERT into Itsasontzia
values ("1c3r52","BehienDimentsioa,Marsella",56)
;
insert into hegazkina
values ("11s9",200,98)
;
insert into hegazkina
values ("72ss2",180,71)
;
insert into bus
values ("2e1w0","AliusAkademia,ZanarkDomain",30)
;
INSERT into bus 
VALUES("4ww59","abaraska,Gizakigorputza",56)
;
INSERT  into Erreserba_G
values ("78696442B","1p13c3",'1999-10-20','2023-03-23',450)
;
INSERT  into Erreserba_G
values ("31010221N","1c3r52",'2023-01-01','2023-05-09',705)
;
INSERT into Erreserba_G
values ("98020202E","2e1w0",'2022-06-07','2022-09-12',56)
;
INSERT into Erreserba_G
values ("31010221N","11s9",'2020-08-31','2020-09-30',67)
;
INSERT into Erreserba_G
values("55120002O","11s9",'2020-05-12','2020-09-1',120)
;
INSERT INTO Ostatua
VALUES(10,"Ventormenta","kanpin-denda","Casa Catrina",4.5)
;
INSERT into Ostatua
values (43,"Bermeo","ontzi kareztatua","El inundado",5)
;
insert into Ostatua
values(55,"Atxondo","txabola","De reial fou",2.5)
;
insert into Ostatua
values(555,"amorebieta","hotel","Harryson",3)
;
insert into Erreserba_O
values ("31010221N",10,'2001-12-12','2012-12-12',1300)
;
insert into Erreserba_O
values ("55120002O",55,'2020-11-22','2021-01-1',1000)
;
insert into Erreserba_O
values ("98020202E",43,'2010-7-20','2010-08-12',1500)
;
insert into Erreserba_O
values ("78696442B",555,'2002-11-22','2003-03-12',10000)
;
create table Bezero_historikoak(
NAN varchar(9),
Izena VARCHAR(50),
Abizenak VARCHAR(50),
Telefono VARCHAR(11),
Email VARCHAR(50),
Ordainketa_metodoa int 
); 