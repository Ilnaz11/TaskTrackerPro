package ru.baymukhametov.TaskTrackerPro.Controller;

import org.springframework.web.bind.annotation.*;
import ru.baymukhametov.TaskTrackerPro.Entity.User;
import ru.baymukhametov.TaskTrackerPro.Service.UserService;
import ru.baymukhametov.TaskTrackerPro.dto.UserRequestDto;
import ru.baymukhametov.TaskTrackerPro.dto.UserResponseDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto createUser(User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public Optional<UserResponseDto> findById(Long id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}/update")
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        return userService.updateUser(id, userRequestDto);
    }


}