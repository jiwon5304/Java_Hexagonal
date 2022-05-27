package com.example.java_hexagonal.adapter.out.persistence;

import com.example.java_hexagonal.application.port.out.LoadUserPort;
import com.example.java_hexagonal.application.port.out.UpdateUserPort;
import com.example.java_hexagonal.domain.User;
import io.tej.SwaggerCodgen.model.UserRequest;
import org.springframework.stereotype.Repository;

@Repository
public class UserPersistenceAdapter implements LoadUserPort, UpdateUserPort {

    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        UserEntity e =  userRepository.save(userEntity);

        return User.of(
                e.getName(),
                e.getPassword()
        );
    }
}
