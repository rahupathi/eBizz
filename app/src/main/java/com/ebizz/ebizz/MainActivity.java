package com.ebizz.ebizz;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener {
    private ViewPager tabsviewPager;
    private ActionBar mActionBar;
    private TabsPagerAdapter mTabsAdapter;
    private MenuItem menuItem;

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
        setContentView(R.layout.activity_main);
        this.PrepareActionBar(getSupportActionBar());
        PrepareTabs();

      // Getting the icons.
       mIconOpenSearch = getResources()
                .getDrawable(R.drawable.ic_action_searched);
        mIconCloseSearch = getResources()
                .getDrawable(R.drawable.ic_action_close);


        if (mSearchOpened) {
            openSearchBar(mSearchQuery);
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


                    BusinessFragment homeFragment =(BusinessFragment)getSupportFragmentManager().getFragments().get(0);
                    if (homeFragment!=null)
                    {
                        homeFragment.adpater.filter(mSearchQuery.trim());
                    }



            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(),"TEE", Toast.LENGTH_LONG).show();
                ex.printStackTrace();
            }
        }

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void PrepareTabs() {

        tabsviewPager = (ViewPager) findViewById(R.id.tabspager);

        mTabsAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        tabsviewPager.setAdapter(mTabsAdapter);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab Business = getSupportActionBar().newTab().setText("Relevance").setTabListener(this);
        ActionBar.Tab Hotels = getSupportActionBar().newTab().setText("Distance").setTabListener(this);
        ActionBar.Tab Alphabeticals = getSupportActionBar().newTab().setText("Alphabeticals").setTabListener(this);
        getSupportActionBar().addTab(Business);
        getSupportActionBar().addTab(Hotels);
        getSupportActionBar().addTab(Alphabeticals);

        String[] tabNames = {"Relevance", "Distance", "Alphabeticals"};

        getSupportActionBar().setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));

        for (int i = 0; i < getSupportActionBar().getTabCount(); i++) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View customView = inflater.inflate(R.layout.tabs_title_style, null);

            //customView.setBackgroundColor(getResources().getColor(R.color.wallet_bright_foreground_holo_light));
            TextView titleTV = (TextView) customView.findViewById(R.id.action_custom_title);
            ImageView imgMenuRecords = (ImageView) customView.findViewById(R.id.imgMenuRecords);
            if (tabNames[i].equalsIgnoreCase("Relevance")) {
                imgMenuRecords.setImageResource(R.drawable.ic_action_relavance);
            } else if (tabNames[i].equalsIgnoreCase("Distance")) {
                imgMenuRecords.setImageResource(R.drawable.ic_action_distance);
            } else if (tabNames[i].equalsIgnoreCase("Alphabeticals")) {
                imgMenuRecords.setImageResource(R.drawable.ic_action_alpha);
            }
            titleTV.setText(tabNames[i]);
            getSupportActionBar().setCustomView(R.layout.tabs_title_style);

            //Here you can also add any other styling you want.
            getSupportActionBar().getTabAt(i).setCustomView(customView);

        }

        //This helps in providing swiping effect for v7 compat library
        tabsviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_provider_list, menu);
        return true;
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

    @Override
    public void onTabReselected(ActionBar.Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub
        //Toast.makeText(MedicalRecords.this, "Reselected!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTabSelected(ActionBar.Tab selectedtab, FragmentTransaction arg1) {
        // TODO Auto-generated method stub
        tabsviewPager.setCurrentItem(selectedtab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }
}
