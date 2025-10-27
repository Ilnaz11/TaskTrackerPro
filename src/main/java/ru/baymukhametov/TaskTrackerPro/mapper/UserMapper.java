package ru.baymukhametov.TaskTrackerPro.mapper;

import ru.baymukhametov.TaskTrackerPro.Entity.User;
import ru.baymukhametov.TaskTrackerPro.dto.UserResponseDto;

import java.util.List;

public class UserMapper {

    public UserResponseDto toDto(User user) {
        if (user == null) {
            return null;
        }
        UserResponseDto userResponseDto= new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setName(user.getName());
        userResponseDto.setRole(user.getRole());

        return userResponseDto;

    }
    public List<UserResponseDto> toDtoList(List<User> users) {
        if (users == null) {
            return null;
        }
        return users
                .stream()
                .map(this::toDto)
                .toList();
    }
}
