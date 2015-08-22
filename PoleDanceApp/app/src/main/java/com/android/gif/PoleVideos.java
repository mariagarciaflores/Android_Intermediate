package com.android.gif;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Griss Garcia on 16/08/2015.
 */
public class PoleVideos extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String API_KEY = "AIzaSyCB3hWHJVFsgOjDxFmMyDYrfm2XTZ4aXn8";
    private YouTubePlayerView videoView;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.video_layout);
        videoView = (YouTubePlayerView) findViewById(R.id.pole_video_custom);
        videoView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            Intent i = getIntent();
            int imageId = i.getIntExtra("imageId", -1);
            String videoId = MapCreator.getInstance().poleImageVideos.get(imageId);
            youTubePlayer.cueVideo(videoId);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
