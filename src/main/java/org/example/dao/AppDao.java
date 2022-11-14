package org.example.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.HibernateUtil;
import org.example.entities.Comment;
import org.example.entities.Post;
import org.example.entities.User;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.security.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class AppDao {
    public void addUser(User user) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void addPost(Post post) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(post);
        transaction.commit();
        session.close();
    }

    public void addComment(Comment comment) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(comment);
        transaction.commit();
        session.close();
    }

    public String getStatistics() {
        Session session = HibernateUtil.createSessionFactory().openSession();
        List<User> users = session.createQuery("FROM User").list();
        List<Post> posts = session.createQuery("FROM Post").list();
        List<Comment> comments = session.createQuery("FROM Comment").list();
        session.close();

        return "Количество пользователей - " + users.size() + "\n" +
                "Количество постов - " + posts.size() + "\n" +
                "Количество комментариев - " + comments.size();
    }

    public String userInfoById(int id) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        String hql = "FROM User where id = :paramId";
        Query query = session.createQuery(hql);
        query.setParameter("paramId", id);
        User user = (User) query.uniqueResult();

        String userName = user.getName();
        String userCreated = user.getCreated_at().toString();
        String firstPostText = user.getPosts().stream()
                .sorted(Comparator.comparing(Post::getCreated_at))
                .limit(1)
                .map(Post::getText)
                .collect(Collectors.joining());
        int commentCount = user.getUser_comments().size();

        return "Имя пользователя - " + userName + "\n" +
                "Дата создания - " + userCreated + "\n" +
                "Первый пост - " + firstPostText + "\n" +
                "Количество комментариев - " + commentCount;
    }
}
