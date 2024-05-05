package com.gatomalvado.server;

public enum ServerType {
    TCP("TCP"),
    UDP("UDP");

    private final String name;

    ServerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
