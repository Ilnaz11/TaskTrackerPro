package ru.baymukhametov.TaskTrackerPro.mapper;

import ru.baymukhametov.TaskTrackerPro.Entity.User;
import ru.baymukhametov.TaskTrackerPro.dto.UserResponseDto;

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
}
