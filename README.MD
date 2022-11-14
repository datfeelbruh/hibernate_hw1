Написать Java приложение, используя hibernate
1.1. Создать таблицу user - поля id, name (уникальный, не нулевой), password (не нулевой), created_at (дата время)
1.2. Создать таблицу post - поля id, text (не нулевой), created_at (дата время), user_id (не нулевой)
1.3. Создать таблицу comment - поля id, text, post_id (не нулевой), user_id (не нулевой), created_at (дата время)
Подумать про связи у этих таблиц.
Сделать InstDao в котором будут реализовано добавление записей с помощью hibernate