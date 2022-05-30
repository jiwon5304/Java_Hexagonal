package com.example.java_hexagonal.application.port.out;

import com.example.java_hexagonal.domain.User;

public interface UpdateUserPort {
    User save(User user);

    User findById(Long id);

    User update(User user);
}
