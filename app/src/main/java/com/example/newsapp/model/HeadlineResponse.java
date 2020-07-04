package com.example.newsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeadlineResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private Long totalResults;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HeadlineResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public HeadlineResponse withTotalResults(Long totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public HeadlineResponse withArticles(List<Article> articles) {
        this.articles = articles;
        return this;
    }



    public class Article {

        @SerializedName("source")
        @Expose
        private Source source;
        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("urlToImage")
        @Expose
        private String urlToImage;
        @SerializedName("publishedAt")
        @Expose
        private String publishedAt;
        @SerializedName("content")
        @Expose
        private String content;

        public Source getSource() {
            return source;
        }

        public void setSource(Source source) {
            this.source = source;
        }

        public Article withSource(Source source) {
            this.source = source;
            return this;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Article withAuthor(String author) {
            this.author = author;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Article withTitle(String title) {
            this.title = title;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Article withDescription(String description) {
            this.description = description;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Article withUrl(String url) {
            this.url = url;
            return this;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public Article withUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
            return this;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public Article withPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
            return this;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Article withContent(String content) {
            this.content = content;
            return this;
        }

    }

    public class Source {

        @SerializedName("id")
        @Expose
        private Object id;
        @SerializedName("name")
        @Expose
        private String name;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Source withId(Object id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Source withName(String name) {
            this.name = name;
            return this;
        }

    }

}
