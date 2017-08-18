package net.grc.demo.view.controller;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	private List<QuerySearch> list = new LinkedList<QuerySearch>() ;
	
	@RequestMapping("/")
    public String home(Model model) throws Exception {
		model.addAttribute("querySearch", list);
        return "index";
    }
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, @RequestParam(value = "query", defaultValue = "") String[] query) throws Exception {
		print(query);
		list.addAll(localApiService.findByQuery(query));
        model.addAttribute("querySearch", list);
        return "index";
    }
	
	private void print(String[] strings) {
		for (String s :strings)
			 log.info(s);
	}
}

