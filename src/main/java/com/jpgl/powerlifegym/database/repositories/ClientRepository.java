package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    Client findByIdOrDni(int id, String dni);

    List<Client> findByNameContainingOrLastnameContaining(String name, String lastname);

    List<Client> findByDniContaining(String dni);

    @Query("SELECT DISTINCT c FROM Person p INNER JOIN Gender g ON p.idGender=g.id INNER JOIN Client c ON p.id=c.idPerson WHERE g.name=:genderName")
    List<Client> findByGenderName(@Param("genderName") String genderName);

    @Query("SELECT DISTINCT c FROM Person p INNER JOIN CellphoneNumber cp ON p.id=cp.idPerson INNER JOIN Client c ON p.id=c.idPerson WHERE cp.number=:number")
    List<Client> findByCellphoneNumbersNumber(@Param("number") String number);
    boolean existsByIdOrDni(int id, String dni);

    @Query("SELECT DISTINCT c FROM Person p INNER JOIN Email e ON p.id=e.idPerson INNER JOIN Client c ON p.id=c.idPerson WHERE e.email LIKE %:email%")
    List<Client> findByEmail(@Param("email") String email);
}
