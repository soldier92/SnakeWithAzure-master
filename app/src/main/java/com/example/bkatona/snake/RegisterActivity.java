package com.example.bkatona.snake;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.net.MalformedURLException;

public class RegisterActivity extends AppCompatActivity {

    private MobileServiceClient mClient;
    private MobileServiceTable<Register> mUserTable;
    private String name;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        try {
            // Mobile Service URL and key
            mClient = new MobileServiceClient(
                    "https://snakeg.azurewebsites.net",
                    this);

            mUserTable = mClient.getTable("User", Register.class);
        } catch (MalformedURLException e) {
            Log.e("MalformedEx", e.getLocalizedMessage());
        } catch (Exception e) {
            Log.e("ex", e.getLocalizedMessage());
        }
    }


    public void regUser(View view) {

        EditText Username = (EditText) findViewById(R.id.Username);
        EditText Password = (EditText) findViewById(R.id.Password);
        Register reg = new Register();
        reg.setUserName(Username.getText().toString());
        reg.setPassword(Password.getText().toString());

      //  Log.d("tag","Username");

        if(Username.getText().toString().trim().equals("")){
            Username.setError( "Username is required!" );
        }

        else if(Password.getText().toString().trim().equals("")){
            Password.setError( "Password is required!" );
        }

        else{
            mUserTable.insert(reg);
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
        }
    }
}



