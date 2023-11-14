package com.ads2.conexaobd;

import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ads2.conexaobd.config.Conexao;

@SpringBootApplication
public class ConexaobdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConexaobdApplication.class, args);

	}

}
