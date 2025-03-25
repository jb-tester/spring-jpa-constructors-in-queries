package com.mytests.spring.springJpaConstructorsInQueries.repositories;

import com.mytests.spring.springJpaConstructorsInQueries.dto.*;
import com.mytests.spring.springJpaConstructorsInQueries.model.UuidEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

    // https://youtrack.jetbrains.com/issue/IDEA-364515
    @Query("select new com.mytests.spring.springJpaConstructorsInQueries.dto.DoubleMapping(e.num2 * 1.5) from UuidEntity e")
    List<DoubleMapping> testArithmeticsOnDouble();

    @Query("""
            select new
            com.mytests.spring.springJpaConstructorsInQueries.dto.OperationsResultsRecordProjection(
            2 * e.num1,  :longArg, 1.5 * e.num2, e.num3 * 10
            ) from UuidEntity e""")
    List<OperationsResultsRecordProjection> testArithmeticOperationsWithFieldToDtoTypesExplicitMatching(@Param("longArg") Long longArg);

    @Query("""
            select new com.mytests.spring.springJpaConstructorsInQueries.dto.OperationsResultsRecordProjection(
            12, 2L, 1e-9d, 123.4f) from UuidEntity
            """)
    List<OperationsResultsRecordProjection> testArithmeticOperationsWithConstants();

    @Query("""
            select new com.mytests.spring.springJpaConstructorsInQueries.dto.OperationsResultsRecordProjection(
            e.num1*12, e.num1*2L, e.num1*1e-9d, e.num1*123.4f) from UuidEntity e
            """)
    List<OperationsResultsRecordProjection> testArithmeticOperationsWithOperationsOnConstantsAndFields();


}