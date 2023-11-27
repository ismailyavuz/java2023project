package com.javacourse2023.ecommerce.security;

import org.springframework.stereotype.Service;

@Service
public class ExampleAuthServiceImpl implements ExampleAuthService {
    @Override
    public long getCurrentUserId() {
        return 1L;
    }
}
