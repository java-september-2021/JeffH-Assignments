package com.jeffh.dojosurvey;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @RequestMapping(path="/results", method=RequestMethod.POST)
    public String login(@RequestParam(value="name") String name, @RequestParam(value="dojo") String dojo, 
    		@RequestParam(value="language") String language, @RequestParam(value="comments") String comments, Model model) {
    	
    	model.addAttribute("name", name);
    	model.addAttribute("dojo", dojo);
    	model.addAttribute("language", language);
    	model.addAttribute("comments", comments);
    	return "results.jsp";
    }

}