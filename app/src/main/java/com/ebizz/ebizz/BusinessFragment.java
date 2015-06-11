package com.ebizz.ebizz;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by BMS0020 on 5/22/2015.
 */
public class BusinessFragment extends Fragment {

    public ListView lvBusiness;
    public ArrayList<TBusiness> lstBusiness = new ArrayList<TBusiness>();
    public BusinessAdapter adpater;
    private Drawable mIconCloseSearch;
    private Drawable mIconOpenSearch;
    private EditText mSearchEt;
    private MenuItem mSearchAction;
    private boolean mSearchOpened;
    private String mSearchQuery;
    private SearchView search;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_business, container, false);

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Generate list View from ArrayList
        lvBusiness = (ListView) view.findViewById(R.id.lvBusiness);
        LoadBusiness();

        // Getting the icons.
       /* mIconOpenSearch = getResources()
                .getDrawable(R.drawable.ic_action_searched);
        mIconCloseSearch = getResources()
                .getDrawable(R.drawable.ic_action_close);

        if (mSearchOpened) {
            openSearchBar(mSearchQuery);
        }
        setHasOptionsMenu(true);
        */
    }

    private void LoadBusiness() {

        TBusiness tBusiness = new TBusiness();
        tBusiness.setName("I-Nack Solutions");
        tBusiness.setAddress("12 Reid Street");
        tBusiness.setCity("Hamilton- HM11");
        tBusiness.setContactNo("(441)291-1526");
        lstBusiness.add(tBusiness);

        tBusiness = new TBusiness();
        tBusiness.setName("Arabian Tech Solution");
        tBusiness.setAddress("53 court street");
        tBusiness.setCity("Hamilton-12");
        tBusiness.setContactNo("(441)263-5226");
        lstBusiness.add(tBusiness);

        tBusiness = new TBusiness();
        tBusiness.setName("B-tex Business Solutions");
        tBusiness.setAddress("25 Somerset Road");
        tBusiness.setCity("MA02- HM52");
        tBusiness.setContactNo("(441)234-9656");
        lstBusiness.add(tBusiness);

        tBusiness = new TBusiness();
        tBusiness.setName("I-Nack Solutions");
        tBusiness.setAddress("12 Reid Street");
        tBusiness.setCity("Hamilton- HM11");
        tBusiness.setContactNo("(441)291-1526");
        lstBusiness.add(tBusiness);

        tBusiness = new TBusiness();
        tBusiness.setName("Art_Mells Technologies");
        tBusiness.setAddress("9th Str, Monica road");
        tBusiness.setCity("Hamilton- HM 14");
        tBusiness.setContactNo("(441)325-15226");
        lstBusiness.add(tBusiness);

        tBusiness = new TBusiness();
        tBusiness.setName("Ascot Tech. Solutions");
        tBusiness.setAddress("21 Rosemount Avenue");
        tBusiness.setCity("Hamilton- HM06");
        tBusiness.setContactNo("(441)291-1526");
        lstBusiness.add(tBusiness);

        tBusiness = new TBusiness();
        tBusiness.setName("Authentic eBizz Solutions");
        tBusiness.setAddress("33 countryStreet");
        tBusiness.setCity("Hamilton- HM 11");
        tBusiness.setContactNo("(441)125-8526");
        lstBusiness.add(tBusiness);

        adpater = new BusinessAdapter(getActivity().getApplicationContext(), lstBusiness);
        lvBusiness.setAdapter(adpater);
        PrepareVitalSignItemClick(getActivity().getApplicationContext());

    }

    private void PrepareVitalSignItemClick(final Context context) {

        lvBusiness.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final TBusiness tBusiness = (TBusiness) parent.getItemAtPosition(position);
                if (tBusiness != null) {
                    Bundle b = new Bundle();
                    b.putSerializable("Business", tBusiness);
                    Intent iBusiness = new Intent(context, BusinessDetailActivity.class);
                    iBusiness.putExtras(b);
                    startActivity(iBusiness);
                }
            }
        });
    }


  /*  @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_provider_list, menu);
        MenuItem searchItem = menu.findItem(R.id.search_bar);
        mSearchAction = menu.findItem(R.id.action_search);
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

                adpater.filter(mSearchQuery.trim());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
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
                break;
        }
        return true;
    }*/
   /* private void closeSearchBar() {

        ActionBar actionBar = actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(false);
        mSearchAction.setIcon(mIconOpenSearch);
        mSearchOpened = false;
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    private void openSearchBar(String queryText) {

        // Set custom view on action bar.
        ActionBar actionBar = actionBar = ((MainActivity)getActivity()).getSupportActionBar();
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
    }*/
}

