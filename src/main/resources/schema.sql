create sequence s_ticket_id;
create sequence s_user_id;
create sequence s_customer_id;
create sequence s_comment_id;

create table sd_tickets (
  id    bigint DEFAULT nextval('s_ticket_id'),
  name  varchar(250),
  description varchar(4000),
  user_id bigint,
  user_name varchar(250),
  created timestamp
);

create table sd_ticket_comments (
  id  bigint DEFAULT nextval('s_comment_id'),
  ticket_id bigint,
  user_id bigint,
  user_name varchar(250),
  comment varchar(4000),
  created timestamp
);

create table sd_users (
  id    bigint DEFAULT nextval('s_user_id'),
  name  varchar(250),
  email varchar(250),
  password varchar(25),
  role varchar(250),
  created timestamp
);

create table sd_customers (
  id    bigint DEFAULT nextval('s_customer_id'),
  name  varchar(250),
  created timestamp
);

create table sd_settings (
  key   varchar(128),
  value varchar(250)
);

