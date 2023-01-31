package com.jpgl.powerlifegym.services.people;

import com.jpgl.powerlifegym.models.people.ClientModel;
import com.jpgl.powerlifegym.repositories.people.ClientRepository;
import com.jpgl.powerlifegym.validation.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    private ClientModel FormatterData(ClientModel model) {
        model.setDni(PersonValidator.cleanString(model.getDni()));
        model.setEmail(PersonValidator.cleanString(model.getEmail()));
        model.setGender(PersonValidator.cleanString(model.getGender()));
        model.setName(PersonValidator.cleanString(model.getName()));
        model.setLastname(PersonValidator.cleanString(model.getLastname()));
        model.setCellPhoneNumber(PersonValidator.cleanString(model.getCellPhoneNumber()));
        return model;
    }

    private void ValidateClient(ClientModel model) throws Exception {
        model = FormatterData(model);
        if (!PersonValidator.Dni((model.getDni())))
            throw new Exception("Número de cédula no invalido client");
        if (!PersonValidator.NameOrLastname((model.getName())))
            throw new Exception("Nombre no invalido client");
        if (!PersonValidator.NameOrLastname((model.getLastname())))
            throw new Exception("Apellido no invalido client");
        if (!PersonValidator.Birthdate(model.getBirthdate()))
            throw new Exception("Fecha de nacimiento no valida");
        if (!PersonValidator.Gender(model.getGender()))
            throw new Exception("Género no valido");
        if (!PersonValidator.Email(model.getEmail()))
            throw new Exception("Email no valido o ya existe");
        if (!PersonValidator.CellPhoneNumber(model.getCellPhoneNumber()))
            throw new Exception("Numero de telefono no valido o ya existe");

    }

    public List<ClientModel> All(){
        return (List<ClientModel>) repository.findAll();
    }

    public Optional<ClientModel> Find(String idOrDni) {
        int id = 0;
        try {
            id = Integer.parseInt(idOrDni);
        } catch (Exception ex) {
            //
        }
        return Optional.ofNullable(repository.findByIdOrDni(id, idOrDni));
    }

    public List<ClientModel> Find(String dni, String name, String lastname, String gender, String cellphoneNumber, String email, Timestamp birthdate){
        if (dni != null) {
            return repository.findByDniContaining(dni);
        } else if (name != null || lastname != null) {
            return repository.findByNameContainingOrLastnameContaining(name, lastname);
        }
        else if (gender != null) {
            return repository.findByGenderName(gender);
        }
        else if (cellphoneNumber != null) {
            return repository.findByCellphoneNumbersNumber(cellphoneNumber);
        }
        else if (email != null) {
            return repository.findByEmail(email);
        }
        return (List<ClientModel>) repository.findAll();
    }

    public ResponseEntity<?> Update(ClientModel model, int id) {
        model.setId(id);
        return Add(model);
    }

    public ResponseEntity<?> Add(ClientModel model) {
        try {
            //ValidateClient(model);
            return  new ResponseEntity<>(repository.save(model), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public boolean Delete(int id) {
        try {
            Optional<ClientModel> model = Find(String.valueOf(id));
            repository.delete(model.get());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Exists(String idOrDni) {
        int id = 0;
        try {
            id = Integer.parseInt(idOrDni);
        } catch (Exception ex) {
            //;
        }
        return repository.existsByIdOrDni(id, idOrDni);
    }

}
