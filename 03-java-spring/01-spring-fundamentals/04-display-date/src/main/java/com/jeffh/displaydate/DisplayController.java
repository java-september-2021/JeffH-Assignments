package com.jeffh.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DisplayController {
	Date date = new Date();
	
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @RequestMapping("/date")
    public String date(Model model) {
    	model.addAttribute("day", new SimpleDateFormat("EEEEE").format(date));
    	model.addAttribute("dayNumber", new SimpleDateFormat("dd").format(date));
    	model.addAttribute("month", new SimpleDateFormat("MMMMM").format(date));
    	model.addAttribute("year", new SimpleDateFormat("yyyy").format(date));
        return "date.jsp";
    }
    
    @RequestMapping("/time")
    public String time(Model model) {
    	model.addAttribute("hour", new SimpleDateFormat("hh").format(date));
    	model.addAttribute("minute", new SimpleDateFormat("mm").format(date));
    	model.addAttribute("ampm", new SimpleDateFormat("aa").format(date));
        return "time.jsp";
    }
}
