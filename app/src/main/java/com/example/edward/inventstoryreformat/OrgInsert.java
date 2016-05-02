package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Edward on 4/5/2016.
 */
public class OrgInsert extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orginst);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /*
    This is to insert new items to the inventory.
    Parameter View v is needed to check the display.
    Once this button is pressed, it will send the data to the database.
     */
    public void onSubmitButton(View v) {

        if (v.getId() == R.id.BSubmitButton) {
            //we read data from signup
            EditText itemname = (EditText) findViewById(R.id.TFitemname);
            EditText price = (EditText) findViewById(R.id.TFprice);
            EditText quantity = (EditText) findViewById(R.id.TFquantity);
            EditText description = (EditText) findViewById(R.id.TFdescription);

            //convert them to string values
            String itemnamestr = itemname.getText().toString();
            String pricestr = price.getText().toString();
            String quantitystr = quantity.getText().toString();
            String descriptionstr = description.getText().toString();

            //insert to the database
            inventoryorg inv;
            inv = new inventoryorg();
            inv.setItemname(itemnamestr);
            inv.setPrice(pricestr);
            inv.setQuantity(quantitystr);
            inv.setDescription(descriptionstr);

            //this one needs to be enforced.
            helper.insertOrganization(inv);

            //popup message.
            Toast pass = Toast.makeText(OrgInsert.this, "Successfully created.", Toast.LENGTH_SHORT);
            pass.show();

            //'starting new activity.' To start, we need to make object of Intent class
            //This takes back to the 'Organization' after new data is inserted.
            Intent i = new Intent(OrgInsert.this, Organization.class);
            startActivity(i);
        }
    }

    /*
    This is a simple function that takes the user to the previous display, which will be
    first page of 'Organization portion'.
     */
    public void onCancelButton(View v) {

        //In 'OrgInsert' if the user cancelled out on inserting new item.
        if (v.getId() == R.id.BCancelButton) {
            Intent i = new Intent(OrgInsert.this, Organization.class);
            startActivity(i);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "OrgInsert Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.edward.inventstoryreformat/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "OrgInsert Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.edward.inventstoryreformat/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
