package com.example.java_hexagonal.adapter.out.persistence;

import com.example.java_hexagonal.application.port.out.LoadUserPort;
import com.example.java_hexagonal.application.port.out.UpdateUserPort;
import com.example.java_hexagonal.domain.User;
import io.tej.SwaggerCodgen.model.UserRequest;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserPersistenceAdapter implements LoadUserPort, UpdateUserPort {

    private final UserRepository userRepository;

    private final UserEntityMapper mapper;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
        mapper = Mappers.getMapper(UserEntityMapper.class);
    }

    @Override
    public User save(User user) {
        return mapper.toDomain(userRepository.save(mapper.toEntity(user)));
    }

    @Override
    public List<User> loadAll() {
        return userRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

}
