package com.gatomalvado.config;

import com.gatomalvado.server.ServerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerConfigObject {
    private String protocols;
    private String ports;
}
