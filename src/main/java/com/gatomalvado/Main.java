package com.gatomalvado;

import com.gatomalvado.config.ServerConfigDetails;
import com.gatomalvado.config.ServerConfigObject;
import com.gatomalvado.server.IServer;
import com.gatomalvado.server.ServerType;
import com.gatomalvado.server.impl.ServerApplicationContext;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        startServers();
    }

    private static void startServers() {
        System.out.println("<--------     Starting the servers     ------>");
        ServerConfigDetails serverConfigDetails = loadConfigDetails();
        Map<ServerType, Integer> serverMap = serverConfigDetails.getServerTypes();
        ServerApplicationContext context = ServerApplicationContext.getServerConfig();
        for (ServerType serverType : serverMap.keySet()) {
            IServer server = context.getServer(serverType.getName());
            server.start(serverMap.get(serverType));
        }
    }

    private static ServerConfigDetails loadConfigDetails() {
        ServerConfigObject config = loadConfigFile();
        ServerConfigDetails.init(config);
        return ServerConfigDetails.get();
    }

    private static ServerConfigObject loadConfigFile() {
        Yaml yaml = new Yaml();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("config.yaml");
        ServerConfigObject config = yaml.loadAs(inputStream, ServerConfigObject.class);
        return config;
    }

}