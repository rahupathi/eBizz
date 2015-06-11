package com.ebizz.ebizz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by BMS0020 on 5/19/2015.
 */
public class BusinessAdapter extends BaseAdapter {
    Context fContext;
    LayoutInflater inflater;
    private List<TBusiness> allergyList = null;
    private ArrayList<TBusiness> arrayList;

    public BusinessAdapter(Context context, List<TBusiness> _BusinessList) {
        fContext = context;
        inflater = LayoutInflater.from(context);
        this.allergyList = _BusinessList;
        this.arrayList = new ArrayList<TBusiness>();
        this.arrayList.addAll(allergyList);
    }

    public class ViewHolder {
        TextView tvName, tvAddress, tvCity, tvContactNo;
    }

    @Override
    public int getCount() {
        return allergyList.size();
    }

    @Override
    public Object getItem(int position) {
        return allergyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.business_row, null);
            holder.tvName = (TextView) view.findViewById(R.id.tvName);
            holder.tvAddress = (TextView) view.findViewById(R.id.tvAddress);
            holder.tvCity = (TextView) view.findViewById(R.id.tvCity);
            holder.tvContactNo = (TextView) view.findViewById(R.id.tvContactNo);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tvName.setText(allergyList.get(position).getName());
        holder.tvAddress.setText(allergyList.get(position).getAddress());
        holder.tvCity.setText(allergyList.get(position).getCity());
        holder.tvContactNo.setText(allergyList.get(position).getContactNo());
        return view;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        allergyList.clear();
        if (charText.length() == 0) {
            allergyList.addAll(arrayList);
        } else {
            for (TBusiness wp : arrayList) {
                if (wp.getName().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    allergyList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}