package com.mi.listviewtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);//获取当前项的Fruit实例
        //View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        View view;
        ViewHolder viewHolder;

        //convertView用于将之前加载好的布局进行缓存,判断如果为空就重新加载，不为空就用缓存，这样可以大大提高ListView的运行效率
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

            //如果convertView为空，创建实例放入ViewHolder，并将ViewHolder对象存入View中
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = view.findViewById(R.id.iv);
            viewHolder.fruitName = view.findViewById(R.id.tv);
            view.setTag(viewHolder);
        } else {
            view = convertView;

            //如果convertView不为空，就直接从view中取出缓存的ViewHolder对象
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());

        /*ImageView iv = view.findViewById(R.id.iv);
        TextView tv = view.findViewById(R.id.tv);
        iv.setImageResource(fruit.getImageId());
        tv.setText(fruit.getName());*/
        return view;
    }

    /**
     * 对控件的实例进行缓存
     */
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
