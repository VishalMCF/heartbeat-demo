package com.gatomalvado.server;

public enum ServerType {
    TCP("tcp"),
    UDP("udp");

    private final String name;

    ServerType(String name) {
        this.name = name;
    }
}
