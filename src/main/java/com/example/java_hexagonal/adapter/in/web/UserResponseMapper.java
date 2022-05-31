package com.example.java_hexagonal.adapter.in.web;

import com.example.java_hexagonal.domain.User;
import io.tej.SwaggerCodgen.model.UserResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserResponseMapper {
    UserResponse toResponse(User user);
}
