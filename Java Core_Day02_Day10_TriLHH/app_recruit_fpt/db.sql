drop database `fpt_recruit` ;
	

select * from fresher ;
select * from candidate;
select * from intern;


create database `fpt_recruit` ;
	use `fpt_recruit` ;

	create table candidate (
		id int primary key  ,
		full_name varchar(255) ,
		birthday date ,
		phone varchar(255),
		email varchar(255),
        candidate_type int
	);

	create table certificate(
		id_certificate int primary key ,
		certificate_name  varchar(255) ,
		certificate_rank varchar(255),
		Certificated_date date,
		id int ,
		foreign key(id) references candidate(id)
	);

	create table experience(
		id_experience int primary key auto_increment ,
		exp_in_year int ,
		pro_skill varchar(255) ,
		id int ,
		foreign key(id) references candidate(id)
	);

	create table fresher(
		id_fresher int primary key auto_increment ,
		graduation_date date ,
		graduation_rank varchar(255) ,
		education varchar(255),
		id int ,
		foreign key(id) references candidate(id)
	);

	create table intern(
		id_intern int primary key auto_increment ,
		majors varchar(255),
		semester int ,
         university_name varchar(45),
		id int ,
		foreign key(id) references candidate(id)
	);