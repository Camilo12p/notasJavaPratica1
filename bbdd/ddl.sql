DROP DATABASE IF EXISTS app_educativa;

CREATE DATABASE app_educativa;

USE app_educativa;


CREATE TABLE type_document (

    id INT AUTO_INCREMENT,
    name VARCHAR(30),

    CONSTRAINT pk_type_document PRIMARY KEY (id) 
);

CREATE TABLE person (

    id BIGINT NOT NULL,
    id_type_doc INT,
    name VARCHAR(30),
    last_name VARCHAR(30),
    birthday DATE,
    email VARCHAR(30) NOT NULL,
    phone_number BIGINT,
    password VARCHAR(30) NOT NULL,
    -- add more information

    CONSTRAINT pk_person PRIMARY KEY (id),
    CONSTRAINT fk_person_typedoc FOREIGN KEY (id_type_doc) REFERENCES type_document(id)
);


CREATE TABLE applicant (
    id INT AUTO_INCREMENT,
    id_person BIGINT,
    entry_date DATE,

    CONSTRAINT pk_applicant PRIMARY KEY (id),
    CONSTRAINT fk_applicant_person FOREIGN KEY (id_person) REFERENCES person(id)
);

CREATE TABLE admission_test (
    id INT AUTO_INCREMENT,
    id_applicant INT,
    score FLOAT(5,2),


    CONSTRAINT pk_admission_test PRIMARY KEY (id),
    CONSTRAINT fk_admission_applicant FOREIGN KEY (id_applicant) REFERENCES applicant(id)
    
);

CREATE TABLE subject (
    id INT,
    name VARCHAR(30),
    -- more information about subject
    
    CONSTRAINT pk_subject PRIMARY KEY (id)

);

CREATE TABLE study_plan(

    id INT,
    name VARCHAR(30),
    -- more information about subject
    
    CONSTRAINT pk_studyplan PRIMARY KEY (id)
);

CREATE TABLE plan_subject (
    id_study_plan INT,
    id_subject INT,


    CONSTRAINT pk_plan_subject_study PRIMARY KEY (id_study_plan, id_subject)
);

CREATE TABLE group_study(

    id INT,
    name VARCHAR(30),
    capacity TINYINT,
    enrolled_students TINYINT,
    id_study_plan INT,

    CONSTRAINT pk_group PRIMARY KEY (id),
    CONSTRAINT fk_group_studyplan FOREIGN KEY (id_study_plan) REFERENCES study_plan(id)
);

CREATE TABLE student(
    id INT,
    id_person BIGINT,
    id_study_plan INT,
    id_group_study INT,
    entry_date DATE,

      
    CONSTRAINT pk_student PRIMARY KEY (id), 
    CONSTRAINT fk_student_person FOREIGN KEY (id_person) REFERENCES person(id), 
    CONSTRAINT fk_student_studyplan FOREIGN KEY (id_study_plan) REFERENCES study_plan(id),
    CONSTRAINT fk_student_group FOREIGN KEY (id_group_study) REFERENCES group_study(id) 

);
