CREATE TABLE public."User" (
	id integer NOT NULL,
	firstname varchar(128) NOT NULL,
	lastname varchar(128) NOT NULL,
	age integer NULL,
	phone integer NOT NULL,
	email varchar NOT NULL,
	"location" varchar NOT NULL,
	username varchar(128) NOT NULL,
	"password" varchar NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id),
	CONSTRAINT user_un UNIQUE (phone,email,username)
);
