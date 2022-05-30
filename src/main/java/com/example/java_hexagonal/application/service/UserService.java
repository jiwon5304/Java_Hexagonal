package com.example.java_hexagonal.application.service;

import com.example.java_hexagonal.adapter.out.persistence.UserEntity;
import com.example.java_hexagonal.application.port.in.UserUseCase;
import com.example.java_hexagonal.application.port.out.LoadUserPort;
import com.example.java_hexagonal.application.port.out.UpdateUserPort;
import com.example.java_hexagonal.domain.User;
import io.tej.SwaggerCodgen.model.UserRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import java.util.List;

@Service
public class UserService implements UserUseCase {

    private final UpdateUserPort updateUserPort;
    private final LoadUserPort loadUserPort;

    public UserService(UpdateUserPort updateUserPort, LoadUserPort loadUserPort) {
        this.updateUserPort = updateUserPort;
        this.loadUserPort = loadUserPort;
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User user = User.of(userRequest.getName(), userRequest.getPassword());
        return updateUserPort.save(user);
    }

    @Override
    public List<User> getUsers() {
        return loadUserPort.loadAll();
    }

    @Override
    public User getUserById(Long id) {
        return updateUserPort.findById(id);
    }

}
