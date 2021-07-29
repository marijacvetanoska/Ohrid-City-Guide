package com.example.ohridcityguide.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ohridcityguide.R;
import com.example.ohridcityguide.models.Article;
import com.example.ohridcityguide.models.BlogPost;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
    private List<Article> posts;
    private BlogPostClickListener blogPostClickListener;

    public PostAdapter(List<Article> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_post, null, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bindData(posts.get(position), blogPostClickListener);
    }

    @Override
    public int getItemCount() {
        if(posts == null)
            return 0;
        return posts.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle;
        private ImageView ivImage;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.blogPostTitle);
            ivImage = (ImageView) itemView.findViewById(R.id.blogPostImage);
        }

        public void bindData(Article post, final BlogPostClickListener listener) {
            tvTitle.setText(post.getTitle());
            Glide.with(itemView).load(post.getImageId()).into(ivImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onBlogPostClicked(post.getTitle());
                }
            });

        }
    }

    public interface BlogPostClickListener{
        void onBlogPostClicked(String title);
    }

    public void setBlogPostClickListener(BlogPostClickListener blogPostClickListener) {
        this.blogPostClickListener = blogPostClickListener;
    }


}
