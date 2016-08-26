package com.agroho.fruit;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomList extends BaseAdapter {

    Context context;
    List<Fruit> fruits;
    LayoutInflater inflater;

    CustomList(Context context, List<Fruit> fruits){

        this.context = context;
        this.fruits = fruits;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Object getItem(int i) {
        return fruits.get(i);
    }

    @Override
    public long getItemId(int i) {
        return fruits.get(i).getFruitId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.fruititem,parent,false);

            holder.fruitTitleTextView = (TextView)convertView.findViewById(R.id.fruitTitle);
            holder.fruitSummaryTextView = (TextView)convertView.findViewById(R.id.fruitSummary);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        Fruit fruit = fruits.get(i);
        holder.fruitTitleTextView.setText(fruit.getFruitName());
        holder.fruitSummaryTextView.setText(fruit.getFruitSummary());

        return convertView;
    }

    private class ViewHolder{

        TextView fruitTitleTextView;
        TextView fruitSummaryTextView;


    }
}