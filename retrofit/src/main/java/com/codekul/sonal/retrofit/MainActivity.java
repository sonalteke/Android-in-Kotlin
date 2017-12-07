package com.codekul.sonal.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codekul.sonal.retrofit.domain.DtoInfo;
import com.codekul.sonal.retrofit.domain.User;
import com.codekul.sonal.retrofit.rest.ApiService;
import com.codekul.sonal.retrofit.rest.RetrofitClient;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRegister().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPostData();
            }
        });
    }
    private void getPostData(){
        apiService= RetrofitClient.getClient().create(ApiService.class);
        Call<ResponseBody> call = apiService.userRegister(userObj());
        Log.i("@codekul" ,"regi url " +call.request().url().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                DtoInfo dtoInfo= response.body();
//                String message = dtoInfo.getMessage();
//                Log.i("@codekul"," resp : " +message);
                Log.i("@codekul " ,"response " +response);


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.i("@codekul","error msg " +call + " thro " + t.getMessage());

            }
        });

    }
    private User userObj(){
        User user = new User();
        user.setName(getName().getText().toString());
        user.setEmailId(getEmailId().getText().toString());
        user.setPassword(getPassword().getText().toString());
        user.setCity(getCity().getText().toString());
        return user;
    }



    private EditText getName(){
        return (EditText)findViewById(R.id.editName);
    }
    private EditText getPassword(){
        return (EditText)findViewById(R.id.editPassword);
    }
    private EditText getEmailId(){
        return (EditText)findViewById(R.id.editEmailId);
    }
    private EditText getCity(){
        return (EditText)findViewById(R.id.editCity);
    }
    private Button getRegister(){
        return (Button)findViewById(R.id.register);
    }



}
