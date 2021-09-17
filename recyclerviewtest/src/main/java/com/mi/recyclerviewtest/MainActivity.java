package com.mi.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();
        RecyclerView rv = findViewById(R.id.rv);

        //线性布局
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        //瀑布流布局
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        rv.setLayoutManager(layoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        rv.setAdapter(fruitAdapter);
    }

    private void initFruits() {
        //Fruit apple = new Fruit("Apple", R.drawable.apple);
        Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple);
        fruitList.add(apple);
        //Fruit banana = new Fruit("Banana", R.drawable.banana);
        Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.banana);
        fruitList.add(banana);
        //Fruit orange = new Fruit("Orange", R.drawable.orange);
        Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.orange);
        fruitList.add(orange);
        //Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon);
        Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon);
        fruitList.add(watermelon);
        //Fruit pear = new Fruit("Pear", R.drawable.pear);
        Fruit pear = new Fruit(getRandomLengthName("Pear"), R.drawable.pear);
        fruitList.add(pear);
        //Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry);
        Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry);
        fruitList.add(strawberry);
        //Fruit cherry = new Fruit("Cherry", R.drawable.cherry);
        Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.drawable.cherry);
        fruitList.add(cherry);
        //Fruit mango = new Fruit("Mango", R.drawable.mango);
        Fruit mango = new Fruit(getRandomLengthName("Mango"), R.drawable.mango);
        fruitList.add(mango);
        //Fruit grape = new Fruit("Grape", R.drawable.grape);
        Fruit grape = new Fruit(getRandomLengthName("Grape"), R.drawable.grape);
        fruitList.add(grape);
        //Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple);
        Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple);
        fruitList.add(pineapple);
        //Fruit stephen = new Fruit("Stephen", R.drawable.stephen);
        Fruit stephen = new Fruit(getRandomLengthName("Stephen"), R.drawable.stephen);
        fruitList.add(stephen);
        //Fruit clay = new Fruit("Clay", R.drawable.clay);
        Fruit clay = new Fruit(getRandomLengthName("Clay"), R.drawable.clay);
        fruitList.add(clay);
        //Fruit damian = new Fruit("Damian", R.drawable.damian);
        Fruit damian = new Fruit(getRandomLengthName("Damian"), R.drawable.damian);
        fruitList.add(damian);
        //Fruit leBlanc = new Fruit("LeBlanc", R.drawable.leblanc);
        Fruit leBlanc = new Fruit(getRandomLengthName("LeBlanc"), R.drawable.leblanc);
        fruitList.add(leBlanc);
        //Fruit carey = new Fruit("Carey", R.drawable.carey);
        Fruit carey = new Fruit(getRandomLengthName("Carey"), R.drawable.carey);
        fruitList.add(carey);
        //Fruit kevin = new Fruit("Kevin", R.drawable.kevin);
        Fruit kevin = new Fruit(getRandomLengthName("Kevin"), R.drawable.kevin);
        fruitList.add(kevin);
        //Fruit alan = new Fruit("Alan", R.drawable.alan);
        Fruit alan = new Fruit(getRandomLengthName("Alan"), R.drawable.alan);
        fruitList.add(alan);
        //Fruit zedd = new Fruit("Zedd", R.drawable.zedd);
        Fruit zedd = new Fruit(getRandomLengthName("Zedd"), R.drawable.zedd);
        fruitList.add(zedd);
        //Fruit marshmallow = new Fruit("Marshmallow", R.drawable.marshmallow);
        Fruit marshmallow = new Fruit(getRandomLengthName("Marshmallow"), R.drawable.marshmallow);
        fruitList.add(marshmallow);
        //Fruit avicii = new Fruit("Avicii", R.drawable.avicii);
        Fruit avicii = new Fruit(getRandomLengthName("Avicii"), R.drawable.avicii);
        fruitList.add(avicii);
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}