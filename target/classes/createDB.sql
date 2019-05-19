DROP TABLE IF EXISTS Users;


CREATE TABLE public."Users" (
	id integer NOT NULL,
	firstname varchar(128) NOT NULL,
	lastname varchar(128) NOT NULL,
	age integer(55) NULL,
	phone integer(55) NOT NULL,
	email varchar(128) NOT NULL,
	"location" varchar NOT NULL,
	username varchar(128) NOT NULL,
	"password" varchar NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id),
	CONSTRAINT user_un UNIQUE (phone,email,username)
);
