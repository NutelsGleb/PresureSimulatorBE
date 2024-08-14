-- Table: public.person

-- DROP TABLE public.person;

CREATE TABLE public.person
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    surname text COLLATE pg_catalog."default",
    fullname text COLLATE pg_catalog."default",
    age integer NOT NULL,
    gender text COLLATE pg_catalog."default",
    CONSTRAINT person_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.person
    OWNER to gleb;