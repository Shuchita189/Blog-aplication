package com.blog.dao;

import com.blog.model.BlogPost;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogPostDao {
    private Connection getConnection() throws SQLException {
        // Implement connection to the MySQL database
    }

    public void saveBlogPost(BlogPost blogPost) {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO blog_posts (title, content, imageUrl) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, blogPost.getTitle());
            statement.setString(2, blogPost.getContent());
            statement.setString(3, blogPost.getImageUrl());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBlogPost(BlogPost blogPost) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE blog_posts SET title = ?, content = ?, imageUrl = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, blogPost.getTitle());
            statement.setString(2, blogPost.getContent());
            statement.setString(3, blogPost.getImageUrl());
            statement.setInt(4, blogPost.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBlogPost(int id) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM blog_posts WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BlogPost> getAllBlogPosts() {
        List<BlogPost> blogPosts = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM blog_posts";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                BlogPost blogPost = new BlogPost();
                blogPost.setId(resultSet.getInt("id"));
                blogPost.setTitle(resultSet.getString("title"));
                blogPost.setContent(resultSet.getString("content"));
                blogPost.setImageUrl(resultSet.getString("imageUrl"));
                blogPosts.add(blogPost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogPosts;
    }
}
