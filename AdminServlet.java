package com.blog.controller;

import com.blog.model.BlogPost;
import com.blog.dao.BlogPostDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createBlogPost(request, response);
        } else if ("update".equals(action)) {
            updateBlogPost(request, response);
        } else if ("delete".equals(action)) {
            deleteBlogPost(request, response);
        }
    }

    private void createBlogPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String imageUrl = request.getParameter("imageUrl");

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(title);
        blogPost.setContent(content);
        blogPost.setImageUrl(imageUrl);

        BlogPostDao blogPostDao = new BlogPostDao();
        blogPostDao.saveBlogPost(blogPost);

        response.sendRedirect("adminDashboard.jsp");
    }

    private void updateBlogPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String imageUrl = request.getParameter("imageUrl");

        BlogPost blogPost = new BlogPost();
        blogPost.setId(id);
        blogPost.setTitle(title);
        blogPost.setContent(content);
        blogPost.setImageUrl(imageUrl);

        BlogPostDao blogPostDao = new BlogPostDao();
        blogPostDao.updateBlogPost(blogPost);

        response.sendRedirect("adminDashboard.jsp");
    }

    private void deleteBlogPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        BlogPostDao blogPostDao = new BlogPostDao();
        blogPostDao.deleteBlogPost(id);

        response.sendRedirect("adminDashboard.jsp");
    }
}
