
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

