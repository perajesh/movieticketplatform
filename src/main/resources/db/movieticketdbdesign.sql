CREATE TABLE TBL_MOVIE(
	movieId int,
	title  varchar(256),
	description varchar(512),
	duration timestamp,
	releaseDate timestamp,
	country varchar(100),
	genre varchar(30),
	CONSTRAINT movie_id_pk PRIMARY KEY(movieid)
);

CREATE TABLE TBL_STATES(
	state_id int,
	state_name varchar(100),
	CONSTRAINT state_pk PRIMARY kEY(state_id)
);

CREATE TABLE TBL_CITY(
	cityId int,
	city_name varchar(100),
	zipcode varchar(10),
	state_id int not null,
	CONSTRAINT city_pk PRIMARY kEY(cityId),
	CONSTRAINT state_id_fk FOREIGN KEY(state_id) REFERENCES TBL_STATES(state_id)
);

CREATE TABLE TBL_CINEMA(
	cinemaId int,
	Name varchar(100),
	totalCinemaHalls int,
	cityid int,
	CONSTRAINT cinema_id_pk PRIMARY kEY(cinemaId),
	CONSTRAINT city_id_fk FOREIGN KEY(cityid) REFERENCES TBL_CITY(cityId)
	
);

CREATE TABLE TBL_CINEMA_HALL(
	cinema_hall_id int,
	name varchar(256),
	totalSeats int,
	cinemaid int,
	CONSTRAINT cinema_hall_id_pk PRIMARY kEY(cinema_hall_id),
	CONSTRAINT cinemaid_fk FOREIGN KEY(cinemaid) REFERENCES TBL_CINEMA(cinemaId)
)

CREATE TABLE TBL_SHOW(
	showId int,
	date TIMESTAMP,
	starttime TIMESTAMP,
	endtime timestamp,
	cinemaHallid int,
	movieid int,
	CONSTRAINT showId_pk PRIMARY kEY(showId),
	CONSTRAINT cinemaHallid_fk FOREIGN KEY(cinemaHallid) REFERENCES TBL_CINEMA_HALL(cinema_hall_id),
	CONSTRAINT movieid_fk FOREIGN KEY(movieid) REFERENCES TBL_MOVIE(movieId)

);

CREATE TABLE TBL_USER(
	userId int,
	name varchar(256),
	password varchar(20),
	email varchar(100),
	phone varchar(12),
	CONSTRAINT userid_PK PRIMARY KEY(userId)
);

CREATE TABLE TBL_BOOKING(
	bookingId int,
	numberOfSeats int,
	bookingDate timestamp,
	status varchar(20),
	userid int,
	showid int,
	CONSTRAINT bookingId_PK PRIMARY KEY(bookingId),
	CONSTRAINT userid_fk FOREIGN KEY(userid) REFERENCES TBL_USER(userId),
	CONSTRAINT showid_fk FOREIGN KEY(showid) REFERENCES TBL_SHOW(showId)
);

CREATE TABLE TBL_CINEMA_SEAT(
	cinemaSeatId int,
	seatnumber int,
	type varchar(10),
	cinemahallid int,
	CONSTRAINT cinemaSeatId_pk PRIMARY KEY(cinemaSeatId),
	CONSTRAINT cinemahallid_fk FOREIGN KEY(cinemahallid) REFERENCES TBL_CINEMA_HALL(cinema_hall_id)
	
);

CREATE TABLE TBL_SHOW_SEAT(
	showSeatId int,
	status varchar(20),
	price numeric,
	cinemaSeatid int,
	showId int,
	bookingId int,
	CONSTRAINT showSeatId_pk PRIMARY KEY(showSeatId),
	CONSTRAINT cinema_Seatid_fk FOREIGN KEY(cinemaSeatid) REFERENCES TBL_CINEMA_SEAT(cinemaSeatId),
	CONSTRAINT cinema_showId_fk FOREIGN KEY(showId) REFERENCES TBL_SHOW(showId),
	CONSTRAINT cinema_bookingId_fk FOREIGN KEY(bookingId) REFERENCES TBL_BOOKING(bookingId)
);

CREATE TABLE TBL_PAYMENT(
	paymentId int,
	amount numeric,
	date TIMESTAMP,
	discountCouponId int,
	remoteTransactionId int,
	paymentmethod varchar(100),
	bookingId int,
	CONSTRAINT paymentId_pk PRIMARY KEY(paymentId),
	CONSTRAINT payment_bookingId_fk FOREIGN KEY(bookingId) REFERENCES TBL_BOOKING(bookingId)
);
//List all the cities
select * from tbl_city;

//List all the states
select * from tbl_city;

//Get the all cities present in particular state based on state id.
Select s.state_id,s.state_name,c.cityid,c.city_name 
from tbl_states s INNER JOIN tbl_city c on s.state_id=c.state_id where s.state_id=1;

//Get the list of movies
select * from tbl_movie;

//Get the all  shows

select * from tbl_show;

//Get the all movies shows which are in particular cinema
select m.title,s.showid,s.cinemahallid,h.name,h.totalseats,c.name from  
	tbl_movie m 
	INNER JOIN tbl_show s 
	on m.movieId= s.movieid
	INNER JOIN tbl_cinema_hall h
	on s.cinemahallid = h.cinema_hall_id
	INNER JOIN tbl_cinema c
	on c.cinemaid = h.cinemaid
	where c.name='PVR CInemas'




