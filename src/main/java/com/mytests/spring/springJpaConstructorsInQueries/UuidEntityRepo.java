package com.mytests.spring.springJpaConstructorsInQueries;

import com.mytests.spring.springJpaConstructorsInQueries.dto.ClassProjection;
import com.mytests.spring.springJpaConstructorsInQueries.dto.InnerProjection;
import com.mytests.spring.springJpaConstructorsInQueries.dto.RecordProjection;
import jakarta.persistence.EntityManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class UuidEntityRepo {


    private final EntityManager em;

    public UuidEntityRepo(EntityManager em) {
        this.em = em;
    }

    // https://youtrack.jetbrains.com/issue/IDEA-352849/select-new-with-unqualified-class-name-in-HQL
    public void testClassDtoShortnameConstructor() {
        String query = """
           select new ClassProjection(
           cast(e.foo as java.lang.String),
           cast(e.num1 as java.lang.Integer),
           cast(e.num3 as java.lang.Float),
           cast(e.date1 as java.time.LocalDate),
           cast(e.time1 - e.time2 as java.time.Duration),
           cast(e.num2 as java.lang.Double),
           cast(e.flag2 as java.lang.Boolean)
           ) from UuidEntity e""";
        em.createQuery(query, ClassProjection.class).getResultList().iterator().forEachRemaining(System.out::println);
    }

    public void testRecordDtoShortnameConstructor(){

        String query = "select new RecordProjection(e.num1, e.foo) from UuidEntity e";
        em.createQuery(query, RecordProjection.class).getResultList().iterator().forEachRemaining(System.out::println);

    }


}
