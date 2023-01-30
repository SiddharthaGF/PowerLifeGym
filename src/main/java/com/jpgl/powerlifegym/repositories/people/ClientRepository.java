package com.jpgl.powerlifegym.repositories.people;

import com.jpgl.powerlifegym.models.people.ClientModel;
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

    @Query("SELECT DISTINCT c FROM ClientModel c WHERE c.gender = :genderName")
    List<ClientModel> findByGenderName(@Param("genderName") String genderName);

    @Query("SELECT DISTINCT c FROM ClientModel c WHERE c.cellPhoneNumber = :number")
    List<ClientModel> findByCellphoneNumbersNumber(@Param("number") String number);
    boolean existsByIdOrDni(int id, String dni);

    @Query("SELECT DISTINCT c FROM ClientModel c WHERE c.email LIKE %:email%")
    List<ClientModel> findByEmail(@Param("email") String email);

}
