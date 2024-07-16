<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.blog.model.BlogPost, com.blog.dao.BlogPostDao" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blog Posts</title>
</head>
<body>
    <h1>Blog Posts</h1>
    <%
        BlogPostDao blogPostDao = new BlogPostDao();
        List<BlogPost> blogPosts = blogPostDao.getAllBlogPosts();
        for (BlogPost blogPost : blogPosts) {
    %>
    <h2><%= blogPost.getTitle() %></h2>
    <p><%= blogPost.getContent() %></p>
    <img src="<%= blogPost.getImageUrl() %>" alt="Image for <%= blogPost.getTitle() %>">
    <hr>
    <%
        }
    %>
</body>
</html>
