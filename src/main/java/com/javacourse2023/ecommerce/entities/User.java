package com.javacourse2023.ecommerce.entities;

import com.javacourse2023.ecommerce.entities.base.BaseEntity;
import com.javacourse2023.ecommerce.entities.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {

    private String email;
    private String password;
    private UserRole role;
    private String name;

    @ManyToMany
    private List<Product> products;

}
