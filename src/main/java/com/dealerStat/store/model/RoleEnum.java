package com.dealerStat.store.model;

public enum RoleEnum {
    ROLE_BLOCKED("ROLE_BLOCKED"),
    ROLE_TRADER("ROLE_TRADER"),
    ROLE_ADMIN("ROLE_ADMIN");
    String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
