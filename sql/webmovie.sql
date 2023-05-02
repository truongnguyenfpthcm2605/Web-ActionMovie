/*
DỰ ÁN WEB XEM PHIM ACTION MOVIE
MSSV : PS24083
TEN : NGUYỄN VĂN TRƯỜNG
NGAY TẠO : 12/03/2023
*/

CREATE DATABASE ActionMovie
ON
(
	NAME = ActionMovie_dat,
	FILENAME = 'D:\JAVA4\SQLMovie\ActionMovie.mdf'

)
LOG ON
(
	NAME = ActionMovie_ldf,
	FILENAME = 'D:\JAVA4\SQLMovie\ActionMovie.ldf'
)
GO
USE ActionMovie
GO

CREATE TABLE USERS
(
	id int identity(1,1) primary key,
	username VARCHAR(20) unique NOT NULL,
	pass VARCHAR(12) NOT NULL,
	email NVARCHAR(30) not null,
	fullname NVARCHAR(30) ,
	birth DATE not null,
	avatar NVARCHAR(50),
	starday datetime default getdate(),
	vip INT DEFAULT 0,
	admin BIT DEFAULT 0,
	active BIT DEFAULT 0

)
GO
CREATE TABLE GENREVIDEO 
(
	id int identity(1,1) primary key,
	title  NVARCHAR(60) NOT NULL,
)
GO
CREATE TABLE VIDEO 
(
	id int identity(1,1) primary key,
	title NVARCHAR(60) NOT NULL,
	poster NVARCHAR(235) ,
	[views] INT DEFAULT 0,
	link  NVARCHAR(100) unique NOT NULL,
	descriptions TEXT NOT NULL,
	active BIT DEFAULT 0 ,
	vip BIT DEFAULT 0,
	quality VARCHAR(10) NOT NULL,
	dayupload datetime  default getdate() ,
	times INT not null,
	idgenre INT
	CONSTRAINT FK_GENREVIDEO FOREIGN KEY( idgenre) REFERENCES GENREVIDEO(id),
)
GO
CREATE TABLE FAVORITE 
(
	id int identity(1,1) primary key,
	userid INT,
	videoid INT ,
	likedate datetime default getdate(),
	active bit default 0
	CONSTRAINT FK_ACCOUNTID FOREIGN KEY(userid ) REFERENCES USERS(id),
	CONSTRAINT FK_VIDEOID FOREIGN KEY(videoid ) REFERENCES VIDEO(id)
)
GO
CREATE TABLE SHARE 
(
	id int identity(1,1) primary key,
	userid INT,
	videoid INT ,
	emails VARCHAR(60) NOT NULL,
	sharedate datetime default getdate(),
	number int
	CONSTRAINT FK_ACCOUNTIDSH FOREIGN KEY(userid ) REFERENCES USERS(id),
	CONSTRAINT FK_VIDEOIDSH FOREIGN KEY(videoid ) REFERENCES VIDEO(id)
)
GO



select sum(number) from share where videoid = 2

insert into USERS(username,pass,email,fullname,birth,avatar,vip,admin,active)
values ('taing56','Tai26dfdf001',N'tainguenlqm@gmail.com',N'Nguyễn Văn Tài','1990-02-23',N'avatarthuy.jpg',1,0,1)
select * from video
update users set avatar = N'avatarGau.jpg'
delete USERS where id =7

select * from favorite
select * from users
select * from share
select * from video
select * from GENREVIDEO


