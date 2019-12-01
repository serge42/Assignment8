CREATE TABLE users(id INTEGER PRIMARY KEY, name varchar(20), address varchar(20), pwd_hash BLOB, friend_id INTEGER, FOREIGN KEY (friend_id) REFERENCES users(id));
INSERT INTO users(name,address) VALUES ("demo_user","21 St. street");
INSERT INTO users(name,address,friend_id) VALUES ("demo_friend","St. 002",1);

