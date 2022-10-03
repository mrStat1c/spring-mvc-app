package ru.amelin.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.amelin.mvc.dao.PersonDAO;

@Controller
@RequestMapping("/batch-update")
public class BatchController {

    public final PersonDAO personDAO;

    @Autowired
    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(){
        return "batch/index";
    }

    @GetMapping("with-batch-update")
    public String withBatchUpdate(){
        personDAO.batchUpdate();
        return "redirect:/people";
    }

}
