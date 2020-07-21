# webstatistics_backend
REST-service to get some web statistics from a site

Description in English:
It is required to implement a REST service for collecting website traffic statistics. The service must support two methods:
1. Creation of an event of visiting the site by the user. Parameters:
a. User ID
b. Site page ID
The response should contain (in JSON format):
a. The total number of visits for the current day
b. The number of unique users for the current day
2. Obtaining statistics of visits for an arbitrary period. Request parameter:
a. accounting period
The response should contain (in JSON format):
a. The total number of visits for the specified period
b. The number of unique users for the specified period
c. The number of regular users for the specified period (users who viewed at least 10 different pages during the period).
Any DBMS can be used as information storage.
Service authorization is not required.

Описание на русском:
Требуется реализовать REST-сервис по сбору статистики посещаемости WEB-сайта. Сервис должен поддерживать два метода:
1.	Создание события посещения сайта пользователем. Параметры:
a.	Идентификатор пользователя
b.	Идентификатор страницы сайта
Ответ должен содержать (в формате JSON):
a.	Общее количество посещений за текущие сутки
b.	Количество уникальных пользователей за текущие сутки
2.	Получение статистики посещения за произвольный период. Параметр запроса: 
a.	период  учёта 
Ответ должен содержать (в формате JSON):
a.	Общее количество посещений за указанный период
b.	Количество уникальных пользователей за указанный период
c.	Количество постоянных пользователей за указанный период (пользователей, которые за период просмотрели не менее 10 различных страниц).
В качестве хранилища информации можно использовать любую СУБД. 
Авторизации в сервисе не требуется.

