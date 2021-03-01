REM   Script: Activity4
REM   Activity4

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

ALTER table salesman Add Grade int;

select * from salesman;

select * from salesman;

desc salesman


UPDATE salesman SET grade=100;

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11,20) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14,30) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13,40) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12,50) 
SELECT 1 FROM DUAL;

UPDATE salesman SET grade=100 where city = 'London';

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11,20) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14,30) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13,40) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12,50) 
SELECT 1 FROM DUAL;

UPDATE salesman SET grade=100 where salesman_city = 'London';

UPDATE salesman SET grade=100 where salesman_city = 'London';

select * from salesman;

