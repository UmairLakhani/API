package com.example.bbsydp_city.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Book> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewIreview);
        sendVolleyRequest();
    }


    private void sendVolleyRequest() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        String url = Constants.BOOK_INDEX_URL;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        data = handleResponse(response);
                        BookAdapter bookAdapter = new BookAdapter(
                                MainActivity.this,
                                0,
                                data);
                        progressBar.setVisibility(View.INVISIBLE);
                        listView.setAdapter(bookAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, ""+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private ArrayList<Book> handleResponse(String response) {
        ArrayList<Book> books = new ArrayList<>();


//        try {
//            JSONObject jsonObject = (JSONObject) new JSONTokener(response).nextValue();
//            Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Responce: " +response, Toast.LENGTH_SHORT).show();

//            JSONArray jsonArray = jsonObject.getJSONArray(Constants.Book_KEY);
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject innerJsonObject = (JSONObject) jsonArray.get(i);
//
//                Book Book = new Book();
//
//                Book.setDatetime(innerJsonObject.get("datetime").toString());
//                Book.setDepth
//                        (Float.parseFloat(innerJsonObject.get("depth").toString()));
//                Book.setLng
//                        (Float.parseFloat(innerJsonObject.get("lng").toString()));
//                Book.setSrc(innerJsonObject.get("src").toString());
//                Book.setEqid(innerJsonObject.get("eqid").toString());
//                Book.setMagnitude(Float.parseFloat(innerJsonObject.get("magnitude").toString()));
//                Book.setLat(Float.parseFloat(innerJsonObject.get("lat").toString()));
//
//
//                Book.add(Book);
//
//            }

//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        return books;
    }

}