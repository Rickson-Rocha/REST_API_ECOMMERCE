package br.com.rr.store.user.domain.service;


import br.com.rr.store.exception.exceptions.ResourceNotFoundException;
import br.com.rr.store.user.domain.dto.response.UserResponse;
import br.com.rr.store.user.domain.entity.User;
import br.com.rr.store.user.domain.mapper.UserMapper;
import br.com.rr.store.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
    }

    public UserResponse findById(Long id) {
        User user = findUserByIdOrThrow(id);
        return UserMapper.toResponse(user);
    }


    private User findUserByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado! id: " + id
                ));
    }

}
