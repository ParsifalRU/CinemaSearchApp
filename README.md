CinemaSearchAPP
-
Это приложение предназначено для поиска фильмов и получения информации по ним
Состоит из двух страниц: 
1. Страница со списком всех фильмов
2. Страница отдельного фильма

На странице со списком всех фильмов:
- 
- Отображается список фильмов и сериалов
- Реализована пагинация
- Можно отфильтровать выдачу по году, стране и возрастному рейтингу
- Реализован поиск по названию фильма
- Можно перейти на страницу фильма из выдачи
 Также реализован
- Поиск будет осуществляться не при каждом вводе символа, а в момент когда с ввода последнего символа прошла 1 секунда (debounce)

На странице с отдельным фильмом:
-
- Отображается информация о фильме или сериале, в том числе
 название фильма/сериала
 описание
 рейтинг
 отзывы
 постеры
- В случае, если какой-то из списков пустой (список отзывов, актёров, сезонов), реализовано отображение заглушки «нет информации» для описания и скрывается список, если данных нет
- Реализована кнопка «назад», которая ведет на выдачу. Фильтры и номер страницы при этом должны сохраняться.

Использованные компоненты: 
Язык: kotlin
Работа с сетью: Retrofit, OkHttp
Многопоточность: Kotlin Coroutines/Flow
View: XML
Сериализаторы: Kotlinx Serialization, Gson
Навигация: Activity, Fragment, Jetpack Navigation
Архитектура: MVI

Также использованы:
Dagger
Использование чистой архитектуры

Инструкция по установке:
1. скачать приложение через zip архив ниже (Токен встроен)

2. скачать себе проект/вставить токен в CinemaSearchApp/celebrity/network/src/main/java/okhttp/ApiSetting в константу "token"

Пару моих слов о проекте: 
Построил многомодульный проект на MVI с упором на будущее расширение. Хотел вас удивить, но из-за этого не успел сделать весь функционал из дополнительного, надеюсь вы оцените реализацию проекта.
На ввод текста установлена задержка 1 сек, на пагинацию вперед и назад 1.5 сек

Some screenshots:
-
<img align="center" src="https://github.com/ParsifalRU/CinemaSearchApp/assets/109204462/82abde04-bbb4-4c7e-85d1-89db29ce1787.png" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/CinemaSearchApp/assets/109204462/d3fbd897-51d7-4335-b25b-9088d03960bd" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/CinemaSearchApp/assets/109204462/ad4598a8-578b-40c3-ab35-682c0563e8a8.png" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/CinemaSearchApp/assets/109204462/494baf2a-7c0f-4119-b723-b5c0fd80fabc.png" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/CinemaSearchApp/assets/109204462/c961ac0f-586a-493c-b00b-efd6cd3d18d3png" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/CinemaSearchApp/assets/109204462/4a63b74b-b9e5-4d2d-bba2-302eb111cd20.png" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/CinemaSearchApp/assets/109204462/d528f656-5112-4f85-a2a2-1d08f2c4e338.png" height="400" /></a>

How to install:
-
[debug.zip](https://github.com/ParsifalRU/CinemaSearchApp/files/14970916/debug.zip)
