package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        itemContainer = (LinearLayout)findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();

        fillItems();
    }

    public void fillItems(){
        int arrImage[] = {
                R.drawable.food01,
                R.drawable.food02,
                R.drawable.food03,
                R.drawable.food04,
                R.drawable.food05
        };

        String arrTitle[] = {
                "음식 1",
                "음식 2",
                "음식 3",
                "음식 4",
                "음식 5"
        };

        String arrPrice[] = {
                "35,000",
                "45,000",
                "55,000",
                "65,000",
                "75,000"
        };

        String arrContent[] = {
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
        };


        for(int i=0; i<5; i++){
            LinearLayout itemLayout = (LinearLayout)layoutInflater.inflate(R.layout.food_item, null);

            ImageView foodImage = (ImageView)itemLayout.findViewById(R.id.foodImage);
            foodImage.setImageResource(arrImage[i]);

            TextView foodTitle = (TextView)itemLayout.findViewById(R.id.foodtitle);
            foodTitle.setText(arrTitle[i]);

            TextView foodPrice = (TextView)itemLayout.findViewById(R.id.foodprice);
            foodPrice.setText(arrPrice[i]);

            TextView foodContent = (TextView)itemLayout.findViewById(R.id.foodcontent);
            foodContent.setText(arrContent[i]);

            itemContainer.addView(itemLayout);
        }

    }

}
