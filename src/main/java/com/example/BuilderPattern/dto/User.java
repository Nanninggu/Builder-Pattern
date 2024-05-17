package com.example.BuilderPattern.dto;

public class User {
    private final String name;
    private final String email;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static class UserBuilder {
        private String name;
        private String email;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
