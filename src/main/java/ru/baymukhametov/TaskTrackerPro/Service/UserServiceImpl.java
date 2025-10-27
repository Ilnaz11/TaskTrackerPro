package ru.baymukhametov.TaskTrackerPro.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.User;
import ru.baymukhametov.TaskTrackerPro.Repository.UserRepository;
import ru.baymukhametov.TaskTrackerPro.dto.UserRequestDto;
import ru.baymukhametov.TaskTrackerPro.dto.UserResponseDto;
import ru.baymukhametov.TaskTrackerPro.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponseDto createUser(User user) {
        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> user = userRepository.findAll();
        return userMapper.toDtoList(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserResponseDto> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        User user1 = user.orElseThrow(() -> new RuntimeException("Not found User id: " + id));

        return user.map(userMapper::toDto);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found User"));
        if (userRequestDto.getEmail() != null) {
            user.setEmail(userRequestDto.getEmail());
        }
        if (userRequestDto.getName() != null) {
            user.setName(userRequestDto.getName());
        }
        if (userRequestDto.getRole() != null) {
            user.setRole(userRequestDto.getRole());
        }

        User updatedUser = userRepository.save(user);

        return userMapper.toDto(updatedUser);
    }
}
