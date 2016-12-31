create database db_java_shopping_cart;

grant all privileges on db_java_shopping_cart.* to nightwingky@localhost identified by '666796';

CREATE TABLE tb_course_info (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  contentImageURL VARCHAR(100),
  contentTitle VARCHAR(100),
  contentPrice VARCHAR(100)
);
