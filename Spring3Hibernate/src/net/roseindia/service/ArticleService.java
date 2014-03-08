package net.roseindia.service;

import java.util.List;

import net.roseindia.model.Article;

public interface ArticleService {

	public void addArticle(Article article);

	public List<Article> listArticles();
}