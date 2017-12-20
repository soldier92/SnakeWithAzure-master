package com.example.bkatona.snake;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.net.MalformedURLException;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private MobileServiceClient mClient;
    private MobileServiceTable<Register> mUserTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        try {
            // Mobile Service URL and key
            mClient = new MobileServiceClient(
                    "https://snakeg.azurewebsites.net",
                    this);

            mUserTable = mClient.getTable("User",Register.class);

        }

        catch (MalformedURLException e) {
            Log.e("MalformedEx",e.getLocalizedMessage());
        }

        catch (Exception e) {
            Log.e("ex",e.getLocalizedMessage());
        }
    }




    public void LoginUser(View view) {


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {

                    EditText Username = (EditText) findViewById(R.id.Username);
                    EditText Password = (EditText) findViewById(R.id.Password);

                    String password = Password.getText().toString();
                    String UserName = Username.getText().toString();

                    if(Username.getText().toString().trim().equals("")){
                        Username.setError( "Username is required!" );
                    }

                    else if(Password.getText().toString().trim().equals("")){
                        Password.setError( "Password is required!" );
                    }

                        final List<Register> results = mUserTable.where()
                                .field("userName").eq(UserName).and().field("password").eq(password).execute().get();
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                if (((MobileServiceList) results).getTotalCount() == 1) {
                                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                                } else {
                                    //startActivity(new Intent(getApplicationContext(), ShowFailure.class));
                                }
                            }
                        });
                    } catch(Exception exception){
                        Log.d("Ex", "Exception");
                    }
                    return null;
                }
            }.
            execute();
        }


    public void RegNewUser(View view) {
        startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
    }

}







