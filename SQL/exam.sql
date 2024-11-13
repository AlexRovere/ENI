use train
go
	
	-- drop table routes

	CREATE TABLE ROUTES (
		route_id char(5) not null,
		route_short_name varchar(30),
		route_long_name	varchar(50),
		route_type	varchar(30),
		route_color	varchar(30),
		route_text_color varchar(30)
	)

	CREATE TABLE STOPS (

		 stop_id char(5) CONSTRAINT PK_STOPS primary key,
		 stop_name varchar(50) not null,
		 stop_lat numeric(10,8) not null,
		 stop_lon numeric(10,8) not null,
		 location_type bit not null,
		 parent_station char(5) null CONSTRAINT FK_STOPS_STOPS FOREIGN KEY REFERENCES stops(stop_id),
		 wheelchair_boarding numeric(1)
		 )

	CREATE TABLE TRIPS (
		route_id char(5) not null,
		service_id varchar(24) not null,
		trip_id varchar(35) CONSTRAINT PK_TRIPS PRIMARY KEY,
		trip_headsign varchar(50) not null,
		direction_id bit not null,
		block_id varchar(7) not null,
		shape_id varchar(7) not null
		)

	CREATE TABLE STOPSTIMES (

     trip_id varchar(35) not null CONSTRAINT FK_STOPSTIMES_TRIPS FOREIGN KEY REFERENCES trips(trip_id) ON DELETE CASCADE,
	 arrival_time char(8) not null,
     departure_time char(8) not null,
     stop_id char(5) not null CONSTRAINT FK_STOPSTIMES_STOPS FOREIGN KEY REFERENCES stops(stop_id),
	 stop_sequence numeric(2) not null,
     pickup_type numeric(1) not null,
     drop_off_type numeric(1) not null
	 )

	 ALTER TABLE ROUTES ADD CONSTRAINT PK_ROUTES PRIMARY KEY (route_id)
	 ALTER TABLE STOPSTIMES ADD CONSTRAINT PK_STOPSTIMES primary key (trip_id, stop_sequence)
	 ALTER TABLE TRIPS ADD CONSTRAINT FK_TRIPS_ROUTES FOREIGN KEY (route_id) REFERENCES ROUTES(route_id) on delete cascade
	 ALTER TABLE STOPS ADD CONSTRAINT CK_STOPS_STOP_LAT CHECK (stop_lat BETWEEN -90 AND 90)
	 ALTER TABLE STOPS ADD CONSTRAINT CK_STOPS_LOCATION_TYPE CHECK (location_type in(0,1))

	 ALTER TABLE STOPS ADD CONSTRAINT CK_STOPS_LOC_PAR CHECK ((location_type = 0 AND parent_station IS NOT NULL) OR (location_type = 1 AND parent_station IS NULL))

	 ALTER TABLE STOPSTIMES ADD CONSTRAINT CK_STOPSTIMES_STOP_SEQUENCE CHECK(stop_sequence > 0)

	 ALTER TABLE ROUTES ADD CONSTRAINT ROUTES_ROUTE_SHORT_NAME UNIQUE (route_short_name)

	 CREATE INDEX IX_STOPS_STOP_NAME ON STOPS (STOP_NAME)
