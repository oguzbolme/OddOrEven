package com.example.restfull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private getResult getResult;
    private EditText editText_value;
    private Button button_send;
    private TextView textView_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_value = findViewById(R.id.editText_value);
        textView_result = findViewById(R.id.textView_result);

        button_send = findViewById(R.id.button_send);
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_result.setText("");
                getResult = new getResult();
                getResult.execute();
            }
        });
    }

    private class getResult extends AsyncTask<Void, Void, String> {
        String host="xxx.xxx.x.xx";
        String port="5000";
        String number;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            number = editText_value.getText().toString();
        }

        @Override
        protected String doInBackground(Void... params) {
            FlaskServer flaskServer = new FlaskServer();
            String url = "http://"+host+":"+port+"/"+number;
            String result = flaskServer.getData(url);
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            textView_result.setText(result);
        }
    }
}
