package com.gatomalvado.config;

import com.gatomalvado.exception.ServerConfigOverrideException;
import com.gatomalvado.server.ServerType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.gatomalvado.common.Constants.DELIMITER;


// will be changed to singleton
public class ServerConfigDetails {
    private static ServerConfigDetails instance;
    private static Map<ServerType, Integer> serverTypes = new HashMap<>();

    public ServerConfigDetails() {
    }

    public static synchronized void init(ServerConfigObject configObject) {
        if (instance == null) {
            instance = new ServerConfigDetails();
            List<ServerType> serverTypeDetails = Arrays.stream(configObject.getProtocols().split(DELIMITER)).map(String::toUpperCase)
                    .map(ServerType::valueOf).toList();
            List<Integer> portDetails = Arrays.stream(configObject.getPorts().split(DELIMITER)).map(Integer::parseInt).toList();
            if (portDetails.size() != serverTypeDetails.size()) {
                throw new IllegalArgumentException("Number of ports and server types do not match");
            }
            serverTypes = IntStream.range(0, serverTypeDetails.size()).boxed().collect(Collectors.toMap(serverTypeDetails::get, portDetails::get));
            System.out.println(serverTypes);
        } else {
            throw new ServerConfigOverrideException("Attempt to override server config was made");
        }
    }

    public Map<ServerType, Integer> getServerTypes() {
        return serverTypes;
    }

    public static synchronized ServerConfigDetails get() {
        if (instance == null) {
            throw new IllegalStateException("Instance not initialized yet. Call init() first.");
        }
        return instance;
    }
}
