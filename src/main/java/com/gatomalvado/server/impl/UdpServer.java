package com.gatomalvado.server.impl;

import com.gatomalvado.server.IServer;
import com.gatomalvado.server.ServerType;

public class UdpServer implements IServer {

    private final ServerType serverType = ServerType.UDP;

    private final static UdpServer INSTANCE = new UdpServer();

    private UdpServer() {
    }

    @Override
    public ServerType getServerType() {
        return serverType;
    }

    @Override
    public UdpServer get(){
        return INSTANCE;
    }

    @Override
    public void start() {
        System.out.println("Multi threaded UDP server started");
    }
}
