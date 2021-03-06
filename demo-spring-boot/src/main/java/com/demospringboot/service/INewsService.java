package com.demospringboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.demospringboot.dto.NewsDTO;

public interface INewsService {
	NewsDTO save(NewsDTO newsDTO);
	//NewsDTO update(NewsDTO newsDTO);
	void delete(long[] ids);
	List<NewsDTO> findAll(Pageable pageable);
	List<NewsDTO> findAll();
	int totalItems();
}
