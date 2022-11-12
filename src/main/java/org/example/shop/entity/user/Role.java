package org.example.shop.entity.user;

public enum Role {
    ADMIN,
    USER,
    MANAGER;

    public String getNameWithPrefix() {
        return "ROLE_" + this.name();
    }
}
