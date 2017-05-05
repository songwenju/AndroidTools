package com.songwenju.androidtools.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * 播放资源目录下音频文件
 */
public class MediaPlayerUtiles {
    static MediaPlayer mMediaPlayer;


    public static MediaPlayer getMediaPlayer() {
        if (null == mMediaPlayer) {
            mMediaPlayer = new MediaPlayer();
        }

        return mMediaPlayer;
    }


    /**
     * 播放音频
     */
    public static void playAudio(Context mContext, String fileName) {
        try {
            stopAudio();//如果正在播放就停止
            AssetManager assetManager = mContext.getAssets();
            AssetFileDescriptor afd = assetManager.openFd(fileName);
            MediaPlayer mediaPlayer = getMediaPlayer();
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.setLooping(false);//循环播放
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        } catch (Exception e) {
            Log.e("播放音频失败","");
        }
    }


    /**
     * 停止播放音频
     */
    public static void stopAudio(){
        try {
            if (null!=mMediaPlayer){
                if (mMediaPlayer.isPlaying()){
                    mMediaPlayer.pause();
                    mMediaPlayer.reset();
                    mMediaPlayer.stop();
                }
            }
        }catch (Exception e){
            Log.e("stopAudio",e.getMessage());
        }


    }

}