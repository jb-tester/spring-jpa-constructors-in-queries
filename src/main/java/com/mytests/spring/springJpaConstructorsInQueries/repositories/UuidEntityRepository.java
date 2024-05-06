package com.mytests.spring.springJpaConstructorsInQueries.repositories;

import com.mytests.spring.springJpaConstructorsInQueries.dto.*;
import com.mytests.spring.springJpaConstructorsInQueries.model.UuidEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UuidEntityRepository extends CrudRepository<UuidEntity, UUID> {

   // https://youtrack.jetbrains.com/issue/IDEA-337145
    @Query("select e from com.mytests.spring.springJpaConstructorsInQueries.model.UuidEntity e where e.num1 > e.num2")
    List<UuidEntity> testEntityFQN();

  // doesn't work in @Query annotations, ok in createQuery() methods
  /* @Query("""
           select new ClassProjection(
           cast(e.foo as java.lang.String),
           cast(e.num1 as java.lang.Integer),
           cast(e.num3 as java.lang.Float),
           cast(e.date1 as java.time.LocalDate),
           cast(e.time1 - e.time2 as java.time.Duration),
           cast(e.num2 as java.lang.Double),
           cast(e.flag2 as java.lang.Boolean)
           ) from UuidEntity e""")
   List<ClassProjection> testClassDtoShortnameConstructor();*/

    @Query("""
            select new com.mytests.spring.springJpaConstructorsInQueries.dto.ClassProjection(
            cast(e.foo as java.lang.String),
            cast(e.num1 as java.lang.Integer),
            cast(e.num3 as java.lang.Float),
            cast(e.date1 as java.time.LocalDate),
            cast(e.time1 - e.time2 as java.time.Duration),
            cast(e.num2 as java.lang.Double),
            cast(e.flag2 as java.lang.Boolean)
            ) from UuidEntity e""")
    List<ClassProjection> testClassDtoFqnConstructor();

    // doesn't work really: constructor is not found
    /*
    @Query("select new com.mytests.spring.springJpaConstructorsInQueries.dto.InnerProjection$InnerDTO(e.foo) from UuidEntity e")
    List<InnerProjection.InnerDTO> testInnerClassConstructor();
    */

    // doesn't work in @Query annotations, ok in createQuery() methods
   /* @Query("select new RecordProjection(e.num1, e.foo) from UuidEntity e")
    List<RecordProjection> testRecordDtoShortnameConstructor();*/

    @Query("select new com.mytests.spring.springJpaConstructorsInQueries.dto.RecordProjection(e.num1, e.foo) from UuidEntity e")
    List<RecordProjection> testRecordDtoFqnConstructor();

    // https://youtrack.jetbrains.com/issue/IDEA-353055
    @Query("""
            select
            new com.mytests.spring.springJpaConstructorsInQueries.dto.MainDTO(
              e.num1,
              new com.mytests.spring.springJpaConstructorsInQueries.dto.UsedDTO(e.num2)
            ) from UuidEntity e
            """)
    List<MainDTO> testConstructorInConstructor();

 // https://youtrack.jetbrains.com/issue/IDEA-319502
    @Query("select new com.mytests.spring.springJpaConstructorsInQueries.dto.LombokProjection(e.foo) from UuidEntity e")
    List<LombokProjection> testLombokProjection();

}