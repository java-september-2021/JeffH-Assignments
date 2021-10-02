package com.jeffh.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeffh.codingdojo.models.Dojo;
import com.jeffh.codingdojo.models.Ninja;
import com.jeffh.codingdojo.services.DojoService;
import com.jeffh.codingdojo.services.NinjaService;



@Controller
public class CodingDojoApi {
	
    private final DojoService dojoService;
    private final NinjaService ninjaService;
    public CodingDojoApi(DojoService dojoService, NinjaService ninjaService){
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
    
    @RequestMapping("/")
    public String index(Model model) {
    	List<Dojo> dojos = dojoService.allDojos();
    	model.addAttribute("dojos", dojos);
        return "index.jsp";
    }
    
    @RequestMapping("/dojos/new")
    public String newDojo(Model model) {
    	model.addAttribute("dojo", new Dojo());
        return "dojos/newDojo.jsp";
    }
    
    @RequestMapping(value="/dojos/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "dojos/newDojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/ninjas/new")
    public String newNinja(Model model) {
    	model.addAttribute("ninja", new Ninja());
    	List<Dojo> dojos = dojoService.allDojos();
    	model.addAttribute("dojos", dojos);
        return "ninjas/newNinja.jsp";
    }
    
    @RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "ninjas/newNinja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/dojos/{id}")
    public String dojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        List<Ninja> ninjas = ninjaService.allNinjasByDojo(dojo);
        model.addAttribute("dojo", dojo);
        model.addAttribute("ninjas", ninjas);
        return "/dojos/dojo.jsp";
    }
}
