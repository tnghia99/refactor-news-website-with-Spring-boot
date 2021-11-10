package com.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demospringboot.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity, Long>{
	
}
