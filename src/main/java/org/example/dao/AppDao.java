package org.example.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.HibernateUtil;
import org.example.entities.Comment;
import org.example.entities.Post;
import org.example.entities.User;
import org.hibernate.*;

import java.util.Comparator;
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
        int userCount = session.createQuery("FROM User").list().size();
        int postCount = session.createQuery("FROM Post").list().size();
        int commentCount = session.createQuery("FROM Comment").list().size();
        session.close();

        return "Количество пользователей - " + userCount + "\n" +
                "Количество постов - " + postCount + "\n" +
                "Количество комментариев - " + commentCount;
    }

    public String userInfoById(int id) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        User user = session.get(User.class, id);

        String userName = user.getName();
        String userCreated = user.getCreated_at().toString();
        String firstPostText = user.getPosts().stream()
                .sorted(Comparator.comparing(Post::getCreated_at))
                .limit(1)
                .map(Post::getText)
                .collect(Collectors.joining());
        int commentCount = user.getComments().size();
        session.close();

        return "Имя пользователя - " + userName + "\n" +
                "Дата создания - " + userCreated + "\n" +
                "Первый пост - " + firstPostText + "\n" +
                "Количество комментариев - " + commentCount;
    }
}
