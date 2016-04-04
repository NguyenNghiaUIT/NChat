package com.nghianv.nghiachat.data;

import android.util.Log;

import com.nghianv.nghiachat.model.User;

/**
 * Created by NguyenNghia on 4/3/2016.
 */
public class Data {
    public static User NghiaUser = new User("13520546", "NguyenNghia");
    public static void initNghiaUser(){
        Log.i("Data", NghiaUser + "");
        User user1 = new User("13520508", "Nguyễn Hoàng Minh");
        User user2 = new User("13520625", "Phạm Nguyễn Tâm Phú");
        User user3 = new User("13520633", "Trần Văn Phúc");
        User user4 = new User("13520489", "Lê Thị Tuyết Mai");

        NghiaUser.addFriend(user1);
        NghiaUser.addFriend(user2);
        NghiaUser.addFriend(user3);
        NghiaUser.addFriend(user4);
    }
}
