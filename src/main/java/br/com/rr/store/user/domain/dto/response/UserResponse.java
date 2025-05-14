package br.com.rr.store.user.domain.dto.response;

import java.time.LocalDate;

public record UserResponse(
        String name,
        String email,
        LocalDate birthDay,
        String phone
) {
}
