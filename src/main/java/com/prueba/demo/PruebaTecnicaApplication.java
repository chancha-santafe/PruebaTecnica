package com.prueba.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.prueba.demo.servlet")
public class PruebaTecnicaApplication {

  public static void main(String[] args) {
    SpringApplication.run(PruebaTecnicaApplication.class, args);
  }

}
