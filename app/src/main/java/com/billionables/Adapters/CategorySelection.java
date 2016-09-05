package com.billionables.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.billionables.R;
import com.billionables.Utils.BillionablesUtils;
import com.billionables.Utils.CircleTransform;
import com.billionables.Utils.Constants;
import com.billionables.Utils.Intents;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Nidhi on 28-07-2016.
 */
public class CategorySelection extends RecyclerView.Adapter<CategorySelection.ViewHolder> {
    Context context;
    List<com.billionables.Models.CategorySelection> categorySelectionList;

    public CategorySelection(List<com.billionables.Models.CategorySelection> categorySelectionList, Context context) {
        this.categorySelectionList = categorySelectionList;
        this.context = context;
    }

    @Override
    public CategorySelection.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category_select, parent, false));
    }

    @Override
    public void onBindViewHolder(CategorySelection.ViewHolder holder, int position) {
        final String pageName = categorySelectionList.get(position).getPlaceName();
        final String pageAddress = categorySelectionList.get(position).getAddress();
        Picasso.with(context).load(R.drawable.v3s).transform(new CircleTransform()).into(holder.imgPageImage);
        holder.txtPageName.setText(pageName);
        holder.txtPageAddress.setText(pageAddress);
        holder.txtDistance.setText(categorySelectionList.get(position).getDistance());
        holder.txtPageCategory.setText(categorySelectionList.get(position).getPlaceCategory());
        holder.cardPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intents.callPageDetail(context,pageName,pageAddress );
            }
        });


    }

    @Override
    public int getItemCount() {
        return categorySelectionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPageImage;
        TextView txtPageName;
        TextView txtPageCategory;
        TextView txtPageAddress;
        TextView txtDistance;
        ImageView imgBookMark;
        Typeface typefaceRegular;
        CardView cardPage;

        public ViewHolder(View itemView) {
            super(itemView);
            imgPageImage = (ImageView) itemView.findViewById(R.id.imgPageImage);
            txtPageName = (TextView) itemView.findViewById(R.id.txtPageName);
            txtPageCategory = (TextView) itemView.findViewById(R.id.txtPageCategory);
            txtPageAddress = (TextView) itemView.findViewById(R.id.txtPageAddress);
            txtDistance = (TextView) itemView.findViewById(R.id.txtDistance);
            typefaceRegular = BillionablesUtils.getSansFont(context, Constants.FONT_TYPE_REGULAR);
            cardPage = (CardView) itemView.findViewById(R.id.cardPage);
            initFonts();

        }


        private void initFonts() {
            txtPageName.setTypeface(typefaceRegular);
            txtPageAddress.setTypeface(typefaceRegular);
            txtDistance.setTypeface(typefaceRegular);
            txtPageCategory.setTypeface(typefaceRegular);
        }
    }


}
