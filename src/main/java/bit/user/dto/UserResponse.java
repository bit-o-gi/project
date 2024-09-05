package bit.user.dto;

import bit.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {
    private final String email;
    private final String nickName;

    @Builder
    public UserResponse(String email, String nickName) {
        this.email = email;
        this.nickName = nickName;
    }

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .email(user.getEmail())
                .nickName(user.getNickName())
                .build();
    }
}
