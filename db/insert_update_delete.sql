/*
	DML
    C : insert / into	데이터 추가
    R : select / from	데이터 조회
    U : update / set	데이터 수정
    D : delete / from	데이터 삭제
*/

/*================<< insert >>================*/
select * from student_mst;

insert into student_mst 
	(student_id,	student_name,	mentor_id)
values 
	(5,				'이강용',			10),
	(6,				'김준경',			10),
	(7,				'이현수',			10),
	(8,				'정의현',			10);
    
select * from university_mst;

insert into university_mst
	(university_id, university_name)
values
	(4, '카이스트'),
	(5, '고려대'),
	(6, '연세대'),
	(7, '포항공대'),
	(8, '성균관대'),
	(9, '한양대'),
	(10, '경희대');
    
/*================<< update >>================*/
select * from student_mst;

update student_mst
set
	student_name = '김재영',
	mentor_id = 15
where
	student_id = 5;
    
/* 멘토 아이디가 10인 학생들의 멘토 아이디를 1로 바꿔라 */

update student_mst
set
	mentor_id = 1
where
	mentor_id = 10;

/*================<< delete >>================*/

delete
from
	student_mst 
where 
	student_id = 4
and	student_name = '손지호';

select * from student_mst;

select * from university_mst;

delete
from
	university_mst
where
	university_id in(1,2,3,4,5);