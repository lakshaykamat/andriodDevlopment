package com.lakshaykamat.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Contacts[] localDataSet;
    private TextView usrName;
    private TextView phoneNum;
    private ImageView usrImg;
    private int imageNum;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.usrName);
        }

        public TextView getTextView() {return textView;}
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * //@param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    //Custom adapter arguments passes here
    public CustomAdapter(Contacts[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contacts_row, viewGroup, false);
        usrName = view.findViewById(R.id.usrName);
        phoneNum = view.findViewById(R.id.phoneNum);
        usrImg = view.findViewById(R.id.imageView);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
       // viewHolder.getTextView().setText((CharSequence) localDataSet[position]);
        usrName.setText(localDataSet[position].userName);
        phoneNum.setText(localDataSet[position].phoneNumber);
        usrImg.setImageResource(localDataSet[position].usrImg);
        //usrImg.setImageResource(R.drawable.deafultusrimage);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
