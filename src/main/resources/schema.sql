create table if not exists books (
     id bigserial not null,
     name varchar not null,
     author varchar not null,
     primary key (id)
);
