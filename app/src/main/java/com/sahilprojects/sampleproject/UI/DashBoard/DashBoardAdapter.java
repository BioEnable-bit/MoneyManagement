package com.sahilprojects.sampleproject.UI.DashBoard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sahilprojects.sampleproject.R;
import com.sahilprojects.sampleproject.model.Heads;

import java.util.ArrayList;

public class DashBoardAdapter extends  RecyclerView.Adapter<DashBoardAdapter.ExampleViewHolder> {

    interface onDashItemClicked
    {
        void onItemClicked(String headTitle,int headPercentage,int headAmount,int headUsedAmount, int headRemainingAmount);
    }

    private ArrayList<Heads> heads;
    Heads currentItem;
    private Context context;
    private onDashItemClicked onDashItemClicked;
    private String headsTitle;


    public DashBoardAdapter(ArrayList<Heads> headsArrayList, Context context,onDashItemClicked onDashItemClicked) {
         this.context = context;
        this.heads = headsArrayList;
        this.onDashItemClicked= onDashItemClicked;

    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dlist,
                parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        currentItem = heads.get(position);
        //holder.headsTitle.setText(currentItem.getHeadTitle()+" ("+currentItem.getHeadPercent()+"%)");
        holder.headsTitle.setText(currentItem.getHeadTitle());
        holder.headsAmount.setText(String.valueOf(currentItem.getHeadAmount()));
        holder.headsUsedAmount.setText(String.valueOf(currentItem.getHeadUsedAmount()));
        holder.headsRemainingAmount.setText(String.valueOf(currentItem.getHeadRemainingAmount()));


    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return heads.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TableLayout tableLayout;
        public TextView headsTitle,headsAmount,headsUsedAmount,headsRemainingAmount;
        public RelativeLayout relativeLayout;

        public ExampleViewHolder(View itemView) {
            super(itemView);

            tableLayout = (TableLayout) itemView.findViewById(R.id.table_dash);
            headsTitle = (TextView) itemView.findViewById(R.id.tvHeadTitle);
            headsAmount = (TextView) itemView.findViewById(R.id.tvHeadAmount);
            headsUsedAmount = (TextView) itemView.findViewById(R.id.tvHeadUsedAmount);
            headsRemainingAmount = (TextView) itemView.findViewById(R.id.tvHeadRemainingAmount);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            relativeLayout.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            Heads heads1 = heads.get(getAdapterPosition());

            onDashItemClicked.onItemClicked(heads1.getHeadTitle(),heads1.getHeadPercent(),heads1.getHeadAmount(),heads1.getHeadUsedAmount(),heads1.getHeadRemainingAmount());


        }

    }

    public void filterList(ArrayList<Heads> headsArrayList) {
        heads = headsArrayList;
        notifyDataSetChanged();
    }







}
