package com.ebizz.ebizz;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by BMS0020 on 5/25/2015.
 */
public class BusinessDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_business_details);
            PrepareActionBar(getSupportActionBar());
            DisplayDetail();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void DisplayDetail()
    {
        TextView tvDetName=(TextView)findViewById(R.id.tvDetName);
        TextView tvDedAddress=(TextView)findViewById(R.id.tvDedAddress);
        TextView tvDetContact=(TextView)findViewById(R.id.tvDetContact);
        TextView tvUrl=(TextView)findViewById(R.id.tvUrl);
        Bundle bBusiness = getIntent().getExtras();
        if (bBusiness != null) {
            TBusiness tBusiness = (TBusiness) bBusiness.getSerializable("Business");
            if (tBusiness != null) {
                tvDetName.setText(tBusiness.getName());
                tvDedAddress.setText(tBusiness.getAddress() + "-" + tBusiness.getCity());
                tvDetContact.setText(tBusiness.getContactNo());
                tvUrl.setText("www." + tBusiness.getName() +".com");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public ActionBar PrepareActionBar(ActionBar actionBar) {
        return PrepareActionBar(actionBar, false);
    }

    public ActionBar PrepareActionBar(ActionBar actionBar, boolean IsBackButtonVisible) {
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#D7DF01")));
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setIcon(R.drawable.ic_action_business_logo);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("eYellow");
        return actionBar;
    }

}
