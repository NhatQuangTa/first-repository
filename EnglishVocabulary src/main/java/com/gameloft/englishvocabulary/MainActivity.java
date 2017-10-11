package com.gameloft.englishvocabulary;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gameloft.englishvocabulary.controllers.TopicManager;
import com.gameloft.englishvocabulary.models.Topic;
import com.gameloft.englishvocabulary.models.Vocabulary;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private boolean []mSelectedTopic, mSelectedTopicBackup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopicManager topicManager = TopicManager.getInstance();
        topicManager.load();

        mSelectedTopic = new boolean[topicManager.getTopicList().size()];
        mSelectedTopicBackup = new boolean[mSelectedTopic.length];
    }


    public void gotoTopics(View view){
        Intent intent = new Intent(MainActivity.this, TopicActivity.class);
        startActivity(intent);
    }

    public void showRating(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.rating);
        builder.setMessage("Do you like app?");
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNeutralButton(R.string.not_now, null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void gotoTest(View view){
        String []testType = getResources().getStringArray(R.array.test_type);

        new AlertDialog.Builder(this)
                .setTitle(R.string.test)
                .setItems(testType, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showChooseTopic(i);
                    }
                })
                .create()
                .show();
    }

    private void showChooseTopic(int testType){

        for(int i = 0; i < mSelectedTopic.length; i++){
            mSelectedTopicBackup[i] = mSelectedTopic[i];
        }

        String []topicsName = TopicManager.getInstance().getTopicsName();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_title_checkbox, null);
        builder.setCustomTitle(layout);

        TextView tvTitle = (TextView)layout.findViewById(R.id.tvTitle);
        final CheckBox cbAll = (CheckBox)layout.findViewById(R.id.cbSelectAll);

        tvTitle.setText(R.string.topics);

        builder.setMultiChoiceItems(topicsName, mSelectedTopic, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                int count = 0;
                for(int index = 0; index < mSelectedTopic.length; index++){
                    if(mSelectedTopic[index]){
                        count++;
                    }
                }
                cbAll.setChecked(count == mSelectedTopic.length);
            }
        });
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                doTest(i);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                for(int j = 0; j < mSelectedTopic.length; j++){
                    mSelectedTopic[j] = mSelectedTopicBackup[j];
                }
            }
        });

        final AlertDialog dialog = builder.create();
        dialog.show();

        cbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListView listView = dialog.getListView();
                boolean isChecked = cbAll.isChecked();
                for(int i = 0; i < listView.getCount(); i++){
                    listView.setItemChecked(i, isChecked);
                    mSelectedTopic[i] = isChecked;
                }
            }
        });
    }

    private void doTest(int testType){
        ArrayList<Vocabulary> list = new ArrayList<>();

        ArrayList<Topic> topicList = TopicManager.getInstance().getTopicList();

        for(int i = 0; i < mSelectedTopic.length; i++){
            if(mSelectedTopic[i]){
                Topic topic = topicList.get(i);
                ArrayList<Vocabulary> vocabularies = TopicManager.getInstance().getVocabularyList(topic);
                list.addAll(vocabularies);
            }
        }

        if(list.size() == 0){
            Toast.makeText(this,
                    "You must choose one topic to test",
                    Toast.LENGTH_SHORT).show();
        }
        else if(list.size() < 4){
            Toast toast = Toast.makeText(this,
                    "You must choose more topic to test",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 100);
            toast.show();
        }
        else{

        }
    }

}
