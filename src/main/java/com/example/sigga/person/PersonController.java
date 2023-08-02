package com.example.sigga.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Através de uma requisição GET, retorna todos
     * as Pessoas cadastradas no banco de dados
     *
     * @return List<Person>
     */
    @GetMapping
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    /**
     * Através de uma requisição POST, é efetuado um inserção ao banco de dados.
     *
     * @param person Person - Pessoa.
     */
    @PostMapping
    public void addNewPerson(@RequestBody Person person){
        personService.addNewStudent(person);
    }

    /**
     * Através de uma requisição DELETE, é efetuado uma exclusão de Pessoa do banco de dados.
     *
     * @param personId Long - Id da Pessoa.
     */
    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long personId){
        personService.deletePerson(personId);
    }

    /**
     * Através de uma requisição PUT, é efetuado uma alteração da Pessoa.
     *
     * @param personId Long - Id da Pessoa.
     * @param person Person - Pessoa.
     */
    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable("personId") Long personId,
            @RequestBody Person person){
        personService.updatePerson(personId, person);
    }
}
