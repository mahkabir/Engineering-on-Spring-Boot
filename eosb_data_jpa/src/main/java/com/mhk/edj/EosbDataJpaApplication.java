package com.mhk.edj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EosbDataJpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EosbDataJpaApplication.class, args);
    }

}
/*
JDBC --->   PgSQLDriver
            MySQlDriver
            OracleSqlDriver
JPA-->  Hibernate
        EclipsLink             ---> JDBC --> PgSqlDriver
        Apache Open Jpa

Spring Data Jpa -> Jpa ->  Hibernate
                           EclipsLink             ---> JDBC    --> PgSqlDriver
                           Apache Open Jpa
        */
