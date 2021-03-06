package com.demospringboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demospringboot.converter.NewsConverter;
import com.demospringboot.dto.NewsDTO;
import com.demospringboot.entity.CategoryEntity;
import com.demospringboot.entity.NewsEntity;
import com.demospringboot.repository.CategoryRepository;
import com.demospringboot.repository.NewsRepository;
import com.demospringboot.service.INewsService;

@Service
public class NewsService implements INewsService{
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewsConverter newsConverter;

	@Override
	public NewsDTO save(NewsDTO newsDTO) {
		NewsEntity newsEntity = new NewsEntity();
		if(newsDTO.getId()!=null) {
			NewsEntity oldNewsEntity = newsRepository.findOne(newsDTO.getId());
			newsEntity = newsConverter.toEntity(newsDTO, oldNewsEntity);
		} else {
			newsEntity = newsConverter.toEntity(newsDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		newsEntity.setCategory(categoryEntity);
		newsEntity = newsRepository.save(newsEntity);
		return newsConverter.toDTO(newsEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item : ids) {
			newsRepository.delete(item);
		}
	}

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> results = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
		for(NewsEntity entity : entities) {
			NewsDTO newsDTO = newsConverter.toDTO(entity);
			results.add(newsDTO);
		}
		return results;
	}

	@Override
	public int totalItems() {
		return (int) newsRepository.count();
	}

	@Override
	public List<NewsDTO> findAll() {
		List<NewsDTO> results = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findAll();
		for(NewsEntity entity : entities) {
			NewsDTO newsDTO = newsConverter.toDTO(entity);
			results.add(newsDTO);
		}
		return results;
	}
	
/*	@Override
	public NewsDTO update(NewsDTO newsDTO) {
		NewsEntity oldNewsEntity = newsRepository.findOne(newsDTO.getId());
		NewsEntity newsEntity = newsConverter.toEntity(newsDTO, oldNewsEntity);
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		newsEntity.setCategory(categoryEntity);
		newsEntity = newsRepository.save(newsEntity);
		return newsConverter.toDTO(newsEntity);
	}*/
	
	
}
