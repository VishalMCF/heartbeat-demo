package com.gatomalvado.server.impl;

import com.gatomalvado.server.IServer;
import com.gatomalvado.server.ServerType;


public class TcpServer implements IServer {

    private final ServerType serverType = ServerType.TCP;

    private TcpServer(){
    }

    @Override
    public ServerType getServerType() {
        return serverType;
    }

    @Override
    public void start(int port) {
        System.out.println("Multi threaded TCP server started on port --> "+port);
    }
}
