package org.example.java_spring_hw_4.repositories;

import org.example.java_spring_hw_4.models.MagicData;
import org.example.java_spring_hw_4.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    /**
     * Поле подключения драйвера для БД
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Поле подключения утилиты RowMapper
     */
    @Autowired
    private RowMapper<User> userRowMapper;

    /**
     * Поле подключения класса MagicData, где хранятся заготовки sql запросов
     */
    @Autowired
    private MagicData sqlData;

    /**
     * Метод получения всех пользователей из БД
     *
     * @return список пользователей
     */
    public List<User> findAll() {
        return jdbcTemplate.query(sqlData.getSqlAllUsers(),
                userRowMapper);
    }

    /**
     * Метод сохранения пользователя в БД
     *
     * @param user пользователь для сохранения
     */
    public void saveUser(User user) {
        jdbcTemplate.update(sqlData.getSqlSaveUser(),
                user.getFirstName(),
                user.getLastName());
    }

    /**
     * Метод удаления пользователя из БД
     *
     * @param id идентификатор пользователя для удаления
     */
    public void deleteUserById(int id) {
        jdbcTemplate.update(sqlData.getSqlDeleteUser(),
                id);
    }

    /**
     * Метод обновления пользователя в БД
     *
     * @param user обновлённый пользователь
     */
    public void updateUser(User user) {
        jdbcTemplate.update(sqlData.getSqlUpdateUser(),
                user.getFirstName(),
                user.getLastName(),
                user.getId());
    }

    /**
     * Метод поиска пользователя по идентификатору
     *
     * @param id идентификатор для поиска
     * @return найденный объект пользователя в БД
     */
    public User findUserById(int id) {
        return jdbcTemplate.queryForObject(sqlData.getSqlFindByIdUser(),
                userRowMapper,
                id);
    }
}
