package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by prernamanaktala on 9/28/17.
 */

public class User implements Serializable {
    public String name;
    public long uid;
    public String profileImageUrl;
    public String screenName;
    public String tagline;
    public int followersCount;
    public int followingCount;


    public static User fromJSON(JSONObject jsonObject) throws JSONException{
        User user = new User();
        user.name = jsonObject.getString("name");
        user.uid = jsonObject.getLong("id");
        user.screenName = jsonObject.getString("screen_name");
        user.profileImageUrl = jsonObject.getString("profile_image_url");
        user.tagline = jsonObject.getString("description");
        user.followersCount = jsonObject.getInt("followers_count");
        user.followingCount = jsonObject.getInt("friends_count");
        if(user.tagline.isEmpty()){
            user.tagline = "My tagline";
        }

        return user;
    }


}
