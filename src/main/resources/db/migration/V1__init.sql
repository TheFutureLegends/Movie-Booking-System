create database movie_booking;
use movie_booking;

create table movie_booking.user
(
    id        int auto_increment
        primary key,
    user_name varchar(500) null,
    password  varchar(500) null,
    role      varchar(500) null
) engine = innoDB charset = utf8 ;

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
) engine = innoDB charset = utf8 ;

create table movie_booking.user_profile
(
    id        int auto_increment
        primary key,
    full_name varchar(300) null,
    phone     varchar(100) null,
    email     varchar(100) null,
    address   varchar(500) null
) engine = innoDB charset = utf8 ;

create table movie_booking.reservation
(
    id           int auto_increment
        primary key,
    name         varchar(200) null,
    date_time    datetime     null,
    status       varchar(100) null,
    u_profile_id int          null,
    constraint reservation_user_profile_id_fk
        foreign key (u_profile_id) references movie_booking.user_profile (id)
) engine = innoDB charset = utf8 ;


