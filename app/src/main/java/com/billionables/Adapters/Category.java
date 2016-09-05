package com.billionables.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.billionables.R;
import com.billionables.Utils.BillionablesUtils;
import com.billionables.Utils.Constants;
import com.billionables.Utils.Intents;

import java.util.List;

/**
 * Created by Nidhi on 26-07-2016.
 */
public class Category extends RecyclerView.Adapter<Category.ViewHolder> {
    List<com.billionables.Models.Category> categoryList;
    Context context;

    public Category(List<com.billionables.Models.Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @Override
    public Category.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category, parent, false));
    }

    @Override
    public void onBindViewHolder(Category.ViewHolder holder, int position) {
        holder.imgCategory.setImageResource(categoryList.get(position).getImage());
        holder.txtCategory.setText(categoryList.get(position).getName());
        holder.imgCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intents.callCategorySelection(context);

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategory;
        TextView txtCategory;

        public ViewHolder(View itemView) {
            super(itemView);
            imgCategory = (ImageView) itemView.findViewById(R.id.imgCategory);
            txtCategory = (TextView) itemView.findViewById(R.id.txtCategory);
            Typeface typeface = BillionablesUtils.getSansFont(context, Constants.FONT_TYPE_REGULAR);
            txtCategory.setTypeface(typeface);
        }
    }
}
