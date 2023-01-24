package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.ClientModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<ClientModel, Integer> {

    ClientModel findByIdOrDni(int id, String dni);

    List<ClientModel> findByNameContainingOrLastnameContaining(String name, String lastname);

    List<ClientModel> findByDniContaining(String dni);

    @Query("SELECT DISTINCT c FROM GenderModel g INNER JOIN ClientModel c on g.id=c.idGender WHERE g.name=:genderName")
    List<ClientModel> findByGenderName(@Param("genderName") String genderName);

    @Query("SELECT DISTINCT c FROM CellphoneNumberModel cp INNER JOIN ClientModel c ON cp.idClient=c.id WHERE cp.number=:number")
    List<ClientModel> findByCellphoneNumbersNumber(@Param("number") String number);
    boolean existsByIdOrDni(int id, String dni);

    @Query("SELECT DISTINCT c FROM EmailModel e INNER JOIN ClientModel c ON c.id=e.idPerson WHERE e.email LIKE %:email%")
    List<ClientModel> findByEmail(@Param("email") String email);

}
