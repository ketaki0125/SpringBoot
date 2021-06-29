drop table if exists exam;

CREATE TABLE exam(
exam_id INT PRIMARY KEY,
exam_date date NOT NULL
);

INSERT into exam(exam_id,exam_date) values
(1001,'2021-08-01'),
(1002,'2021-08-02'),
(1003,'2021-08-03');

drop table if exists subject;

CREATE TABLE subject (
subject_id BIGINT AUTO_INCREMENT PRIMARY KEY,
subject_name VARCHAR(30) not null,
subject_score INT,
exam_id INT unique,
constraint ps_subject_exam_fk foreign key (exam_id)
references exam (exam_id)
);


INSERT INTO subject (subject_id,subject_name,subject_score,exam_id) values
(1234,'Maths',80,1001),
(1235,'Science',75,1002),
(1236,'English',70,1003);
