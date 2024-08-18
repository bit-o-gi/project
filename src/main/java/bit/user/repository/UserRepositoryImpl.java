package bit.user.repository;

import bit.user.domain.User;
import bit.user.entity.UserEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(UserEntity.from(user)).toModel();
    }
}
