create database db_java_shopping_cart;

grant all privileges on db_java_shopping_cart.* to nightwingky@localhost identified by '666796';

CREATE TABLE tb_course_info (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  newsIconUrl VARCHAR(100),
  newsTitle VARCHAR(100),
  newsContent VARCHAR(100)
);
