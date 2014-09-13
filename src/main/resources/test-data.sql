
insert into rating (RATING_NAME) values ('G');
insert into rating (RATING_NAME) values ('PG');
insert into rating (RATING_NAME) values ('PG-13');
insert into rating (RATING_NAME) values ('M');
insert into rating (RATING_NAME) values ('R-16');
insert into rating (RATING_NAME) values ('R-18');

insert into media (title,description,rating_id) values ('Test Movie','Test Description',1);
insert into media_episode (media_id,season,episode_title) values (1,1,'Episode 1 Title');
insert into media_episode (media_id,season,episode_title) values (1,1,'Episode 2 Title');
