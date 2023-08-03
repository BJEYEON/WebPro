-- DCL( 계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL( FK제약조건, 시퀀스 없음)
-- DML(OUTER JION, AND;&&, OR;||, 일부단일함수, ROWNUM이 없음 TOP-N구분이 다름)
-- JAVA시간에 쓸 데이터 넣고 연습해 보기
SHOW DATABASES; -- DATABASE 리스트

-- DCL( 계정생성, 권한부여, 권한박탈, 계정삭제)
create user scott identified by 'tiger'; -- 계정생성
grant all on *.* to scott; -- 권한부여
flush privileges;
revoke all on *.* from scott; -- 권한박탈
drop user scott;
-- 특정 데이터 베이스로 들어감alter
show database; -- 데이터베이스 리스트
use world; -- world 데이터 베이스로 들어감
select database(); -- 현재 들어와 있는데이터 베이스
show tables; -- 현재 데이터베이스안의 테이블들
create database parkdb; -- 새로운 데이터베이스 생성
use parkdb;
select database();
show tables; -- 오라클에서 select * 

-- ★★★ DDL
create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique,
    sal numeric(7,2) check(sal>0),
    comm numeric(7,2) default 0
);
desc emp;
drop table if exists emp;
create table emp(
	empno numeric(4),
    ename varchar(20) not null,
    nickname varchar(20),
    sal numeric(7,2),
    comm numeric(7,2) default 0,
    primary key(empno),
    unique(nickname),
    check(sal>0)
);
insert into emp values (1111, '홍길동', '동해번쩍', 900, null);
insert into emp values (1112, '홍길동', '동해번쩍', 900, null); -- 에러
select * from emp;

-- 0803 수업전 데이터베이스 들어가기
use parkdb;
select database();
-- major 테이블 mcode-pk학과번호(순차번호) / mname-학과명/ moffice-학과사무실
-- student 테이블 : sno-pk학번/ sname-이름 / score-성적 / mcode-fk학과번호
drop table if exists student;
drop table if exists major;
create table major(
	mcode int primary key auto_increment, -- auto_increment 필드의 경우 int타입
	mname varchar(30) unique,
    moffice varchar(30) not null
);
insert into major (mname,moffice) values ('컴퓨터공학', '202호'); -- 1번학과
insert into major (mname,moffice) values ('빅데이터', '203호'); -- 2번학과
insert into major (mname,moffice) values ('중국어', '402호'); -- 3번학과
insert into major (mname,moffice) values ('중국어', '502호'); -- unique 오류
select * from major;
-- student 테이블 : sno-pk학번/ sname-이름 / score-성적 / mcode-fk학과번호
drop table student;
create table student(
	sno numeric(4) primary key,
    sname varchar(30) not null,
    score numeric(3) check(score>=0 && score <=100),
    mcode int,
    foreign key(mcode) references major(mcode) -- 제약조건 중 forejignkey 제약조건은 반드시 아래에 명시
);
insert into student values (1000, '홍길동', -2,1); -- check오류
insert into student values (1000, '홍길동', 100,1);
insert into student values (1001, '신길동', 90,3);
insert into student values (1002, '김길동', 80,4);-- 오류나지 않음
select * from student;

-- 학번, 이름,점수, 학과번호, 학과 사무실(mysql과oracle은 equi join, non equi join, self join방법은동일)
select sno, sname, score, s.mcode, mname, moffice
	from student s,major m
    where s.mcode = m.mcode;
-- 학번, 이름, 점수, 학과번호, 학과명, 학과사무실(학생이 없는 학과도 출력)
select sno, sname, score, s.mcode, mname, moffice
	from student s right outer join major m
    on s.mcode = m.mcode;
select ifnull(sno, '-') sno , if(sname is null, '-', sname)sname, ifnull(score, '-')score, m.mcode,mname, moffice
	from major m left outer join student s
    on m.mcode = s.mcode;
    
-- ★★★★★자바(jdbc) 수업시간에 쓸 테이블 데이터★★★★★★
drop table if exists personal; -- cf.emp
drop table if exists division; -- cf.dept

create table division(
	dno int, -- 부서번호
	dname varchar(20) not null, -- 부서이름
    phone varchar(20) unique, -- 부서전화
    position varchar(20), -- 부서위치
    primary key(dno)
);
create table personal(
	pno int primary key, -- 사번
    pname varchar(20) not null, -- 사원명
    job varchar(20) not null, -- 직책
    manager int, -- 상사의 사번
    startdate date, -- 입사일
    pay int, -- 급여
    bonus int, -- 상여
    dno int, -- 부서번호
    foreign key(dno) references division(dno) -- fk제약조건은 반드시 밑에 명시match
);
select * from division;
select * from personal;

insert into division values(10, 'finance', '02-393-4321', '서대문');
insert into division values(20, 'research', '02-555-5555', '강남');
insert into division values(30, 'sales', '02-717-5555', '마포');
insert into division values(40, 'cs', '031-123-1234', '안양');
select * from division;


insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
select * from personal;
select count(*) from personal;

-- ★★★dml (outer join, and &&, or ||, 단일행 함수 nvl함수대신 ifnull사용)★★★
use parkdb;
select database();

-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal where pay between 2000 and 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno from personal where dno=20 || dno =10;
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay from personal where bonus is null order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno pay from personal order by dno, pay desc;
-- 6. 사번, 이름, 부서명
select pno, pname, dname
	from personal, division;
-- 7. 사번, 이름, 상사이름
select w.pno, w.pname, m.pname manager
	from personal w, personal m
    where w.manager = m.pno;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력하되 상사가 없는 경우 ★CEO★로 출력) – 우선
select w.pno, w.pname, ifnull(m.pname, '★ceo★') mananger
	from personal w left outer join personal m
    on w.manager = m.pno; -- bill의상사는 null
    
-- 9. 이름이 s로 시작하는 사원 이름 (like 이용, substr함수이용, instr함수 이용등 다양하게 사용 가능)
select pname
	from personal
    where pname like 's%';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, d.dname, m.pname
	from personal w, personal m, division d
    where w.manager = m.pno and w.dno = d.dno; 
-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
	from personal group by dno;
-- 12. 부서명, 급여평균, 인원수
select dname, avg(pay), count(pname)
	from personal p  right outer join division d
    on p.dno = d.dno group by dname;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay), count(*)
	from personal
   group by dno having count(*)>=4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
	from personal
    having max(pay);
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select avg(pay) from personal;
select pname, pay, dno
	from personal
    where pay>(select avg(pay) from personal);
-- 16. 회사 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서명을 출력(부서명순 정열 같으면 급여 큰순 정렬)
select pno, pname, pay, dname
	from personal p, division d
    where p.dno=d.dno and pay>(select avg(pay) from personal) order by pay desc;
-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균 (where절의 subQuery를 이용하거나 inline view를 이용)
select avg(pay) from personal group by dno;
select pname, pay, dno, round((select avg(pay) from personal where dno=p.dno))
	from personal p
    where pay > (select avg(pay) from personal where dno=p.dno);
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
 select pname, pay, dname
	from personal p, division d
    where p.dno=d.dno and startdate = (select min(startdate) from personal);
-- 19. 이름, 급여, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)
select avg(pay) from personal group by dno;
select pname, pay, (select avg(pay) from personal where dno=p.dno) avg
	from personal p;
-- 20. 이름, 급여, 부서명, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)
select avg(pay) from personal group by dno;
select pname, pay, d.dname, (select avg(pay) from personal where dno=p.dno) avg
	from personal p ,division d
    where p.dno = d.dno;


-- oracle 에서의 단일행 함수(컬럼함수)
select sysdate();
select curdate();
select * from personal;
insert into personal values (1000, '홍길동', 'manager', 1001, curdate(), null, null, 40);
select * from personal where pno=1000;
set sql_safe_updates =0; 
delete from personal where pno=1000;
    
-- ex. '이름은 job이다'
select concat(pname, '은', job, '이다') msg from personal;
select round(35.5678,2); -- from절 없이도 실행가능

-- 시스템으로부터 현재시점(datetime), 현재날짜(date), 현재시간(time)
select sysdate(), now(); -- 현재시점
select current_date(), curdate(); -- 현재날짜
select current_time(), curtime(); -- 현재시간

select year(sysdate()) "year", month(now()), day(now()), hour(now()),
	minute(now()), second(now());
select monthname(now()); -- 달이름
select dayname(startdate) from personal; -- 요일
select case weekday(now())
	when'0'then'월요일'
    when'1'then'화요일'
    when'2'then'수요일'
    when'3'then'목요일'
    when'4'then'금요일'
    when'5'then'토요일'
    when'6'then'일요일' end dayofweek;
    -- date_format(날짜,포맷): 날짜 -> 문자로 date_format(now(), %Y-%d-%d) 반대로도 가능
-- to_char(날짜,포맷): 날짜 -> 문자로 to_char(hiredate, 'YYYY-MM-DD')
-- to_date(문자,포맷): 문자->날짜로 to_date('2023-07-31','yyyy-mm-dd')
	-- 포먁: %Y(년도4자리2023)%y(년도2자리23)
		-- %m(01,02,...), %c(1,2,3,...), %M((january)
        -- %d(01,02,..) %e(1,2,3,4)
        -- %H(24시간) %h(12시간)%p(오전,오후) %i(분)%s(초)
select date_format(now(),'%Y년%c월%e일%p%h시%i분')now;

-- to_char(숫자, 포맷): to_char(sal,'9,999.99')
-- format(숫자): 숫자데이터, 소숫점자리수) : 소수점자리수까지 소수점이 출력되고, 세자리마다, 
select pname, format(pay,2) from personal; -- 소수점 두자리까지 오고, 세자리마다,
-- 이름, 급여, 급여가 3000이상인지 여부
select pname, pay, if(pay>=3000, '이상','이하') from personal;  

-- 별별 Top-n구문
	-- limit n (1등~n등)
    -- limit n1, n2(n1번째부터n2개. 첫번째0번째)
select pname,pay from personal order by pay desc;
select pname, pay from personal order by pay desc limit 5; -- 1번째~5번째
select pname, pay from personal order by pay desc limit 5,5; -- 5번째부터5개(=6번째~10번째)
-- 1등~3등
select pname, pay from personal order by pay desc limit 0,3;
-- 4등~6등
select pname, pay from personal order by pay desc limit 3,3;
-- 7등~9등
select pname, pay from personal order by pay desc limit 6,3;
    