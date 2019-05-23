/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

//cat ./bitnami_credentials

package com.parse.starter;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {

  public void signUp(View view) {

    EditText usernameText = (EditText) findViewById(R.id.usernameEditText);
    EditText passwordText = (EditText) findViewById(R.id.passwordEditText);
    if (usernameText.getText().toString() == "" || passwordText.getText().toString() == "") {
      Toast.makeText(this, "A username and password are required", Toast.LENGTH_SHORT).show();
    }else{
      ParseUser user = new ParseUser();

      user.setUsername(usernameText.getText().toString());
      user.setPassword(passwordText.getText().toString());

      user.signUpInBackground(new SignUpCallback() {
        @Override
        public void done(ParseException e) {
          if (e == null) {
            Log.i("Signup", "Successful");
          }else{
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
          }
        }
      });
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
    //EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

    //save value
    /*
    ParseObject score = new ParseObject("Score");
    score.put("username", "rob");
    score.put("score", 86);
    score.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          Log.i("SaveInBackground", "Successful");
        }
        else {
          Log.i("SaveInBackground", "Failed. Error: " + e.toString());
        }
      }
    }); */

    /*
    //retrieving info
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
    query.getInBackground("ydK9yIRiFW", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if (e == null && object != null) {

          //update info
          object.put("score", 200);
          object.saveInBackground();

          Log.i("ObjectValue", object.getString("username"));
          Log.i("ObjectValue", Integer.toString(object.getInt("score")));
        }
      }
    }); */

    /*
    //Create Tweet class, username tweet, save on Parse, then query it, and update the tweet content
    ParseObject tweet = new ParseObject("Tweet");
    tweet.put("username", "tommy");
    tweet.put("tweet", "Hey there!");
    tweet.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          Log.i("Tweet", "Successful");
        }else {
          Log.i("Tweet", "Failed");
        }
      }
    }); */

    /*
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");
    query.getInBackground("60UMgONFuA", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if (e == null && object != null) {
          Log.i("Tweet", "Successful");
          object.put("tweet", "Bye");
          object.saveInBackground();
        }else {
          Log.i("Tweet", "Failed");
        }
      }
    }); */

    /*
    //Advance Queries
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

    query.whereEqualTo("username", "tommy");
    query.setLimit(1);

    query.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {
        if (e == null) {
          Log.i("findInBackground", "Retrieved " + objects.size() + " objects");
          if (objects.size() > 0) {
            for (ParseObject object : objects){
              //Log.i("findInBackgroundResult", object.toString());
              Log.i("findInBackgroundResult", Integer.toString(object.getInt("score")));
            }
          }
        }
      }
    }); */

    /*
    //any score over 200 add 50 points
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
    query.whereGreaterThan("score", 200);
    query.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {
        if (e == null && objects != null) {
          for(ParseObject object : objects) {
            object.put("score", object.getInt("score") + 50);
            object.saveInBackground();
          }
        }
      }
    }); */

    //Parse Users Sign Up
    /*ParseUser user = new ParseUser();
    user.setUsername("thinhman");
    user.setPassword("pass");

    user.signUpInBackground(new SignUpCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          Log.i("Sign Up", "Successful");
        }
        else{
          Log.i("Sign Up", "Failed");
        }
      }
    }); */

    //Login
    /*
    ParseUser.logInInBackground("thinhman", "abcd", new LogInCallback() {
        @Override
        public void done(ParseUser user, ParseException e) {
            if(user != null){
                Log.i("Login", "Successful");
            }
            else{
                Log.i("Login", "Failed: " + e.toString());

            }
        }
    }); */

    //ParseUser.logOut();
    //testing if user is already logged in
    if (ParseUser.getCurrentUser() != null) {
        Log.i("currentUser", "User logged in " + ParseUser.getCurrentUser().getUsername());
    }else {
        Log.i("currentUser", "User not logged in");
    }
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}
