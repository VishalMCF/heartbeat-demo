package com.gatomalvado.config;

import com.gatomalvado.server.ServerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerConfigObject {

    private static final String DELIMITER = ", ";

    private String protocol;
    private String ports;
}
