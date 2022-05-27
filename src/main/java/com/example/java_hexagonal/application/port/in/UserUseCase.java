package com.example.java_hexagonal.application.port.in;

import com.example.java_hexagonal.domain.User;
import io.tej.SwaggerCodgen.model.UserRequest;

public interface UserUseCase {

     // 회원 생성
     User createUser(UserRequest userRequest);
}
