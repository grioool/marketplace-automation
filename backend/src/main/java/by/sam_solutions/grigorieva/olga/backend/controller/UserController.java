package by.sam_solutions.grigorieva.olga.backend.controller;

import java.util.List;

import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)


    public List<User> getUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "users/{userId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public User getUser(@PathVariable("userId") Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/user",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @RequestMapping(value = "/user",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/user/{userId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void delete(@PathVariable("userId") int id) {
        userService.delete(id);
    }

}