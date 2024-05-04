package com.gatomalvado.server;

public interface IServer {
    void start();
    ServerType getServerType();
    IServer get();
}
