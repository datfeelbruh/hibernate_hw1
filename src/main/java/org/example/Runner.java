package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.Comment;
import org.example.entities.Post;
import org.example.entities.User;


@Slf4j
public class Runner {
    public static void main(String[] args) {
        AppService appService = new AppService();

        User user = new User("Влад", "root");
        User user2 = new User("Дима", "root");

        Post post = new Post("Поел", user);
        Post post2 = new Post("Поспал", user2);
        Post post3 = new Post("Покодил", user2);

        Comment comment = new Comment("Вкусно?", post, user);
        Comment comment2 = new Comment("Сколько спал?", post, user2);

        appService.createUser(user);
        appService.createUser(user2);

        appService.createPost(post);
        appService.createPost(post2);
        appService.createPost(post3);

        appService.createComment(comment);
        appService.createComment(comment2);

        System.out.println(appService.getUserStat());
//        System.out.println(appService.getUserInfoById(1));
//        System.out.println(appService.getUserInfoById(2));
    }
}
