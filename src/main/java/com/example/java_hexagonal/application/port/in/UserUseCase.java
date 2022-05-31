package com.example.java_hexagonal.application.port.in;

import com.example.java_hexagonal.domain.User;
import io.tej.SwaggerCodgen.model.UserRequest;
import java.util.List;

public interface UserUseCase {

     // 회원 생성
     User createUser(UserRequest userRequest);

     List<User> getUsers();

     User getUserById(Long id);

     User updateUser(Long id, UserRequest userRequest);

     void deleteUser(Long id);
}
