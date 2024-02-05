drop table if exists post;

create table post (
                      id bigint not null auto_increment,
                      title varchar(255),
                      body text,
                      author varchar(45),
                      primary key(id)
)