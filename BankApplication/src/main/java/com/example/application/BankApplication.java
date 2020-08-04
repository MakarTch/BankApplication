package com.example.application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.example.controller","com.example.model","com.example.utility"})
public class BankApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BankApplication.class, args);
		
//		UsersDAOClass.displayAll();
//		System.out.println("Test34234");
//		System.out.println(UsersDAOClass.verification(1, "password"));
		
	}
}
	