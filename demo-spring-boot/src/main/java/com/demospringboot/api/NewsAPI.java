package com.demospringboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demospringboot.api.output.NewsOutput;
import com.demospringboot.dto.NewsDTO;
import com.demospringboot.service.INewsService;

@RestController
public class NewsAPI {

	@Autowired
	private INewsService newsService;

	@GetMapping(value = "/news")
	public NewsOutput displayNews(@RequestParam(value="page", required=false) Integer page, 
								  @RequestParam(value="limit", required=false) Integer limit) {
		NewsOutput result = new NewsOutput();
		if (page != null && limit != null) {
			result.setCurrentPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setTotalPages((int) Math.ceil((double) (newsService.totalItems() / limit)));
			result.setListResults(newsService.findAll(pageable));
		} else {
			result.setListResults(newsService.findAll());
		}
		return result;
	}

	// @RequestMapping(value="/news", method = RequestMethod.POST)
	@PostMapping(value = "/news")
	public NewsDTO createNews(@RequestBody NewsDTO model) {
		return newsService.save(model);
	}

	@PutMapping(value = "/news/{id}")
	public NewsDTO updateNews(@RequestBody NewsDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newsService.save(model);
	}

	@DeleteMapping(value = "/news")
	public void deleteNews(@RequestBody long[] ids) {
		newsService.delete(ids);
	}
}
