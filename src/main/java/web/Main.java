package web;

import web.dao.UserList;

public class Main {
    static UserList userList = new UserList();

    public static void main(String[] args) {
        userList.getAllUsers();
    }
}
