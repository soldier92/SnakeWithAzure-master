package com.example.bkatona.snake;

/**
 * Created by bkatona on 2017.12.14..
 */

public class Register {


    @com.google.gson.annotations.SerializedName("Id")

    private String mId;

    public String getId() {
        return mId; }

    public final void setId(String id) {
        mId = id; }

    @com.google.gson.annotations.SerializedName("userName")
    private String mUserName;

    public String getUserName() {
        return mUserName; }

    public void setUserName(String UserName) {
        mUserName = UserName; }


    @com.google.gson.annotations.SerializedName("password")
    private String mPasswordValue;

    public String getPassword() {
        return mPasswordValue; }

    public void setPassword(String PasswordValue) {
        mPasswordValue = PasswordValue; }

    public  Register(){}
    public Register(String id, String userName, String password) {
        this.setId(id);
        this.setUserName(userName);
        this.setPassword(password);
    }

}
