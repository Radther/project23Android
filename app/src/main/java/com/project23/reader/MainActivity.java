package com.project23.reader;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.project23.reader.Adapters.FeedRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class MainActivity extends ActionBarActivity {

    private RecyclerView articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);

        final Firebase tagsRef = new Firebase("https://rsstest.firebaseio.com/tags/");
        Firebase articlesRef = new Firebase("https://rsstest.firebaseio.com/articles/");

        ArrayList<Article> articleArrayList = new ArrayList<>();
        articlesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                final Article newArticle = new Article();
                Map<String, Object> articleMap = (Map<String, Object>) dataSnapshot.getValue();
                newArticle.setTitle((String)articleMap.get("title"));
                newArticle.setBody((String) articleMap.get("body"));
                final List<String> articleTags = (List)articleMap.get("tags");
                newArticle.setTags(new ArrayList<String>(articleTags));

                Feed.getInstance().getArticleArrayList().add(newArticle);
                articleList.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        articleList = (RecyclerView)findViewById(R.id.rss_list);
        FeedRecyclerAdapter feedRecyclerAdapter = new FeedRecyclerAdapter();
        articleList.setAdapter(feedRecyclerAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        articleList.setLayoutManager(layoutManager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
