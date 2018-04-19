package com.example.administrator.mdtest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private List<Fruit> fruitList;
    private Context tcontext;//记录当前上下文，传给Glide

    public FruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    class FruitViewHolder extends RecyclerView.ViewHolder {
        private ImageView fruitImage;
        private TextView fruitName;
        private CardView cardView;

        public FruitViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            fruitImage = itemView.findViewById(R.id.fruit_imag);
            fruitName = itemView.findViewById(R.id.fruit_nam);

        }
    }


    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (tcontext == null) {
            tcontext = parent.getContext();
        }

        View view = LayoutInflater.from(tcontext).inflate(R.layout.fruit_item, parent, false);

        final FruitViewHolder holder = new FruitViewHolder(view);

         holder.cardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int position = holder.getAdapterPosition();
                 Fruit fruit = fruitList.get(position);

                 Intent intent = new Intent(tcontext,FruitActivity.class);
                // intent.putExtra(FruitActivity.FRUIT_NAME,fruit.getFruitname());
                 //intent.putExtra(FruitActivity.FRUIT_ID,fruit.getImageId());
                 intent.putExtra("fruit_data",fruit);

                 tcontext.startActivity(intent);
             }
         });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {

        Fruit fruit = fruitList.get(position);
        holder.fruitName.setText(fruit.getFruitname());

        //用Glide加载图片
        Glide.with(tcontext).load(fruit.getImageId()).into(holder.fruitImage);

    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }


}
