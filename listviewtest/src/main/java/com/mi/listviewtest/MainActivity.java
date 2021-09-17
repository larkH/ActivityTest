package com.mi.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Strawberry", "Cherry", "Mango", "Grape", "Pineapple",
            "Stephen", "Clay", "Damian", "LeBlanc", "Carey", "Kevin", "Alan", "Zedd", "Marshmallow", "Avicii"};
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //数组适配器  第二个参数表示数组中每一条数据的布局是这个View
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, data);

        initFruits();//初始化水果数据
        FruitAdapter adapter = new FruitAdapter(this, R.layout.fruit_item, fruitList);
        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);

        //为ListView每个子项设置监听事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        Fruit apple = new Fruit("Apple", R.drawable.apple);
        fruitList.add(apple);
        Fruit banana = new Fruit("Banana", R.drawable.banana);
        fruitList.add(banana);
        Fruit orange = new Fruit("Orange", R.drawable.orange);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("Pear", R.drawable.pear);
        fruitList.add(pear);
        Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry);
        fruitList.add(strawberry);
        Fruit cherry = new Fruit("Cherry", R.drawable.cherry);
        fruitList.add(cherry);
        Fruit mango = new Fruit("Mango", R.drawable.mango);
        fruitList.add(mango);
        Fruit grape = new Fruit("Grape", R.drawable.grape);
        fruitList.add(grape);
        Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple);
        fruitList.add(pineapple);
        Fruit stephen = new Fruit("Stephen", R.drawable.stephen);
        fruitList.add(stephen);
        Fruit clay = new Fruit("Clay", R.drawable.clay);
        fruitList.add(clay);
        Fruit damian = new Fruit("Damian", R.drawable.damian);
        fruitList.add(damian);
        Fruit leBlanc = new Fruit("LeBlanc", R.drawable.leblanc);
        fruitList.add(leBlanc);
        Fruit carey = new Fruit("Carey", R.drawable.carey);
        fruitList.add(carey);
        Fruit kevin = new Fruit("Kevin", R.drawable.kevin);
        fruitList.add(kevin);
        Fruit alan = new Fruit("Alan", R.drawable.alan);
        fruitList.add(alan);
        Fruit zedd = new Fruit("Zedd", R.drawable.zedd);
        fruitList.add(zedd);
        Fruit marshmallow = new Fruit("Marshmallow", R.drawable.marshmallow);
        fruitList.add(marshmallow);
        Fruit avicii = new Fruit("Avicii", R.drawable.avicii);
        fruitList.add(avicii);
    }
}