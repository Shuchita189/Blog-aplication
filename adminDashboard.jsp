<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.blog.model.BlogPost, com.blog.dao.BlogPostDao" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
</head>
<body>
    <h1>Admin Dashboard</h1>
    <form action="admin" method="post">
        <input type="hidden" name="action" value="create">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title"><br>
        <label for="content">Content:</label>
        <textarea id="content" name="content"></textarea><br>
        <label for="imageUrl">Image URL:</label>
        <input type="text" id="imageUrl" name="imageUrl"><br>
        <input type="submit" value="Create Blog Post">
    </form>

    <h2>All Blog Posts</h2>
    <%
        BlogPostDao blogPostDao = new BlogPostDao();
        List<BlogPost> blogPosts = blogPostDao.getAllBlogPosts();
        for (BlogPost blogPost : blogPosts) {
    %>
    <form action="admin" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= blogPost.getId() %>">
        <label for="title_<%= blogPost.getId() %>">Title:</label>
        <input type="text" id="title_<%= blogPost.getId() %>" name="title" value="<%= blogPost.getTitle() %>"><br>
        <label for="content_<%= blogPost.getId() %>">Content:</label>
        <textarea id="content_<%= blogPost.getId() %>" name="content"><%= blogPost.getContent() %></textarea><br>
        <label for="imageUrl_<%= blogPost.getId() %>">Image URL:</label>
        <input type="text" id="imageUrl_<%= blogPost.getId() %>" name="imageUrl" value="<%= blogPost.getImageUrl() %>"><br>
        <input type="submit" value="Update Blog Post">
    </form>
    <form action="admin" method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="<%= blogPost.getId() %>">
        <input type="submit" value="Delete Blog Post">
    </form>
    <hr>
    <%
        }
    %>
</body>
</html>
