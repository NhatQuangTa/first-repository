package com.gameloft.englishvocabulary.controllers;


import com.gameloft.englishvocabulary.models.Topic;
import com.gameloft.englishvocabulary.models.Vocabulary;

import java.util.ArrayList;

/**
 * Created by tai.nguyenduc on 8/24/2017.
 */

public class TopicManager {
    private ArrayList<Topic> mTopicList;
    private ArrayList<Vocabulary> mVocabularyList;

    private static TopicManager sInstance = null;

    public static TopicManager getInstance(){
        if(sInstance == null){
            sInstance = new TopicManager();
        }
        return sInstance;
    }

    private TopicManager(){
        mTopicList = new ArrayList<>();
        mVocabularyList = new ArrayList<>();
    }

    public void load(){
        //fake data
        mTopicList.add(new Topic(1, "Topic1"));
        mTopicList.add(new Topic(2, "Topic2"));
        mTopicList.add(new Topic(3, "Topic3"));

        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));
        mVocabularyList.add(new Vocabulary("w11", "p11", "m11", 1));
        mVocabularyList.add(new Vocabulary("w12", "p12", "m12", 1));

        mVocabularyList.add(new Vocabulary("w21", "p21", "m21", 2));
        mVocabularyList.add(new Vocabulary("w22", "p22", "m22", 2));

        mVocabularyList.add(new Vocabulary("w31", "p31", "m31", 3));
        mVocabularyList.add(new Vocabulary("w32", "p32", "m32", 3));
    }
    public ArrayList<Topic> getTopicList(){
        return mTopicList;
    }

    public String [] getTopicsName(){
        String []names = new String[mTopicList.size()];
        for(int i = 0; i < names.length; i++){
            Topic topic = mTopicList.get(i);
            names[i] = topic.getName();
        }

        return names;
    }

    public ArrayList<Vocabulary> getVocabularyList(Topic topic){
        ArrayList<Vocabulary> list = new ArrayList<>();
        for(Vocabulary vocabulary : mVocabularyList){
            if(vocabulary.getTopicId() == topic.getId()){
                list.add(vocabulary);
            }
        }
        return list;
    }
}
