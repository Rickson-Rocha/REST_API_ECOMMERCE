package br.com.rr.store.user.domain.mapper;

import br.com.rr.store.user.domain.dto.request.UserRequest;
import br.com.rr.store.user.domain.dto.response.UserResponse;
import br.com.rr.store.user.domain.entity.User;

public class UserMapper {
    public static User toEntity(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.name());
        user.setPhone(userRequest.phone());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        return user;

    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getName(),
                user.getEmail(),
                user.getBirthday(),
                user.getPhone()
        );
    }

}
