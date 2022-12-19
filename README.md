## УСЛОВИЕ ЗАДАЧИ: 

Необходимо реализовать консольное CRUD приложение, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:
Developer (id, firstName, lastName, List<Skill> skills, Specialty specialty)
Skill
Specialty
Status (enum ACTIVE, DELETED)
# Требования:
Все CRUD операции для каждой из сущностей
Придерживаться подхода MVC
Для сборки проекта использовать Maven
Для взаимодействия с БД - Hibernate
Для конфигурирования Hibernate - аннотации
Инициализация БД должна быть реализована с помощью flyway
Сервисный слой приложения должен быть покрыт юнит тестами (junit + mockito)
Результатом выполнения задания должен быть репозиторий на github. Технологии: Java, PostgreSQL, Hibernate, Flyway, Maven.

## Инструкция по запуску приложения:

1. Предварительно убедитесь, что на вашем компьютере установлены JVM, JRE, PostgreSql, Hibernate, Maven, FlyWay, JUnit, Mockito.
2. Скачать программу CRUDAPP.jar по ссылке https://github.com/BogdanYanushkevich/Java_CRUD_3.0/raw/master/Java_CRUD_3.0.jar                                                                                                                                                                
3. Вызвать командную строку сочетанием клавиш WIN+R.
4. Прописать в командной строке: cd пробел и путь к папке со скачанной программой + Enter (пример: C:\Users\...\Java_CRUD_3.0)
5. Запустить программу, прописав в командной строке: java -jar CRUD_3.0.jar
