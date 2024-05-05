package com.gatomalvado.server.impl;

import com.gatomalvado.server.IServer;
import lombok.Getter;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Constructor;
import java.util.*;

public class ServerApplicationContext {

    @Getter
    private static final ServerApplicationContext serverConfig = new ServerApplicationContext();

    private Map<String, IServer> serverToNameMap;

    private ServerApplicationContext() {
        synchronized (getClass()){
            serverToNameMap = new HashMap<>();
            List<IServer> instances = new ArrayList<>();
            Reflections reflections = new Reflections("com.gatomalvado.server", new SubTypesScanner(false));

            Set<Class<? extends IServer>> classes = reflections.getSubTypesOf(IServer.class);
            for (Class<? extends IServer> clazz : classes) {
                try {
                    Constructor<? extends IServer> constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true); // Make the constructor accessible
                    IServer instance = constructor.newInstance();
                    instances.add(instance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for(IServer instance: instances){
                serverToNameMap.put(instance.getServerType().getName(), instance);
            }
        }
    }

    public IServer getServer(String name) {
        return serverToNameMap.get(name);
    }
}
