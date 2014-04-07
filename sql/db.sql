
drop table booking;
drop table room;
drop table buser;

create table room(
   room_id int primary key
)

create table buser(
  buser_id int primary key,
  name varchar(20)
)

create table booking(
  booking_id int primary key, 
  day DATE,
  start_time TIME,
  end_time TIME,
  buser_id int,
  room_id int,
  FOREIGN KEY (buser_id) REFERENCES BUSER(BUSER_ID),
  FOREIGN KEY (room_id) REFERENCES ROOM(ROOM_ID)
)


insert into room
values (1);


insert into room
values (2);


insert into room
values (3);


insert into room
values (4);

select * from room;

insert into BUSER
values (1, 'Mark');

insert into BUSER
values (2, 'Lewis');

insert into BUSER
values (3, 'Anthony');

insert into BUSER
values (4, 'simon');

select * from BUSER;

insert into Booking
values (1, '2013-01-01', '09:00:00', '10:00:00' ,1, 1 );

insert into Booking
values (2, '2013-01-01', '10:00:00', '11:00:00' ,2, 1 );

insert into Booking
values (3, '2013-01-01', '13:00:00', '14:00:00' ,2, 2 );

insert into Booking
values (4, '2013-02-11', '09:00:00', '10:00:00' ,3, 1 );

insert into Booking
values (5, '2013-02-12', '09:00:00', '10:00:00' ,4, 1 );

select * from Booking;

select MAX(BOOKING_ID) from Booking;

SHUTDOWN;