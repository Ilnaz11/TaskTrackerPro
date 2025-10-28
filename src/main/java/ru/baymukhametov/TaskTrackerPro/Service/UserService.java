package ru.baymukhametov.TaskTrackerPro.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.User;
import ru.baymukhametov.TaskTrackerPro.dto.UserRequestDto;
import ru.baymukhametov.TaskTrackerPro.dto.UserResponseDto;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    UserResponseDto createUser(User user);
    List<UserResponseDto> getAllUsers();
    void deleteUser(Long id);
    Optional<UserResponseDto> findById(Long id);
    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);
}
//o	создания и удаления сущностей;
//o	поиска по ID;
//o	обновления данных.
