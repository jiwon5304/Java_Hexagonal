package com.example.java_hexagonal.adapter.in.web;

import com.example.java_hexagonal.domain.User;
import com.ktown4u.gms.company.adapter.in.web.UserResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserResponseMapper {
    UserResponse toResponse(User user);
}
