package com.gatomalvado.server;

public interface IServer {
    void start(int port);
    ServerType getServerType();
}
