package com.example.lucky.dictionary;

/**
 * Created by Lucky on 28-03-2018.
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.lucky.dictionary.Constants.ADD_DATA;

public class AddWord extends AppCompatActivity {
    private EditText newWrdTxt;
    private EditText meanTxt;
    private ProgressDialog progressDialog;
    private Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addword);
        newWrdTxt = (EditText) findViewById(R.id.newWordTxt);
        meanTxt = (EditText) findViewById(R.id.meaningTxt);
        addBtn = (Button) findViewById(R.id.addNewWordBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddWordToDatabase();
            }
        });
    }

    private void AddWordToDatabase() {

        final String wrd = newWrdTxt.getText().toString().trim();
        final String meaning = meanTxt.getText().toString().trim();

        if(wrd.equals("") || meaning.equals(""))
        {
            final TextView st = (TextView) findViewById(R.id.status);
            st.setText("Input fields cannot be empty!");
        }
        else {
            String url = ADD_DATA+"?newWord=" + wrd + "&meaning=" + meaning;
            JsonObjectRequest objectRequest = new JsonObjectRequest(
                    Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String s = response.getString("status");

                                final TextView st = (TextView) findViewById(R.id.status);
                                st.setText(s);
                                meanTxt.setText("");
                                newWrdTxt.setText("");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            );
            Volley.newRequestQueue(getApplicationContext()).add(objectRequest);
        }
    }
}


