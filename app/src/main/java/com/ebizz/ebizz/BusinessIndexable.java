package com.ebizz.ebizz;

/**
 * Created by BMS0020 on 5/29/2015.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;

public class BusinessIndexable extends Fragment{
    View view;
    private ArrayList<String> mItems;
    private IndexableListView mListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_indexable, container, false);
        mItems = new ArrayList<String>();
        mItems.add("I-Nack Solution");
        mItems.add("Arabian Tech Solution");
        mItems.add("B-tex Business Solutions");
        mItems.add("I-Nack Solutions");
        mItems.add("Art_Mells Technologies");
        mItems.add("Ascot Tech. Solutions");
        mItems.add("Authentic eBizz Solutions");
        mItems.add("Apple Inc");
        mItems.add("MicroSoft inc");
        mItems.add("The LEGO Ideas Books Stores");
        mItems.add("Explosive Eighteen Tech");
        mItems.add("Catching Fire Solutions");
        mItems.add("Elder Scrolls Value Solutions");
        Collections.sort(mItems);

        ContentAdapter adapter = new ContentAdapter(this.getActivity(),
                android.R.layout.simple_list_item_1, mItems);

        mListView = (IndexableListView)view.findViewById(R.id.listview);
        mListView.setAdapter(adapter);
        mListView.setFastScrollEnabled(true);

        return view;
    }
    private class ContentAdapter extends ArrayAdapter<String> implements SectionIndexer {

        private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public ContentAdapter(Context context, int textViewResourceId,
                              List<String> objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public int getPositionForSection(int section) {
            // If there is no item for current section, previous section will be selected
            for (int i = section; i >= 0; i--) {
                for (int j = 0; j < getCount(); j++) {
                    if (i == 0) {
                        // For numeric section
                        for (int k = 0; k <= 9; k++) {
                            if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)), String.valueOf(k)))
                                return j;
                        }
                    } else {
                        if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)), String.valueOf(mSections.charAt(i))))
                            return j;
                    }
                }
            }
            return 0;
        }

        @Override
        public int getSectionForPosition(int position) {
            return 0;
        }

        @Override
        public Object[] getSections() {
            String[] sections = new String[mSections.length()];
            for (int i = 0; i < mSections.length(); i++)
                sections[i] = String.valueOf(mSections.charAt(i));
            return sections;
        }
    }

}
