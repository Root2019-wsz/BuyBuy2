package com.shenzhe.lib_cache.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shenzhe.lib_cache.R;
import com.shenzhe.lib_cache.databinding.ItemStoryBinding;
import com.shenzhe.lib_cache.model.Story;

import java.util.List;


public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
    private List<Story> itemDatas;

    public StoryAdapter(List<Story> itemDatas){
        this.itemDatas = itemDatas;
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemStoryBinding itemStoryBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_story, parent, false);
        return new StoryViewHolder(itemStoryBinding);
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, int position) {
        holder.binding.setItem(itemDatas.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return itemDatas.size();
    }

    class StoryViewHolder extends RecyclerView.ViewHolder{
        ItemStoryBinding binding;

        public StoryViewHolder(ItemStoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}