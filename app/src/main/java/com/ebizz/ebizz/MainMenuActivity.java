package com.ebizz.ebizz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * Created by BMS0020 on 5/25/2015.
 */
public class MainMenuActivity extends ActionBarActivity {


    private Drawable mIconCloseSearch;
    private Drawable mIconOpenSearch;
    private EditText mSearchEt;
    private MenuItem mSearchAction;
    private boolean mSearchOpened;
    private String mSearchQuery;
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        // Getting the icons.
        mIconOpenSearch = getResources()
                .getDrawable(R.drawable.ic_action_searched);
        mIconCloseSearch = getResources()
                .getDrawable(R.drawable.ic_action_close);


        if (mSearchOpened) {
            openSearchBar(mSearchQuery);
        }


        this.PrepareActionBar(getSupportActionBar());
    }

    public ActionBar PrepareActionBar(ActionBar actionBar) {
        return PrepareActionBar(actionBar, false);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_provider_list, menu);
        return true;
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

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mSearchAction = menu.findItem(R.id.action_search);
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_search:

                if (mSearchOpened) {
                    closeSearchBar();
                } else {
                    openSearchBar(mSearchQuery);
                }
                break;


            default:
                super.onBackPressed();
                break;
        }
        return true;
    }

    public void onClickFeature (View v)
    {
        int id = v.getId ();

        switch (id) {
            case R.id.home_btn_feature1 :
                startActivity (new Intent(getApplicationContext(), MainActivity.class));
                //Toast.makeText(DashboardActivity.this, "Under Development", Toast.LENGTH_LONG).show();
                break;
            case R.id.home_btn_feature2 :
                //startActivity (new Intent(getApplicationContext(), MemberInfoListActivity.class));
                //Toast.makeText(MainMenuActivity.this, "Under Development", Toast.LENGTH_LONG).show();

                break;
            case R.id.home_btn_feature31 :
                //Toast.makeText(MainMenuActivity.this, "Under Development", Toast.LENGTH_LONG).show();
                startActivity (new Intent(getApplicationContext(), ViewPagerTabActivity.class));
                break;
            case R.id.home_btn_feature41 :
                Toast.makeText(MainMenuActivity.this,"Under Development", Toast.LENGTH_LONG).show();
                //startActivity (new Intent(getApplicationContext(), InboxActivity.class));
                break;
            case R.id.home_btn_feature42 :

                Toast.makeText(MainMenuActivity.this, "Under Construction", Toast.LENGTH_LONG).show();
                break;

            case R.id.home_btn_feature43 :
                //startActivity (new Intent(getApplicationContext(), MainActivity.class));
                //startActivity (new Intent(getApplicationContext(), ExpandedSearchView.class));

                break;
            default:
                Toast.makeText(MainMenuActivity.this, "Under Construction", Toast.LENGTH_LONG).show();
                break;
        }

    }
    private void openSearchBar(String queryText) {

        // Set custom view on action bar.
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.search_bar);

        // Search edit text field setup.
        mSearchEt = (EditText) actionBar.getCustomView()
                .findViewById(R.id.etSearch);
        mSearchEt.addTextChangedListener(new SearchWatcher());
        mSearchEt.setText(queryText);
        mSearchEt.requestFocus();

        // Change search icon accordingly.
        mSearchAction.setIcon(mIconCloseSearch);
        mSearchOpened = true;
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        //actionBar.setIcon(R.drawable.ebluecare_logo_small);
    }

    private void closeSearchBar() {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(false);
        //actionBar.setTitle(Html.fromHtml("<font color='#304F9E'>eBluCare</font>"));
        // Change search icon accordingly.
        mSearchAction.setIcon(mIconOpenSearch);
        mSearchOpened = false;
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }
    private class SearchWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence c, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence c, int i, int i2, int i3) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            mSearchQuery = mSearchEt.getText().toString();

            try {
                if (!mSearchQuery.trim().isEmpty()) {

                    //BusinessFragment homeFragment = (BusinessFragment) getSupportFragmentManager().findFragmentById(R.layout.fragment_business);
                    BusinessFragment homeFragment = (BusinessFragment) getSupportFragmentManager().getFragments().get(0);
                    if (homeFragment != null) {
                        ////((BusinessFragment)getSupportFragmentManager().getFragments().get(0)).adpater.filter(mSearchQuery);
                    }
                }
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(),"TEE", Toast.LENGTH_LONG).show();
                ex.printStackTrace();
            }
        }

    }
}
