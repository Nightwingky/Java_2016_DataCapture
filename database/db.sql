create database db_java_shopping_cart;

grant all privileges on db_java_shopping_cart.* to nightwingky@localhost identified by '666796';

CREATE TABLE tb_course_info (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  contentImageURL VARCHAR(100),
  contentTitle VARCHAR(100),
  contentPrice VARCHAR(100)
);

show CREATE TABLE tb_course_info;

CREATE TABLE tb_shoppingcart_info (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  commodityImageURL VARCHAR(100),
  commodityTitle VARCHAR(100),
  commodityPrice VARCHAR(100),
  commodityAmount VARCHAR(10)
)ENGINE=InnoDB DEFAULT CHARSET=gbk COLLATE=gbk_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

SELECT * FROM tb_shoppingcart_info;

UPDATE tb_shoppingcart_info SET commodityAmount = 1 where 1 = 1;

CREATE TABLE tb_item_info (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  itemContentTitle VARCHAR(100),
  itemPicURL VARCHAR(100),
  itemDescription VARCHAR(100)
)ENGINE=InnoDB DEFAULT CHARSET=gbk COLLATE=gbk_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

SELECT * FROM tb_item_info;