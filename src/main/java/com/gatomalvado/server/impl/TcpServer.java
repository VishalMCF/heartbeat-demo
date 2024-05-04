package com.gatomalvado.server.impl;

import com.gatomalvado.server.IServer;
import com.gatomalvado.server.ServerType;


public class TcpServer implements IServer {

    private final ServerType serverType = ServerType.TCP;

    private final static TcpServer INSTANCE = new TcpServer();

    private TcpServer(){
    }

    @Override
    public IServer get(){
        return INSTANCE;
    }

    @Override
    public ServerType getServerType() {
        return serverType;
    }

    @Override
    public void start() {
        System.out.println("Multi threaded TCP server started");
    }
}
