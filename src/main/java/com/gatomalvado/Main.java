package com.gatomalvado;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.io.ObjectInputFilter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // please read yaml configs from the resource folder and generate dto classes to store the configurations
        Yaml yaml = new Yaml();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("config.yaml");
        ObjectInputFilter.Config config = yaml.loadAs(inputStream, ObjectInputFilter.Config.class);
    }

}