package com.gatomalvado.server.impl;

import com.gatomalvado.server.IServer;

import java.util.HashMap;
import java.util.Map;

public class ServerApplicationContext {
    private static final ServerApplicationContext serverConfig = new ServerApplicationContext();

    private final Map<String, IServer> serverToNameMap = new HashMap<>();

    private ServerApplicationContext() {}

    public ServerApplicationContext getServerConfig() {
        return serverConfig;
    }

    public IServer getServer(String name) {
        return serverToNameMap.get(name);
    }
}
