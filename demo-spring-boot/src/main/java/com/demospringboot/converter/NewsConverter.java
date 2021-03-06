package com.demospringboot.converter;

import org.springframework.stereotype.Component;

import com.demospringboot.dto.NewsDTO;
import com.demospringboot.entity.NewsEntity;

@Component
public class NewsConverter {
	public NewsEntity toEntity(NewsDTO newsDTO) {
		NewsEntity  newsEntity = new NewsEntity();
		newsEntity.setTitle(newsDTO.getTitle());
		newsEntity.setContent(newsDTO.getContent());
		newsEntity.setShortDescription(newsDTO.getShortDescription());
		newsEntity.setThumbnail(newsDTO.getThumbnail());
		return newsEntity;
	}
	
	public NewsDTO toDTO(NewsEntity newsEntity) {
		NewsDTO  newsDTO = new NewsDTO();
		if(newsEntity.getId() != null) {
			newsDTO.setId(newsEntity.getId());
		}
		newsDTO.setTitle(newsEntity.getTitle());
		newsDTO.setContent(newsEntity.getContent());
		newsDTO.setShortDescription(newsEntity.getShortDescription());
		newsDTO.setThumbnail(newsEntity.getThumbnail());
		newsDTO.setCreatedBy(newsEntity.getCreatedBy());
		newsDTO.setCreatedDate(newsEntity.getCreatedDate());
		newsDTO.setModifiedBy(newsEntity.getModifiedBy());
		newsDTO.setModifiedDate(newsEntity.getModifiedDate());
		return newsDTO;
	}
	
	public NewsEntity toEntity(NewsDTO newsDTO, NewsEntity newsEntity) {
		newsEntity.setTitle(newsDTO.getTitle());
		newsEntity.setContent(newsDTO.getContent());
		newsEntity.setShortDescription(newsDTO.getShortDescription());
		newsEntity.setThumbnail(newsDTO.getThumbnail());
		return newsEntity;
	}
}
