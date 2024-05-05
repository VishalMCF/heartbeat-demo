package com.gatomalvado.server.impl;

import com.gatomalvado.server.IServer;
import com.gatomalvado.server.ServerType;

public class UdpServer implements IServer {

    private final ServerType serverType = ServerType.UDP;

    private UdpServer() {
    }

    @Override
    public ServerType getServerType() {
        return serverType;
    }

    @Override
    public void start(int port) {
        System.out.println("Multi threaded UDP server started on port --> "+port);
    }
}
