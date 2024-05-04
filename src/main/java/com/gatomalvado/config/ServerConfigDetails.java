package com.gatomalvado.config;

import com.gatomalvado.server.ServerType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ServerConfigDetails {
    private Map<Integer, ServerType> serverTypes = new HashMap<>();

    private static final String DELIMITER = ", ";

    public ServerConfigDetails(ServerConfigObject configObject) {
        try {
            List<ServerType> serverTypeDetails = Arrays.stream(configObject.getProtocol().split(DELIMITER)).map(ServerType::valueOf).toList();
            List<Integer> portDetails = Arrays.stream(configObject.getPorts().split(DELIMITER)).map(Integer::parseInt).toList();
            if(portDetails.size() != serverTypeDetails.size()){
                throw new IllegalArgumentException("Number of ports and server types do not match");
            }
            serverTypes = IntStream.range(0, serverTypeDetails.size()).boxed().collect(Collectors.toMap(portDetails::get, serverTypeDetails::get));
        } catch (Exception exc) {

        }
    }

    public synchronized Map<Integer, ServerType> getServerTypes() {
        return serverTypes;
    }
}
