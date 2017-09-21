package com.example;

/**
 * Created by zilles on 9/7/17.
 *
 * "status": "ok",
 "source": "the-washington-post",
 "sortBy": "top",
 "articles": [{
 */
public class NewsCollection {
    private String status;
    private String source;
    private String sortBy;
    private NewsArticle[] articles;

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public NewsArticle[] getArticles() {
        return articles;
    }
}
