drop table rentcar.news;

create table rentcar.news
( `id` int not null AUTO_INCREMENT 
, `title` varchar(300)
, `brief` varchar(1000)
, `content` varchar(4000)
, `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
, `create_user_id` int
, `rec_state` int not null default 1
, primary key (`id`)
, KEY `idx_rc` (`rec_state`)
) ENGINE=InnoDB AUTO_INCREMENT=5001 DEFAULT CHARSET=utf8;


insert into rentcar.news (`title`, `brief`, `content`, `create_user_id`) 
values ('How Irma Became So Big and So Destructive'
	  , 'A mix of meteorological conditions has conspired over the past week...'
      , 'A mix of meteorological conditions has conspired over the past week to make the storm unusually large and powerful.'
      , 1024
); 

insert into rentcar.news (`title`, `brief`, `content`, `create_user_id`) 
values ('Apocalyptic Fears Amid Nature’s Chaos? Not So Strange'
      , 'Four hurricanes, raging wildfires, and now a monster earthquake...'
      , 'Four hurricanes, raging wildfires, and now a monster earthquake. As one science fiction writer put it: “The End Times are getting in a few dress rehearsals right about now.”'
      , 1025
); 

insert into rentcar.news (`title`, `brief`, `content`, `create_user_id`) 
values ('Mexico Quake, Strongest in a Century, Leaves Dozens Dead'
      , 'A magnitude 8.2 earthquake struck off the southwestern coast of Mexico late Thursday...'
      , 'A magnitude 8.2 earthquake struck off the southwestern coast of Mexico late Thursday, shaking buildings as far away as Mexico City.'
      , 1026
); 

select * from rentcar.news;

commit;

