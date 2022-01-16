# Мануал по запуску программы

## Сервер

1. Для запуска необходимо установить Apache Tomcat версии 9.0.55. Загрузить можно, используя ссылку https://tomcat.apache.org/download-90.cgi#9.0.56.
2. В файле pom.xml есть зависимость, отвечающая за соединение Tomcat с базой:
\<dependency>
   \<groupId>org.apache.tomcat\</groupId>
   \<artifactId>tomcat-dbcp\</artifactId>
   \<version>10.0.14\</version>
\</dependency>
3. Сборка проекта должна происходить в формат war: \<packaging>war\</packaging>.
4. В меню Maven Project (правая панель Intellij IDEA) выбираем clean | install для сборки проекта в war файл, который мы будем деплоить на сервер.
5. После этого в корне проекта появится папка target, в ней будет лежать war архив.
6. Для конфигурации необходимо добавить Tomcat Server – Local на панели Run/Debug Configurations, далее вводим имя и нажимаем Configure, выбрав расположение скачанного и распакованного Tomcat.
7. Далее переходим на вкладку Deployment, нажимаем плюс и выбираем Artifact:war.
8. После настройки проект можно запустить в двух режимах: обычный и Debug режим для отлова ошибок.

## База данных

1. В проекте используется база данных PostgreSQL. Установить можно, используя ссылку https://www.postgresql.org/.
2. В файл pom.xml есть зависимость, отвечающая за PostgreSQL:
\<dependency>
   \<groupId>org.postgresql\</groupId>
   \<artifactId>postgresql\/artifactId>
   \<version>42.3.1\</version>
\</dependency>
3. Необходимо добавить базу(предварительно создав ее), используя вкладку Database на правой панели Intellij IDEA.
4. Для загрузки базы необходимо изменить db.url на имя созданной базы, а также db.username и
   db.password на пароль и имя созданной базы в application.properties в папке resources.
5. По нажатию на кнопку обновления базы все поля будут загружены.

## Пользовательский интерфейс

1. Для взаимодействия с программой через GUI необходимо установить Angular CLI Server.
2. Нужно перейти на вкладку Terminal (на нижней панели Intellij IDEA).
3. Перейти в папку модуля frontend(в которой находится файл package.json), используя команду cd.
4. Добавить зависимости с помощью команды npm install.
5. Запустить сервер с помощью npm serve(доступ осуществляется по http://localhost:4200).

# SaM Solutions Spring internship report

## First week (13.12.21 - 19.12.21)

1. Git repository was made. Front and back structures were added.
2. Design (https://www.figma.com/file/lW44SG8Pnvk53C3Rq1Zpcb/SaMSolutions?node-id=0%3A1)
3. Subject area has been studied.
4. Start of work with Postman. 
5. Database (marketplace-automation/database.sql) was made.
6. Start of work with Angular. First project was made.
7. Start of work and configure Hibernate.
8. Start of work with Spring Boot. First project was made and setting. 
9. Setting User, Role tables.

## Second week (20.12.21 - 27.12.21)

1. Start of work with Spring MVC. Spring MVC was setting.
2. Tomcat deploy.
3. Purchase controller, repository, service.
4. User controller, repository, service.
5. Front: user CRUD.
6. Front: purchase CRUD.

## Third week(31.12.21 - 07.01.22)

/exam preparing from 03.01.22 to 06.01.22/

1. Spring security introduction .
2. Start of work with Spring security.
3. Start of work with Jwt.
4. Test login and registration controllers were made.
5. Security config.
6. Auth and register controller was made.
7. Structure update.
8. Autowired change.
9. Web config for front.
10. Country, Town entities, repositories were added.
11. Supply, Report entities, repositories, services, controllers were added.
12. Subscription, Storage entities, repositories were added.
13. Front: supply CRUD.
14. Front: report CRUD.
15. Front and back dependency was done.
16. Main page was made with CSS from design.
17. Registration page was made with CSS from design.
18. Login page was made with CSS from design.
19. Purchase, report, supply, user pages were made with CSS from design. 
20. Profile page was made with CSS from design.
21. Information page was made with CSS from design.
22. Spring Security was fixed.
23. Front: Auth was made.
24. Front: Registration was made.

## Forth week(10.01.22 - 17.01.22)

/exam preparing from 07.01.22 to 11.01.22/

1. Front: Validation was made.
2. Dto was made.
3. Hibernate Configuration was changed.
4. Spring Security was changed.
5. New Jwt filters were added.
6. User structure was changed.
7. Role structure was changed.
8. Spring Security filters were fixed.
9. Sales, Orders services were done.
10. Sales, Orders dto were done.