Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 18
Server version: 8.0.39 MySQL Community Server - GPL

Copyright (c) 2000, 2024, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| age                |
| assess             |
| emp                |
| employee           |
| information_schema |
| item               |
| mysql              |
| performance_schema |
| practice           |
| salespeople        |
| salesperson        |
| student            |
| student1           |
| sys                |
+--------------------+
14 rows in set (0.09 sec)

mysql> use assess;
Database changed
mysql> describe counrty;
ERROR 1146 (42S02): Table 'assess.counrty' doesn't exist
mysql> describe country;
+------------------+--------------+------+-----+---------+-------+
| Field            | Type         | Null | Key | Default | Extra |
+------------------+--------------+------+-----+---------+-------+
| id               | int          | NO   | PRI | NULL    |       |
| country_name     | varchar(100) | YES  |     | NULL    |       |
| country_name_eng | varchar(100) | YES  |     | NULL    |       |
| country_code     | varchar(10)  | YES  |     | NULL    |       |
+------------------+--------------+------+-----+---------+-------+
4 rows in set (0.04 sec)

mysql> create table city(id int primary key,city_name varchar(50),lat double,long double,country_id int,foreign key(country_id) references country(id));
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'long double,country_id int,foreign key(country_id) references country(id))' at line 1
mysql> create table city(id int primary key,city_name varchar(50),lat double,long double,country_id int,foreign key (country_id) references country(id));
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'long double,country_id int,foreign key (country_id) references country(id))' at line 1
mysql> create table city(id int primary key,city_name varchar(50),lat double,lon double,country_id int,foreign key (country_id) references country(id));
Query OK, 0 rows affected (0.25 sec)

mysql> create table customer(id int primary key,city_id int,customer_address varchar(50),next_call_date date,ts_inserted datetime,foreign key (city_id) references city(id));
Query OK, 0 rows affected (0.07 sec)

mysql> describe country;
+------------------+--------------+------+-----+---------+-------+
| Field            | Type         | Null | Key | Default | Extra |
+------------------+--------------+------+-----+---------+-------+
| id               | int          | NO   | PRI | NULL    |       |
| country_name     | varchar(100) | YES  |     | NULL    |       |
| country_name_eng | varchar(100) | YES  |     | NULL    |       |
| country_code     | varchar(10)  | YES  |     | NULL    |       |
+------------------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

mysql> describe city;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| id         | int         | NO   | PRI | NULL    |       |
| city_name  | varchar(50) | YES  |     | NULL    |       |
| lat        | double      | YES  |     | NULL    |       |
| lon        | double      | YES  |     | NULL    |       |
| country_id | int         | YES  | MUL | NULL    |       |
+------------+-------------+------+-----+---------+-------+
5 rows in set (0.01 sec)

mysql> describe customer;
+------------------+-------------+------+-----+---------+-------+
| Field            | Type        | Null | Key | Default | Extra |
+------------------+-------------+------+-----+---------+-------+
| id               | int         | NO   | PRI | NULL    |       |
| city_id          | int         | YES  | MUL | NULL    |       |
| customer_address | varchar(50) | YES  |     | NULL    |       |
| next_call_date   | date        | YES  |     | NULL    |       |
| ts_inserted      | datetime    | YES  |     | NULL    |       |
+------------------+-------------+------+-----+---------+-------+
5 rows in set (0.00 sec)

mysql> insert into country values(1,'deutschland','germany','deu');
Query OK, 1 row affected (0.01 sec)

mysql> insert into country values(2,'srbija','serbia','srb');
Query OK, 1 row affected (0.01 sec)

mysql> insert into country values(3,'hrvatska','croatia','hrv');
Query OK, 1 row affected (0.01 sec)

mysql> insert into country values(4,'united states of america','united states of america','usa');
Query OK, 1 row affected (0.01 sec)

mysql> insert into country values(5,'polska','poland','pol');
Query OK, 1 row affected (0.01 sec)

mysql> insert into country values(6,'espana','spain','esp');
Query OK, 1 row affected (0.01 sec)

mysql> insert into country values(7,'rossiya','russia','rus');
Query OK, 1 row affected (0.01 sec)

mysql> select * from country;
+----+--------------------------+--------------------------+--------------+
| id | country_name             | country_name_eng         | country_code |
+----+--------------------------+--------------------------+--------------+
|  1 | deutschland              | germany                  | deu          |
|  2 | srbija                   | serbia                   | srb          |
|  3 | hrvatska                 | croatia                  | hrv          |
|  4 | united states of america | united states of america | usa          |
|  5 | polska                   | poland                   | pol          |
|  6 | espana                   | spain                    | esp          |
|  7 | rossiya                  | russia                   | rus          |
+----+--------------------------+--------------------------+--------------+
7 rows in set (0.00 sec)

mysql>1 row in set (0.00 sec)

mysql> insert into city values(2,"belgrade",44.757197,20.457273,2);
Query OK, 1 row affected (0.01 sec)

mysql> insert into city values(3,"Zagreb",45.757197,15.966583,3);
Query OK, 1 row affected (0.01 sec)

mysql> insert into city values(4,"newyork",40.757197,-73.966583,4);
Query OK, 1 row affected (0.01 sec)

mysql> insert into city values(5,"los angeles",34.757197,-118.966583,4);
Query OK, 1 row affected (0.01 sec)

mysql> insert into city values(6,"Warsaw",52.757197,21.966583,5);
Query OK, 1 row affected (0.01 sec)

mysql> select * from city;
+----+-------------+-----------+-------------+------------+
| id | city_name   | lat       | lon         | country_id |
+----+-------------+-----------+-------------+------------+
|  1 | berlin      | 52.520008 |   13.404954 |          1 |
|  2 | belgrade    | 44.757197 |   20.457273 |          2 |
|  3 | Zagreb      | 45.757197 |   15.966583 |          3 |
|  4 | newyork     | 40.757197 |  -73.966583 |          4 |
|  5 | los angeles | 34.757197 | -118.966583 |          4 |
|  6 | Warsaw      | 52.757197 |   21.966583 |          5 |
+----+-------------+-----------+-------------+------------+
6 rows in set (0.00 sec)
mysql> select cou.country_name, ci.city_name, cus.customer_name from country cou left join city ci on cou.id = ci.country_id left join customer cus on ci.id = cus.city_id;
+--------------------------+-------------+---------------+
| country_name             | city_name   | customer_name |
+--------------------------+-------------+---------------+
| deutschland              | berlin      | cafe          |
| srbija                   | belgrade    | NULL          |
| hrvatska                 | Zagreb      | resturant     |
| united states of america | newyork     | jewelry store |
| united states of america | newyork     | backery       |
| united states of america | los angeles | NULL          |
| polska                   | Warsaw      | NULL          |
| espana                   | NULL        | NULL          |
| rossiya                  | NULL        | NULL          |
+--------------------------+-------------+---------------+
9 rows in set (0.00 sec)

mysql> select cou.country_name, ci.city_name, cus.customer_name from country cou inner join city ci on cou.id = ci.country_id left join customer cus on ci.id = cus.city_id;
+--------------------------+-------------+---------------+
| country_name             | city_name   | customer_name |
+--------------------------+-------------+---------------+
| deutschland              | berlin      | cafe          |
| srbija                   | belgrade    | NULL          |
| hrvatska                 | Zagreb      | resturant     |
| united states of america | newyork     | jewelry store |
| united states of america | newyork     | backery       |
| united states of america | los angeles | NULL          |
| polska                   | Warsaw      | NULL          |
+--------------------------+-------------+---------------+
7 rows in set (0.00 sec)

mysql>