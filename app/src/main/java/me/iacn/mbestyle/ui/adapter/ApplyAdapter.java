package me.iacn.mbestyle.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;

import me.iacn.mbestyle.R;
import me.iacn.mbestyle.ui.callback.OnItemClickListener;

/**
 * Created by iAcn on 2017/2/20
 * Emali iAcn0301@foxmail.com
 */

public class ApplyAdapter extends RecyclerView.Adapter<ApplyHolder> {

    private static final int TYPE_ITEM_WALLPAPER = 7;
    private static final int TYPE_ITEM_LAUNCHER = 103;

    private int[] mLauncherIcons;
    private String[] mLauncherNames;
    private RequestManager mGlide;
    private OnItemClickListener mListener;

    public ApplyAdapter(int[] mLauncherIcons, String[] mLauncherNames, RequestManager glide) {
        this.mLauncherIcons = mLauncherIcons;
        this.mLauncherNames = mLauncherNames;
        this.mGlide = glide;
    }

    @Override
    public ApplyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ApplyHolder holder;

        if (viewType == TYPE_ITEM_WALLPAPER) {
            holder = new ApplyHolder(LayoutInflater.from(
                    parent.getContext()).inflate(R.layout.item_apply_wallpaper, parent, false), true);
        } else {
            holder = new ApplyHolder(LayoutInflater.from(
                    parent.getContext()).inflate(R.layout.item_apply_launcher, parent, false), false);
        }

        holder.mListener = mListener;

        return holder;
    }

    @Override
    public void onBindViewHolder(ApplyHolder holder, int position) {
        if (position == 0) return;
        position--;

        mGlide.load(mLauncherIcons[position]).into(holder.ivLauncherIcon);
        holder.tvLauncherName.setText(mLauncherNames[position]);
    }

    @Override
    public int getItemCount() {
        return mLauncherIcons.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_ITEM_WALLPAPER : TYPE_ITEM_LAUNCHER;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}

class ApplyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView ivLauncherIcon;
    TextView tvLauncherName;
    OnItemClickListener mListener;

    ApplyHolder(View itemView, boolean isHeaderView) {
        super(itemView);

        if (isHeaderView) {
            itemView.setOnClickListener(this);
            return;
        }

        ivLauncherIcon = (ImageView) itemView.findViewById(R.id.iv_launcher_icon);
        tvLauncherName = (TextView) itemView.findViewById(R.id.tv_launcher_name);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            mListener.onItemClick(v, getLayoutPosition());
        }
    }
}