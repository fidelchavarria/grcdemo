package net.grc.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.grc.demo.model.QuerySearch;
import net.grc.demo.service.client.RemoteApiServiceClient;

@RestController
public class HistoricQuerySearchController {

	private static final Logger log = LoggerFactory.getLogger(HistoricQuerySearchController.class);

	@Autowired
	private RemoteApiServiceClient remoteApiService;

	@RequestMapping(value = "/local/search")
	public List<QuerySearch> search(@RequestParam(value = "query", defaultValue = "") String[] query) {
		List<QuerySearch> retlist = remoteApiService.findPostContainingString(query);
		log.info("Found {} result on remote service", retlist.size());
		return retlist;
	}
	
	
}
