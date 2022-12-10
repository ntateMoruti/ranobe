package org.ranobe.ranobe.ui.browse.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.ranobe.ranobe.databinding.ItemNovelBinding;
import org.ranobe.ranobe.models.NovelItem;

import java.util.List;

public class NovelAdapter extends RecyclerView.Adapter<NovelAdapter.MyViewHolder> {
    private final List<NovelItem> items;

    public NovelAdapter(List<NovelItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNovelBinding binding = ItemNovelBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NovelItem item = items.get(position);
        holder.binding.novelName.setText(item.name);
        Glide.with(holder.binding.novelCover.getContext())
                .load(item.cover)
                .into(holder.binding.novelCover);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemNovelBinding binding;
        public MyViewHolder(@NonNull ItemNovelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
