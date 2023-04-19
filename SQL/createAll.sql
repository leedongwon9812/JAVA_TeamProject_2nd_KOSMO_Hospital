--계정생성
conn sys/java1234 as sysdba;
alter session set "_oracle_script"=true;
drop user GHos cascade;

create user GHos identified by ghos1234;
grant connect, resource, unlimited tablespace to GHos;
conn GHos/ghos1234;
alter session set NLS_DATE_FORMAT='YYYY-MM-DD HH24:MI:SS';

drop table RESERV;
drop table TREATM;
drop table SURGERY;
drop table PRESC;
drop table EXAM;
-- drop table LOGIN;
-- drop table MEDICINE;
drop table E_RESERV;
drop table E_SCHEDULE;
drop table PATIENT;
drop table D_SCHEDULE;
drop table DOCTOR;
drop table DEPT;

drop sequence RESERV_SEQ;

purge recyclebin;

-- 환자 테이블
create table PATIENT (
	P_ID VARCHAR2(14) constraint PATIENT_PK primary key,
	P_PWD VARCHAR2(14) not null,
	P_NAME VARCHAR2(18) not null,
	P_SSN VARCHAR2(14) constraint P_SSN_UQ unique not null,
	P_TEL VARCHAR2(13) constraint P_TEL_UQ unique not null,
	P_ADDR VARCHAR2(50) not null,
	P_EMAIL VARCHAR2(30)
);
/*
-- 로그인 테이블
create table LOGIN (
	P_ID VARCHAR2(14) constraint LOGIN_FK references PATIENT(P_ID) not null, 
	P_PWD VARCHAR2(14) not null
);
*/
-- 진료과목 테이블
create table DEPT (
	DEP_NAME VARCHAR2(24) constraint DEPT_PK primary key,
	DEP_CODE VARCHAR2(4) not null
);

-- 의료진 테이블
create table DOCTOR (
	DOC_ID VARCHAR2(10) constraint DOCTOR_PK primary key,
	DOC_NAME VARCHAR2(20) not null,
	DEP_NAME VARCHAR2(24) constraint DOCTOR_FK references DEPT(DEP_NAME) not null
);

-- 의료진 스케쥴 테이블
create table D_SCHEDULE (
	DOC_ID VARCHAR2(10) constraint D_SCHEDULE_FK references DOCTOR(DOC_ID) not null,
	TR_DATE DATE not null
);

-- 진료예약 테이블
create table RESERV (
	R_NO NUMBER constraint RESERV_PK primary key,
	P_ID VARCHAR2(14) constraint RESERV_FK1 references PATIENT(P_ID) not null,
	DOC_ID VARCHAR2(20) constraint RESERV_FK2 references DOCTOR(DOC_ID) not null,
	R_DATE DATE not null,
	R_REASON VARCHAR2(100)
);

create sequence RESERV_SEQ start with 1 increment by 1 nocache;

-- 건강검진 테이블
create table EXAM (
	P_ID VARCHAR2(14) constraint EXAM_FK references PATIENT(P_ID) not null,
	E_DATE DATE not null,
	HEIGHT NUMBER(4,1) not null,
	WEIGHT NUMBER(4,1) not null,
	BP VARCHAR2(10),
	FBS NUMBER(4,1),
	HDL NUMBER(4,1),
	LDL NUMBER(4,1),
	CREA NUMBER(3,1),
	AST NUMBER(4,1),
	ALT NUMBER(4,1)
);

-- 건강검진 스케쥴 테이블
create table E_SCHEDULE (
	E_DATE DATE constraint E_SCHEDULE_PK primary key
);

-- 건강검진 예약 테이블
create table E_RESERV (
	P_ID VARCHAR2(14) constraint E_RESERV_FK1 references PATIENT(P_ID) not null,
	E_DATE DATE not null 
);

-- 내원내역 테이블
create table TREATM (
	P_ID VARCHAR2(14) constraint TREATM_FK1 references PATIENT(P_ID) not null,
	DOC_ID VARCHAR2(10) constraint TREATM_FK2 references DOCTOR(DOC_ID) not null,
	DIS_NAME VARCHAR2(50) not null,
	TR_DATE DATE not null
);

-- 수술이력 테이블
create table SURGERY (
	P_ID VARCHAR2(14) constraint SURGERY_FK1 references PATIENT(P_ID) not null,
	DOC_ID VARCHAR2(10) constraint SURGERY_FK2 references DOCTOR(DOC_ID) not null,
	S_DATE DATE not null,
	S_NAME VARCHAR2(50) not null,
	DIS_NAME VARCHAR2(50) not null
);
/*
-- 의약품 테이블
create table MEDICINE (
	PR_NAME VARCHAR2(30) constraint MEDICINE_PK primary key,
	USAGES VARCHAR2(60) not null,
	EFFICACY VARCHAR2(200) not null,
	S_EFFECT VARCHAR2(1000) not null
);
*/
-- 처방내역 테이블
create table PRESC (
	P_ID VARCHAR2(14) constraint PRESC_FK1 references PATIENT(P_ID) not null,
	DOC_ID VARCHAR2(10) constraint PRESC_FK2 references DOCTOR(DOC_ID) not null,
	-- PR_NAME VARCHAR2(30) constraint PRESC_FK3 references MEDICINE(PR_NAME) not null,
	PR_NAME VARCHAR2(30) not null,
	PR_DATE DATE not null,
	DAYS NUMBER(3) not null,
	NUM NUMBER(1) not null,
	DOSE NUMBER(6,2) not null
);
/*
-- 자동 로그인 트리거
create or replace trigger AUTO_LOGIN
after
	insert on PATIENT
	for each row
begin
	insert into LOGIN(P_ID, P_PWD) values (:new.P_ID, :new.P_PWD);
end;
/

-- 비밀번호 변경 트리거
create or replace trigger CHANGES_PWD
after
	update on PATIENT
	for each row
begin
	update LOGIN set P_PWD=:new.P_PWD where P_ID=:new.P_ID;
end;
/
*/
