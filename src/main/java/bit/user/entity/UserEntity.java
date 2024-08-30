package bit.user.entity;

import bit.user.domain.User;
import bit.user.oauth.OauthPlatformStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String nickName;

    private String gender;

    @Enumerated(EnumType.STRING)
    private OauthPlatformStatus platform;

    private LocalDateTime registerDate;

    public static UserEntity from(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.id = user.getId();
        userEntity.email = user.getEmail();
        userEntity.nickName = user.getNickName();
        userEntity.platform = user.getPlatform();
        userEntity.registerDate = user.getRegisterDate();
        return userEntity;
    }

    public User toModel() {
        return User.builder()
                .id(id)
                .email(email)
                .nickName(nickName)
                .gender(gender)
                .platform(platform)
                .registerDate(registerDate)
                .build();
    }

}
