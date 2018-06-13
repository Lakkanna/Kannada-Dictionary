package com.example.lucky.dictionary;

/**
 * Created by Lucky on 28-03-2018.
 */


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    private EditText wrdTxt;
    private Button nextPage;
    private Button searchBtn;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        wrdTxt = (EditText) findViewById(R.id.word);
        nextPage = (Button) findViewById(R.id.addWordBtn);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToNextPage();
            }
        });
        searchBtn = (Button) findViewById(R.id.search);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        getData();

            }
        });
    }

    private void navigateToNextPage() {
        Intent intj = new Intent(MainActivity.this, AddWord.class);
        startActivity(intj);
     //   finish();
    }
    private void getData() {
        final String wrd = wrdTxt.getText().toString().trim();
        if(wrd.equals(""))
        {
            final TextView st = (TextView) findViewById(R.id.output);
            st.setText("Input fields cannot be empty!");
        }
        else {
            progressDialog.setMessage("Getting Data...");
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    Constants.URL_DATA,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                                if (!jsonObject.getBoolean("error")) {
                                    final TextView outputT = (TextView) findViewById(R.id.output);
                                    String detail = jsonObject.getString("detail");
                                    outputT.setText(wrd + ": " + detail);
                                    wrdTxt.setText("");
                                } else {
                                    final TextView outputT = (TextView) findViewById(R.id.output);
                                    String detail = jsonObject.getString("message");
                                    outputT.setText(wrd + ": " + detail);
                                    wrdTxt.setText("");
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.hide();
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("word", wrd);
                    return params;
                }
            };
            Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
        }
    }
}
