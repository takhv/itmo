-- первый запрос
select Н_ЛЮДИ.ФАМИЛИЯ, Н_СЕССИЯ.ДАТА from Н_ЛЮДИ 
right join Н_СЕССИЯ on Н_ЛЮДИ.ИД = Н_СЕССИЯ.ЧЛВК_ИД 
where Н_ЛЮДИ.ИД < 100865 and Н_СЕССИЯ.ДАТА ='2004-01-17' and Н_СЕССИЯ.ДАТА < '2004-01-17';


-- второй запрос
select Н_ЛЮДИ.ИД, Н_ОБУЧЕНИЯ.ЧЛВК_ИД, Н_УЧЕНИКИ.ГРУППА
from Н_ЛЮДИ 
inner join Н_ОБУЧЕНИЯ on Н_ЛЮДИ.ИД = Н_ОБУЧЕНИЯ.ЧЛВК_ИД
inner join Н_УЧЕНИКИ on Н_УЧЕНИКИ.ИД = Н_ОБУЧЕНИЯ.ЧЛВК_ИД
where Н_ЛЮДИ.ФАМИЛИЯ > 'Иванов' and Н_ОБУЧЕНИЯ.ЧЛВК_ИД > 163276;


-- третий запрос
select count(*) from ( select Н_ЛЮДИ.ОТЧЕСТВО from Н_ЛЮДИ group by Н_ЛЮДИ.ОТЧЕСТВО) as unique_fathernames;


-- четвертый запрос
select Н_ПЛАНЫ.НОМЕР from Н_ГРУППЫ_ПЛАНОВ 
join Н_ПЛАНЫ on Н_ГРУППЫ_ПЛАНОВ.ПЛАН_ИД = Н_ПЛАНЫ.ПЛАН_ИД
join Н_ОТДЕЛЫ on Н_ОТДЕЛЫ.ИД = Н_ПЛАНЫ.ОТД_ИД 
where Н_ОТДЕЛЫ.КОРОТКОЕ_ИМЯ = 'КТиУ'
group by Н_ПЛАНЫ.НОМЕР
having count(distinct Н_ГРУППЫ_ПЛАНОВ.ГРУППА) = 2;

-- узнаем есть ли такие планы где всего 2 группы
select Н_ПЛАНЫ.НОМЕР from Н_ГРУППЫ_ПЛАНОВ 
join Н_ПЛАНЫ on Н_ГРУППЫ_ПЛАНОВ.ПЛАН_ИД = Н_ПЛАНЫ.ПЛАН_ИД
join Н_ОТДЕЛЫ on Н_ОТДЕЛЫ.ИД = Н_ПЛАНЫ.ОТД_ИД 
group by Н_ПЛАНЫ.НОМЕР
having count(distinct Н_ГРУППЫ_ПЛАНОВ.ГРУППА) = 2;

-- какой факультет
select Н_ПЛАНЫ.НОМЕР, Н_ОТДЕЛЫ.КОРОТКОЕ_ИМЯ from Н_ПЛАНЫ join Н_ОТДЕЛЫ on Н_ОТДЕЛЫ.ИД = Н_ПЛАНЫ.ОТД_ИД where НОМЕР = 4;


-- пятый запрос
SELECT Н_УЧЕНИКИ.ГРУППА, AVG(AGE(Н_ЛЮДИ.ДАТА_РОЖДЕНИЯ)) AS "СРЕДНИЙ ВОЗРАСТ"
FROM Н_ЛЮДИ
JOIN Н_УЧЕНИКИ ON Н_ЛЮДИ.ИД = Н_УЧЕНИКИ.ЧЛВК_ИД
GROUP BY Н_УЧЕНИКИ.ГРУППА
HAVING AVG(AGE(Н_ЛЮДИ.ДАТА_РОЖДЕНИЯ)) < 
(select min(age(Н_ЛЮДИ.ДАТА_РОЖДЕНИЯ)) from Н_ЛЮДИ join Н_УЧЕНИКИ on Н_ЛЮДИ.ИД = Н_УЧЕНИКИ.ЧЛВК_ИД where Н_УЧЕНИКИ.ГРУППА = '3100');

-- средний возраст
SELECT Н_УЧЕНИКИ.ГРУППА, AVG(AGE(Н_ЛЮДИ.ДАТА_РОЖДЕНИЯ)) AS "СРЕДНИЙ ВОЗРАСТ"
FROM Н_ЛЮДИ
JOIN Н_УЧЕНИКИ ON Н_ЛЮДИ.ИД = Н_УЧЕНИКИ.ЧЛВК_ИД
GROUP BY Н_УЧЕНИКИ.ГРУППА;

-- min в 3100
select min(age(Н_ЛЮДИ.ДАТА_РОЖДЕНИЯ)) from Н_ЛЮДИ join Н_УЧЕНИКИ on Н_ЛЮДИ.ИД = Н_УЧЕНИКИ.ЧЛВК_ИД where Н_УЧЕНИКИ.ГРУППА = '3100';


-- шестой запрос
select Н_УЧЕНИКИ.ГРУППА, Н_УЧЕНИКИ.ИД, Н_ЛЮДИ.ФАМИЛИЯ, Н_ЛЮДИ.ИМЯ, Н_ЛЮДИ.ОТЧЕСТВО, Н_УЧЕНИКИ.В_СВЯЗИ_С
from Н_УЧЕНИКИ
join Н_ЛЮДИ on Н_ЛЮДИ.ИД = Н_УЧЕНИКИ.ЧЛВК_ИД
where exists (select Н_УЧЕНИКИ.НАЧАЛО, Н_ПЛАНЫ.КУРС, Н_ФОРМЫ_ОБУЧЕНИЯ.НАИМЕНОВАНИЕ, Н_НАПР_СПЕЦ.НАИМЕНОВАНИЕ 
from Н_УЧЕНИКИ
join Н_ПЛАНЫ on Н_ПЛАНЫ.ИД = Н_УЧЕНИКИ.ПЛАН_ИД
join Н_НАПР_СПЕЦ on Н_НАПР_СПЕЦ.ИД = Н_ПЛАНЫ.НАПС_ИД
join Н_ФОРМЫ_ОБУЧЕНИЯ on Н_ФОРМЫ_ОБУЧЕНИЯ.ИД = Н_ПЛАНЫ.ФО_ИД
where Н_УЧЕНИКИ.НАЧАЛО < '2012-09-01' and Н_ПЛАНЫ.КУРС = 1 and Н_ФОРМЫ_ОБУЧЕНИЯ.НАИМЕНОВАНИЕ = 'Очная' and Н_НАПР_СПЕЦ.НАИМЕНОВАНИЕ = 'Программная инженерия');


-- седьмой запрос
select Н_ЛЮДИ.ФАМИЛИЯ, Н_ОТДЕЛЫ.КОРОТКОЕ_ИМЯ from Н_ЛЮДИ 
join Н_УЧЕНИКИ on Н_ЛЮДИ.ИД = Н_УЧЕНИКИ.ЧЛВК_ИД
join Н_ПЛАНЫ on Н_ПЛАНЫ.ИД = Н_УЧЕНИКИ.ПЛАН_ИД
join Н_ОТДЕЛЫ on Н_ОТДЕЛЫ.ИД = Н_ПЛАНЫ.ОТД_ИД 
where Н_ОТДЕЛЫ.КОРОТКОЕ_ИМЯ != 'КТиУ';

-- предметы КТиУ на сессии
select distinct Н_ДИСЦИПЛИНЫ.НАИМЕНОВАНИЕ from Н_ДИСЦИПЛИНЫ
join Н_СТРОКИ_ПЛАНОВ on Н_ДИСЦИПЛИНЫ.ИД = Н_СТРОКИ_ПЛАНОВ.ДИС_ИД
join Н_ЭЛЕМЕНТЫ_СТРОК on Н_СТРОКИ_ПЛАНОВ.ИД = Н_ЭЛЕМЕНТЫ_СТРОК.СПЛ_ИД
join Н_СОДЕРЖАНИЯ_ЭЛЕМЕНТОВ_СТРОК on Н_ЭЛЕМЕНТЫ_СТРОК.ИД = Н_СОДЕРЖАНИЯ_ЭЛЕМЕНТОВ_СТРОК.ЭСТ_ИД
join Н_СЕССИЯ on Н_СОДЕРЖАНИЯ_ЭЛЕМЕНТОВ_СТРОК.ИД = Н_СЕССИЯ.СЭС_ИД
where exists(select Н_ОТДЕЛЫ.КОРОТКОЕ_ИМЯ from Н_СЕССИЯ
join Н_ЛЮДИ on Н_ЛЮДИ.ИД = Н_СЕССИЯ.ЧЛВК_ИД
join Н_УЧЕНИКИ on Н_ЛЮДИ.ИД = Н_УЧЕНИКИ.ЧЛВК_ИД 
join Н_ПЛАНЫ on Н_ПЛАНЫ.ИД = Н_УЧЕНИКИ.ПЛАН_ИД
join Н_ОТДЕЛЫ on Н_ОТДЕЛЫ.ИД = Н_ПЛАНЫ.ОТД_ИД 
where Н_ОТДЕЛЫ.КОРОТКОЕ_ИМЯ = 'КТиУ')
order by Н_ДИСЦИПЛИНЫ.НАИМЕНОВАНИЕ;


select student.name, exam.name from student
inner join writing on writing.stud_id = student.stud_id
inner join exam on writing.exam_id = exam.exam_id
where student.name = 'hui';