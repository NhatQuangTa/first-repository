package com.gameloft.englishvocabulary.models;

/**
 * Created by tai.nguyenduc on 8/24/2017.
 */

public class Vocabulary {
    private String word;
    private String pronunciation;
    private String mean;
    private int topicId;

    public Vocabulary(String word, String pronunciation, String mean, int topicId) {
        this.word = word;
        this.pronunciation = pronunciation;
        this.mean = mean;
        this.topicId = topicId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "word='" + word + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", mean='" + mean + '\'' +
                ", topicId=" + topicId +
                '}';
    }
}


