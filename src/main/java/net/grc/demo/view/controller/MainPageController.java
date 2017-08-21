package net.grc.demo.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.grc.demo.model.QuerySearch;
import net.grc.demo.service.client.LocalApiServiceClient;

@Controller
public class MainPageController {

	private static final Logger log = LoggerFactory.getLogger(MainPageController.class);
	
	@Autowired
	private LocalApiServiceClient localApiService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) throws Exception {
		List<QuerySearch> list = new ArrayList<QuerySearch>(localApiService.findLocalHistory());
		model.addAttribute("querySearch", list);
        return "index";
    }
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, @RequestParam(value = "query", defaultValue = "") String[] query) throws Exception {
		List<QuerySearch> list = new ArrayList<QuerySearch>();
		if (query.length >=1) {
			print(query);
			list.addAll(localApiService.findByQuery(query));
	        model.addAttribute("querySearch", list);
		} else {
			list.addAll(localApiService.findLocalHistory());
			 model.addAttribute("querySearch", list);
		}
		
        return "index";
    }
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public String delete(Model model, @RequestParam(value = "delete") String id) throws Exception {
		log.info("Deleting querySearch with Id ["+ id+ "]");
		if (!StringUtils.isEmpty(id))
			localApiService.deleteById(Long.valueOf(id));
		
		List<QuerySearch> list = new ArrayList<QuerySearch>(localApiService.findLocalHistory());
		model.addAttribute("querySearch", list);
        return "index";
    }
	
	private void print(String[] strings) {
		for (String s :strings)
			 log.info(s);
	}
}

