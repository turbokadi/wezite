package ca.wezite.wezite.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ca.wezite.wezite.HomeActivity;
import ca.wezite.wezite.InfosParcoursActivity;
import ca.wezite.wezite.R;
import ca.wezite.wezite.model.Parcours;

public class ParcourListAdaptor extends RecyclerView.Adapter<ParcourListAdaptor.VignetteHolder> {

    private Context mContext;
    private List<Parcours> parcoursList;

    public class VignetteHolder extends RecyclerView.ViewHolder {
        public FrameLayout parentLayout;
        public ImageView img;
        public TextView title, desc, distance, duree;

        public VignetteHolder(View view) {
            super(view);
            parentLayout = (FrameLayout) view.findViewById(R.id.headVignette);
            img = (ImageView) view.findViewById(R.id.imageView);
            title = (TextView) view.findViewById(R.id.titleParcourVignette);
            desc = (TextView) view.findViewById(R.id.descParcourVignette);
            distance = (TextView) view.findViewById(R.id.distanceParcourVignette);
            duree = (TextView) view.findViewById(R.id.dureeParcourVignette);
        }
    }

    public ParcourListAdaptor(Context context, List<Parcours> parcourList) {
        this.parcoursList = parcourList;
        this.mContext = context;
    }

    @Override
    public VignetteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.parcour_vignette, parent, false);
        return new VignetteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VignetteHolder holder, int position) {
        final Parcours parcours = parcoursList.get(position);
        holder.title.setText(parcours.getName());
        holder.desc.setText(parcours.getDescription());
        holder.duree.setText(((int)parcours.getDuree()/60)+" min");
        int distance = (int)parcours.getDistance();
        if(distance >= 2500){
            holder.distance.setText(Double.toString((distance-distance%100)/1000.0)+" Km");
        } else {
            holder.distance.setText(Integer.toString(distance)+" m");
        }

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, InfosParcoursActivity.class);
                intent.putExtra("id_parcours", parcours.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return parcoursList.size();
    }

}