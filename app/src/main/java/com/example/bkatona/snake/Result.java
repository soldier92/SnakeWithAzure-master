package com.example.bkatona.snake;

public class Result
{
    @com.google.gson.annotations.SerializedName("id")

    private String mId;

    public String getId() {
        return mId; }

    public final void setId(String id) {
        mId = id; }

    @com.google.gson.annotations.SerializedName("Result")
    private int mScoreValue;

    public int getScore() {
        return mScoreValue; }

    public void setScore(int scoreValue) {
        mScoreValue = scoreValue; }

   public Result(){}
   public Result(String id, Integer value) {
       this.setId(id);
       this.setScore(value);
   }
}