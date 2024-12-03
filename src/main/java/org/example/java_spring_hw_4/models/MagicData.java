package org.example.java_spring_hw_4.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс формирования sql запросов
 */
@Component
public class MagicData {
    /**
     * Поле для подключения таблицы
     */
    @Value("${data.sql.table}")
    private String table = "userTable";

    /**
     * Поле с коллекцией наименований столбцов
     */
    private final List<String> columns = new ArrayList<>(Arrays.asList("id", "firstName", "lastName"));

    /**
     * Поле sql запроса получения всех пользователей из таблицы
     * SELECT * FROM
     */
    @Value("${data.sql.users.getAll}")
    private String getAll;

    /**
     * Поле sql запроса сохранения пользователя в таблицу
     * INSERT INTO
     */
    @Value("${data.sql.users.save}")
    private String save;

    /**
     * Поле sql запроса удаления пользователя по идентификатору
     * DELETE FROM
     */
    @Value("${data.sql.users.delete}")
    private String delete;

    /**
     * Поле sql запроса обновления пользователя по идентификатору
     */
    @Value("${data.sql.users.update}")
    private String update;

    /**
     * Метод получения sql запроса показать всех пользователей в таблице
     * @return sql запрос
     */
    public String getSqlAllUsers() {
        return String.format("%s %s",
                getAll,
                table);
    }

    /**
     * Метод получения sql сохранить пользователя в таблицу
     * @return sql запрос
     */
    public String getSqlSaveUser() {
        return String.format("%s %s (%s, %s) VALUES (?, ?)",
                save,
                table,
                columns.get(1),
                columns.get(2));
    }

    /**
     * Метод получения sql запроса удалить пользователя из таблицы по идентификатору
     * @return sql запрос
     */
    public String getSqlDeleteUser() {
        return String.format("%s %s WHERE %s = ?",
                delete,
                table,
                columns.get(0));
    }

    /**
     * Метод получения sql запроса обновить пользователя в таблице
     * @return sql запрос
     */
    public String getSqlUpdateUser() {
        return String.format("%s %s SET %s = ?, %s = ? WHERE %s = ?",
                update,
                table,
                columns.get(1),
                columns.get(2),
                columns.get(0));
    }

    /**
     * Метод получения sql запроса найти пользователя в таблице по идентификатору
     * @return sql запрос
     */
    public String getSqlFindByIdUser() {
        return String.format("%s %s WHERE %s = ?",
                getAll,
                table,
                columns.get(0));
    }
}
