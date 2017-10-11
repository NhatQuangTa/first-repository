package com.gameloft.englishvocabulary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.gameloft.englishvocabulary.adapters.LearnArrayAdapter;
import com.gameloft.englishvocabulary.controllers.TopicManager;
import com.gameloft.englishvocabulary.models.Topic;
import com.gameloft.englishvocabulary.models.Vocabulary;

import java.util.ArrayList;

public class LearnActivity extends AppCompatActivity {

    private ListView lvVoabulary;
    private LearnArrayAdapter mAdapter;
    ArrayList<Vocabulary> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        Intent intent = getIntent();
        Topic topic = (Topic)intent.getSerializableExtra(TopicActivity.KEY_PASS_DATA);
        mList = TopicManager.getInstance().getVocabularyList(topic);

        lvVoabulary = (ListView)findViewById(R.id.lvVocabulary);
        mAdapter = new LearnArrayAdapter(this, R.layout.item_vocabulary_learn, mList);
        lvVoabulary.setAdapter(mAdapter);
    }
}
