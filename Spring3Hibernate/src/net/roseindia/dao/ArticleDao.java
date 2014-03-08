package net.roseindia.dao;

import java.util.Date;
import java.util.List;

import net.roseindia.model.Article;


public interface ArticleDao {
	// To Save the article detail
	public void saveArticle ( Article Article );
	
	// To get list of all articles
	public List<Article> listArticles();
}