package org.example.java_spring_hw_4.controllers;

import org.example.java_spring_hw_4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.example.java_spring_hw_4.models.User;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер
 */
@Controller
public class UserController {
    /**
     * Поле подключения сервиса для работы с пользователями
     */
    private final UserService userService;

    /**
     * Конструктор с НЕЗАЦИСИМОЙ (@Autowired) инъекцией сервиса для работы с пользователями
     * @param userService сервис для работы с пользователями
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Метод отображения домашней страницы
     * @return название html-файла домашней страницы
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /**
     * Метод отображения страницы со всеми пользователями
     * @param model класс для передачи данных в представление
     * @return название html-файла страницы со списком пользователей
     */
    @GetMapping("/users")
    public String findAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users-list";
    }

    /**
     * Метод отображения страницы с созданием нового пользователя
     * @param model класс для передачи данных в представление
     * @return название html-файла страницы с созданием нового пользователя
     */
    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-create";
    }

    /**
     * Метод создания пользователя из пользователя полученного с тела html-страницы
     * @param user полученный пользователь
     * @return путь на обновлённую страницу со списком пользователей
     */
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Метод удаления пользователя по идентификатору
     * @param id идентификатор для удаления
     * @return путь на обновлённую страницу со списком пользователей
     */
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    /**
     * Метод изменения пользователя
     * @param id идентификатор изменяемого пользователя
     * @param model класс для передачи данных в представление
     * @return название html-файла страницы с изменением пользователя
     */
    @GetMapping("/user-update")
    public String updateUser(@RequestParam int id, Model model) {
        User user = userService.findUserById(id);
        if (user == null) {
            return "redirect:/users";
        }
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * Метод изменения пользователя в БД
     * @param user изменённый пользователь
     * @return путь на обновлённую страницу со списком пользователей
     */
    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
