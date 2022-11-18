package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.AppDao;


@Slf4j
public class Runner {
    public static void main(String[] args) {
        AppDao appDao = new AppDao();

        appDao.addUser("Влад", "root");
        appDao.addUser("Дима", "root");

        appDao.addPost("Поел", 1);
        appDao.addPost("Поспал", 2);
        appDao.addPost("Покодил", 2);

        appDao.addComment("Вкусно?", 1, 2);
        appDao.addComment("Сколько спал?", 2, 1);

        System.out.println(appDao.getStatistics());
        System.out.println(appDao.userInfoById(1));
        System.out.println(appDao.userInfoById(2));
    }
}
