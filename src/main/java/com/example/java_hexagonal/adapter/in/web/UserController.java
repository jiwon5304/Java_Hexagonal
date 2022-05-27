package com.example.java_hexagonal.adapter.in.web;

import com.example.java_hexagonal.adapter.out.persistence.UserEntity;
import com.example.java_hexagonal.application.port.in.UserUseCase;
import com.example.java_hexagonal.domain.User;
import io.tej.SwaggerCodgen.api.UsersApi;
import io.tej.SwaggerCodgen.model.UserRequest;
import io.tej.SwaggerCodgen.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UsersApi {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    // toResponse 메소드 생성
    private UserResponse toResponse(User user) {
        return Mappers.getMapper(UserResponseMapper.class).toResponse(user);
    }

    // 회원 생성
    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
        User user = userUseCase.createUser(userRequest);
        return ResponseEntity.ok(toResponse(user));
    }
}
