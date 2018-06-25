package crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import crudapp.model.Person;
import crudapp.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public String index(Model model) {
        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons); 
        return "index";
    }

    @GetMapping("new")
    public String newPerson(Model model) {
        return "new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
    	Person person = personService.findOne(id);
        model.addAttribute("person", person);
        return "edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
    	Person person = personService.findOne(id);
        model.addAttribute("person", person);
        return "show";
    }

    @PostMapping
    public String create(@ModelAttribute Person person) {
    	personService.save(person);
        return "redirect:/persons";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Person person) {
    	person.setId(id);
        personService.save(person);
        return "redirect:/persons";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
    	personService.delete(id);
        return "redirect:/persons";
    }
}
