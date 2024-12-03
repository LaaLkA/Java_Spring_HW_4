package org.example.java_spring_hw_4.services;

import org.example.java_spring_hw_4.models.User;
import org.example.java_spring_hw_4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис работы с пользователями
 */
@Service
public class UserService {

    /**
     * Поле подключения репозитория пользователей
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Метод получения списка всех пользователей
     * @return лист пользователей
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Метод сохранения пользователя в репозиторифй
     * @param user пользователь для сохранения
     */
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    /**
     * Метод удаления пользователя из репозитория
     * @param id идентификатор пользователя для удаления
     */
    public void deleteUserById(int id) {
        userRepository.deleteUserById(id);
    }

    /**
     * Метод обновления пользователя в репозитории
     * @param user обновлённый пользователь
     */
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    /**
     * Метод поиска пользователя в репозитории по идентификатору
     * @param id идентификатор для поиска
     * @return найденный пользователь
     */
    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }
}
