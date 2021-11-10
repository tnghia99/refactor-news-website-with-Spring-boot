package com.demospringboot.api.output;

import java.util.ArrayList;
import java.util.List;

import com.demospringboot.dto.NewsDTO;

public class NewsOutput {
	private int currentPage;
	private int totalPages;
	private List<NewsDTO> listResults = new ArrayList<>();
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<NewsDTO> getListResults() {
		return listResults;
	}
	public void setListResults(List<NewsDTO> listResults) {
		this.listResults = listResults;
	}
	
	
}
