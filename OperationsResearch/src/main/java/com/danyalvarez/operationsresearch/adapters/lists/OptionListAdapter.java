package com.danyalvarez.operationsresearch.adapters.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.danyalvarez.operationsresearch.R;
import com.danyalvarez.operationsresearch.classes.Option;

import java.util.ArrayList;

/**
 * @author Daniel Alvarez
 */
public class OptionListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Option> mData;

    public OptionListAdapter(Context mContext) {
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mData = new ArrayList<Option>();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item_option, null);
            viewHolder =  new ViewHolder();

            viewHolder.titleText = (TextView) convertView.findViewById(R.id.titleText);
            viewHolder.descriptionText = (TextView) convertView.findViewById(R.id.descriptionText);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Option option = mData.get(position);
        viewHolder.titleText.setText(option.getTitle());
        viewHolder.descriptionText.setText(option.getDescription());

        return convertView;
    }

    static class ViewHolder {
        TextView titleText;
        TextView descriptionText;
    }

    public void addItem(String title, String description) {
        mData.add(new Option(title, description));
        notifyDataSetChanged();
    }

    public void addItem(String titleSection, String title, String description) {
        mData.add(new Option(titleSection, title, description));
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }
}
