package com.codepath.apps.restclienttemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.adapters.TweetAdapter;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prernamanaktala on 10/4/17.
 */

public class TweetsListFragment extends Fragment implements TweetAdapter.TweetAdapterListener{
    protected TweetAdapter tweetAdapter;
    protected List<Tweet> tweets;
    RecyclerView rvTweets;
    //inflation happens in onCreateView
    protected long maxId;
    LinearLayoutManager layoutManager;
    public interface TweetsSelectedListener{
        public void onTweetSelected(Tweet tweet);
    }


    @Nullable


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragments_tweets_list,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tweets = new ArrayList<>();
        tweetAdapter = new TweetAdapter(tweets,this);
        layoutManager = new LinearLayoutManager(getContext());
        rvTweets = (RecyclerView) view.findViewById(R.id.rvTweet);
        rvTweets.setLayoutManager(layoutManager);
        rvTweets.setAdapter(tweetAdapter);
    }

    public void addItems(JSONArray response){
        for (int i = 0; i < response.length(); i++) {
            try {
                Tweet tweet = Tweet.fromJSON(response.getJSONObject(i));
                tweets.add(tweet);
                maxId = tweets.get(tweets.size() - 1).uid;
                tweetAdapter.notifyItemInserted(tweets.size() - 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onItemSelected(View view, int position) {
        Tweet tweet = tweets.get(position);
        ((TweetsSelectedListener)getActivity()).onTweetSelected(tweet);
    }
}
