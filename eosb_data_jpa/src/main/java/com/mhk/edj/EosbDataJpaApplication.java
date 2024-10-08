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
        /*
        transient state
        persistence state/  managed state
        detach state
        removed state
         */
//transaction jokhn shuru hoi data gula tokhn buffer/pool ba cache  a thake commit er aghe
        transactional((em)->{
          /*  Student s = new Student();
            s.setId(null);
            s.setName("abir");
            s.setCgpa(2.76f);
            em.persist(s);
           // System.out.println(1/0);
            System.out.println(s);*/
         //   --------------------------------------//
           /* Student s = new Student();
            s.setId(null);
            s.setName("arif");    //----> transient state  ai obostai db er sathe shomporko nai
            s.setCgpa(3.11f);                              // ------> transition (state change)
            em.persist(s);   // persistence state   persisent contex a ase cache a ase
            s.setCgpa(3.00f);  // db te store hbe  3.00, jehetu commit hoinai, persistence contex a thakle ja change hbe setai final hye db te jabe commit er agh porjontoh
*/
       //--------------------detach-----------------------//
            Student s = new Student();
            s.setId(15);
            s.setName("karim");
            s.setCgpa(4.23f);
            em.persist(s);
            em.detach(s);// aikhane detach dewai persistence state theke detach a chole jawar ktha, kintu merge na dileo detach state theke keno commit korle store hcce db te ?

            //------------------//



        });

    }

    static void transactional(Consumer<EntityManager> consumer){

        em.getTransaction().begin();  //before advice
        try {
            consumer.accept(em); //pointcut
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
//adddddddddddffffffffffffffff