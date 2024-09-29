package com.mhk.edj;

import com.mhk.edj.entity.Student;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Consumer;

//@SpringBootApplication
public class EosbDataJpaApplication {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres_unit");
    static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

      //  SpringApplication.run(EosbDataJpaApplication.class, args);

                       /* Persistence, (ata akta class, er kaj scroll kre jpa er implementation k k dise khuje ber kore)
                        EntityManagerFactory, // 2nd level cache
                        Entity,
                        EntityManager, // 1st level cache //per entity manager a 1 ta kre transaction thake
                        EntityTransaction,
                        Query,
                        TypedQuery,
                        CriteriaBuilder,
                        CriteriaQuery,*/
        //entity hoi pojo theke, entity object create kre entitymanagefactory theke, entity manage kre entity manager
//database engine er buffer a cache kore , rollback korle fele dei


/*
        try {
            em.getTransaction().begin();

            Student s = new Student();
            s.setName("kabir");
            s.setCgpa(2.86f);

            em.persist(s); //store incache ,not save to db
            if(1==2){
                throw new RuntimeException("ex ....");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
           em.getTransaction().rollback();
           e.printStackTrace();
        }
*/
        transactional((em)->{
            Student s = new Student();
            s.setId(null);
            s.setName("rakib");
            s.setCgpa(3.86f);
            em.persist(s);
           // System.out.println(1/0);
            System.out.println(s);

        });

    }

    static void transactional(Consumer<EntityManager> consumer){

        em.getTransaction().begin();  //before advice
        try {
            consumer.accept(em);
        } catch (Exception e) {
            em.getTransaction().rollback();//after throwing advice
            throw new RuntimeException("Can't save the object");
        }
        em.getTransaction().commit();//after advice
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
