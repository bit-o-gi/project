package bit.user.repository;

import bit.user.domain.User;

public interface UserRepository {
    User save(User user);
}
