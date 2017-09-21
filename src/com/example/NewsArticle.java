package com.example;

/**
 * Created by zilles on 9/7/17.
 *
 * {
 "author": "Kelsey Snell, Kelsey Snell",
 "title": "Senate approves bill doubling hurricane aid package, extending federal borrowing limit",
 "description": "The bill heads to the House for final approval as leaders rush to approve FEMA money before emergency funds run out.",
 "url": "https://www.washingtonpost.com/powerpost/mcconnell-introduces-bill-linking-hurricane-aid-package-federal-borrowing-limit/2017/09/07/2c0cf1d6-9382-11e7-8754-d478688d23b4_story.html",
 "urlToImage": "https://img.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2017/09/07/National-Politics/Images/Trump_Congress_23004-f659f.jpg?t=20170517",
 "publishedAt": "2017-09-07T07:34:00Z"
 }
 *
 */
public class NewsArticle {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;

    // only necessary if you add non-default constructors
    public NewsArticle() {
    }

    /**
     * A getter for the the Author name.
     * @return author name
     */
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    /**
     * Looks for string in article's author string.
     * @param authorName a substring to search for in the author field
     * @return a boolean indicating whether the substring was found
     */
    public boolean includesAuthor(String authorName) {
        return author.contains(authorName);
    }
}
