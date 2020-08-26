create table movie_booking.user
(
    id        int auto_increment
        primary key,
    user_name varchar(500) null,
    password  varchar(500) null,
    role      varchar(500) null
) ;
create table movie_booking.movie
(
    id                   int auto_increment
        primary key,
    cover_picture        varchar(200)  null,
    movie_name           varchar(100)  null,
    directors            varchar(200)  null,
    cast                 varchar(200)  null,
    category             varchar(200)  null,
    premiere             datetime      null,
    duration             int           null,
    language             varchar(100)  null,
    rated                int           null,
    description          varchar(2500) null,
    movie_start_time     datetime      null,
    movie_available_seat int           null
);

