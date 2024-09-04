package bit.user.service;

import bit.user.domain.User;
import bit.user.dto.UserDto;
import bit.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User getById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public boolean findByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public User create(UserDto userDto) {
        return userRepository.save(User.from(userDto));
    }
}
