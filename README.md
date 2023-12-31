[![Java CI with Gradle](https://github.com/KleoVor/Selenide/actions/workflows/gradle.yml/badge.svg)](https://github.com/KleoVor/Selenide/actions/workflows/gradle.yml)

# Задача №1: заказ доставки карты
Вам необходимо автоматизировать тестирование формы заказа доставки карты:

![image](https://github.com/KleoVor/Selenide/assets/121848826/2723873a-8360-4a97-ba09-bcac50da3698)

Требования к содержимому полей:

Город — один из административных центров субъектов РФ.
Дата — не ранее трёх дней с текущей даты.
В поле фамилии и имени разрешены только русские буквы, дефисы и пробелы.
В поле телефона — только 11 цифр, символ + на первом месте.
Флажок согласия должен быть выставлен.
Тестируемая функциональность: отправка формы.

Поля «Город» и «Дата» заполняются через прямой ввод значений без использования выбора из выпадающего списка и всплывающего календаря.

Условия: если все поля заполнены корректно, то форма переходит в состояние загрузки:

![image](https://github.com/KleoVor/Selenide/assets/121848826/8bf23f45-2dfd-45d3-8bf0-7e5a43558d37)

Важно: состояние загрузки не должно длиться более 15 секунд.

После успешной отправки формы появится всплывающее окно об успешном завершении бронирования:

![image](https://github.com/KleoVor/Selenide/assets/121848826/ac5d50ce-8aeb-4eab-bbca-2b5e95737c73)

Вам необходимо самостоятельно изучить элементы на странице, чтобы подобрать правильные селекторы. 
Обратите внимание, что элементы могут быть как скрыты, так и динамически добавляться или удаляться из DOM.


# Задача №2: взаимодействие с комплексными элементами (необязательная)
Большинство систем старается помогать пользователям ускорить выполнение операций: для этого предоставляются формы с автодополнением и элементы вроде календарей.

Проверьте отправку формы, используя следующие условия:

Ввод двух букв в поле «Город», после чего выбор нужного города из выпадающего списка:

![image](https://github.com/KleoVor/Selenide/assets/121848826/9d9f9d80-51bb-4a76-bc1f-849d88406b7b)

#### Важно: предлагаемая вам задача действительно сложная и потребует от вас достаточно много усилий для решения. Именно поэтому мы перенесли её в разряд необязательных.

P.S. Стоит отметить, что перед автоматизацией вы должны попробовать оценить стоимость автоматизации, в неё же входит и сложность. Но оценивать вы не научитесь, не попробовав автоматизировать.

