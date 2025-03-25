package com.mytests.spring.springJpaConstructorsInQueries;

import com.mytests.spring.springJpaConstructorsInQueries.repositories.UuidEntityRepo;
import com.mytests.spring.springJpaConstructorsInQueries.repositories.UuidEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaConstructorsInQueriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaConstructorsInQueriesApplication.class, args);
    }
   @Bean
       public CommandLineRunner commandLineRunner(UuidEntityRepo emRepo, UuidEntityRepository jpaRepo) {
           return args -> {
               System.out.println("----------------Class short name in `select new`----------------------");
               emRepo.testClassDtoShortnameConstructor();
               System.out.println("----------------Record short name in `select new`----------------------");
               emRepo.testRecordDtoShortnameConstructor();
               System.out.println("-----------------Class FQN in `select new`---------------------");
               jpaRepo.testClassDtoFqnConstructor().iterator().forEachRemaining(System.out::println);
               System.out.println("-----------------Record FQN in `select new`---------------------");
               jpaRepo.testRecordDtoFqnConstructor().iterator().forEachRemaining(System.out::println);
               System.out.println("-----------------Constructor as constructor parameter---------------------");
               jpaRepo.testConstructorInConstructor().iterator().forEachRemaining(System.out::println);
               System.out.println("-----------------LombokClass in `select new`---------------------");
               jpaRepo.testLombokProjection().iterator().forEachRemaining(System.out::println);
               System.out.println("-----------------Arithmetic operations in DTO constructors-----------------");
               jpaRepo.testArithmeticsOnDouble().iterator().forEachRemaining(System.out::println);
               System.out.println("--entity field and DTO field types strict matching in DTO constructors--");
               jpaRepo.testArithmeticOperationsWithFieldToDtoTypesExplicitMatching(50L).iterator().forEachRemaining(System.out::println);
               System.out.println("--constants as DTO constructor args--");
               jpaRepo.testArithmeticOperationsWithConstants().iterator().forEachRemaining(System.out::println);
               System.out.println("--operations on constants and fields as DTO constructor args--");
               jpaRepo.testArithmeticOperationsWithOperationsOnConstantsAndFields().iterator().forEachRemaining(System.out::println);
               System.out.println("--operations on query parameters as DTO constructor args--");
               jpaRepo.testArithmeticOperationsWithOperationsOnParameters(3, 5L, 2.5, 3f).iterator().forEachRemaining(System.out::println);
           };
       }
}
