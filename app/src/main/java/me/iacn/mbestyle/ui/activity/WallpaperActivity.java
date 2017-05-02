package me.iacn.mbestyle.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import me.iacn.mbestyle.R;
import me.iacn.mbestyle.util.StatusBarUtils;

/**
 * Created by iAcn on 2017/5/2
 * Emali iAcn0301@foxmail.com
 */

public class WallpaperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        StatusBarUtils.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
    }
}