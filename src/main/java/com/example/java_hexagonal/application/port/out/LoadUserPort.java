package com.example.java_hexagonal.application.port.out;

import com.example.java_hexagonal.domain.User;
import java.util.List;

public interface LoadUserPort {
    List<User> loadAll();
}
