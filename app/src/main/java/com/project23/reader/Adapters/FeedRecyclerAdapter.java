package com.project23.reader.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.project23.reader.Article;
import com.project23.reader.Feed;
import com.project23.reader.R;

/**
 * Created by TomSingleton on 12/01/15.
 */
public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.FeedViewHolder>{


    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);
        return new FeedViewHolder(itemHolder);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.bindFeed(position);

    }

    @Override
    public int getItemCount() {
        return Feed.getInstance().getArticleArrayList().size();
    }

    public final static class FeedViewHolder extends RecyclerView.ViewHolder{

        TextView articleTitle;
        TextView articleBody;

        public FeedViewHolder(final View itemView) {
            super(itemView);

            articleTitle = (TextView) itemView.findViewById(R.id.article_title);
            articleBody = (TextView) itemView.findViewById(R.id.article_body);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Pressed!", Toast.LENGTH_SHORT).show();
                }
            });

        }

        public void bindFeed(int position){
            Article article = Feed.getInstance().getArticleArrayList().get(position);
            Log.d("new", article.toString());
            articleTitle.setText(article.getTitle());
            articleBody.setText(article.getBody());
        }
    }
}
