package com.example.bab_recipes.Domain;

import com.nimbusds.oauth2.sdk.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "User")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Setter
    @Column(name = "userEmail", nullable = false, length = 100)
    private String userEmail;

    @Column(name = "userName", nullable = false, length = 100)
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getRoleKey(){
        return this.role.toString();
    }

    @Getter
    @RequiredArgsConstructor
    public enum Role {

        GUEST("ROLE_GUEST", "비회원"),
        USER("ROLE_USER", "회원");

        private final String key;
        private final String value;
    }

    public static User setUser(Long userId, String userName, String userEmail, Role role) {
        User user = new User();
        user.userId = userId;
        user.userName = userName;
        user.userEmail = userEmail;
        user.role = role;
        return user;

    }
}
