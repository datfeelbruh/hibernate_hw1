package org.example;

import org.example.dao.AppDao;
import org.example.entities.Comment;
import org.example.entities.Post;
import org.example.entities.User;

public class AppService {
    private AppDao appDao = new AppDao();

    public void createUser(User user) {
        appDao.addUser(user);
    }

    public void createPost(Post post) {
        appDao.addPost(post);
    }

    public void createComment(Comment comment) {
        appDao.addComment(comment);
    }

    public String getUserStat() {
       return appDao.getStatistics();
    }

    public String getUserInfoById(int id) {
        return appDao.userInfoById(id);
    }
}
