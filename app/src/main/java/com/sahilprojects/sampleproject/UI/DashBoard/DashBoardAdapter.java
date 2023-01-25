package com.sahilprojects.sampleproject.UI.DashBoard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sahilprojects.sampleproject.R;
import com.sahilprojects.sampleproject.model.Heads;

import java.util.ArrayList;

public class DashBoardAdapter extends  RecyclerView.Adapter<DashBoardAdapter.ExampleViewHolder> {


    private ArrayList<Heads> heads;
    private Context context;

    public DashBoardAdapter(ArrayList<Heads> headsArrayList, Context context) {
         this.context = context;
        this.heads = headsArrayList;
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
        Heads currentItem = heads.get(position);
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

        public TextView headsTitle,headsAmount,headsUsedAmount,headsRemainingAmount;
        public RelativeLayout relativeLayout;

        public ExampleViewHolder(View itemView) {
            super(itemView);

            headsTitle = (TextView) itemView.findViewById(R.id.tvHeadTitle);
            headsAmount = (TextView) itemView.findViewById(R.id.tvHeadAmount);
            headsUsedAmount = (TextView) itemView.findViewById(R.id.tvHeadUsedAmount);
            headsRemainingAmount = (TextView) itemView.findViewById(R.id.tvHeadRemainingAmount);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            relativeLayout.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
        //    Drivers driver = drivers.get(getAdapterPosition());
            // passData(driver.getDriverID(),driver.getAdminID(), driver.getName(), driver.getAddress(), driver.getMobile(), driver.getPassword(), driver.getIsActive());
        }
    }





//    private void passData(int driverID,int adminID,String name, String address,String mobile,String password, int isActive) {
//
//        Intent intent = new Intent(context, Driver.class);
//        intent.putExtra("operation", "update");
//        intent.putExtra("driverID", driverID);
//        intent.putExtra("adminID", adminID);
//        intent.putExtra("name", name);
//        intent.putExtra("address", address);
//        intent.putExtra("mobile", mobile);
//        intent.putExtra("password", password);
//        intent.putExtra("isActive", isActive);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);    }



    public void filterList(ArrayList<Heads> headsArrayList) {
        heads = headsArrayList;
        notifyDataSetChanged();
    }
}
