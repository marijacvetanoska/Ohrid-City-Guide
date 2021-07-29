package com.example.ohridcityguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.ohridcityguide.adapters.PostAdapter;
import com.example.ohridcityguide.data.BlogPosts;
import com.example.ohridcityguide.database.AppDatabase;
import com.example.ohridcityguide.models.Article;
import com.example.ohridcityguide.models.BlogPost;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ExploreFragment extends Fragment {

    private RecyclerView postsList;
    private PostAdapter postAdapter;
    private HashMap<String, Article> list;
    private BlogPosts blogPosts = new BlogPosts();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        list = blogPosts.getPosts();
        List<Article> articles = new ArrayList<Article>(list.values());
        articles = articles.stream().sorted(Comparator.comparing(Article::getId)).collect(Collectors.toList());
        postsList = (RecyclerView) view.findViewById(R.id.blogPostsList);
        postsList.setNestedScrollingEnabled(false);
        postAdapter = new PostAdapter(articles);

        postAdapter.setBlogPostClickListener(new PostAdapter.BlogPostClickListener() {
            @Override
            public void onBlogPostClicked(String title) {
                Intent intent = new Intent("android.intent.action.VIEW",
                        Uri.parse(list.get(title).getUrl()));
                startActivity(intent);
//                Bundle bundle = new Bundle();
//                bundle.putString("postTitle", title);
////                NavHostFragment.findNavController(ExploreFragment.this)
////                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
//                BlogPostFragment fragment = BlogPostFragment.newInstance(title);
//                openFragment(fragment);
            }
        });

        postsList.setAdapter(postAdapter);

    }

    private void openFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }


}