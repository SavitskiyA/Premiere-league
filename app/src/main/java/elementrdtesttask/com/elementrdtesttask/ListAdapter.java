package elementrdtesttask.com.elementrdtesttask;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrey on 18.04.2017.
 */

public class ListAdapter extends BaseAdapter implements Filterable {
    private LayoutInflater inflater;

    private TextView textViewName;
    private TextView textViewPosition;
    private TextView textViewNumber;
    private ImageView imageViewPhoto;
    private LinearLayout linearLayout;
    private ArrayList<RowModel> players;
    private ArrayList<RowModel> filteredPlayers;
    private CustomFilter customFilter;
    private Fragment fragment;

    public ListAdapter(Fragment fragment, ArrayList<RowModel> players) {
        this.fragment = fragment;
        this.inflater = (LayoutInflater) fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.players = players;
        this.filteredPlayers = players;

    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int position) {
       return  players.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = inflater.inflate(R.layout.row_layout, null);

        linearLayout = (LinearLayout) v.findViewById(R.id.linearLayout);
        if(fragment instanceof FragmentOne) {
            linearLayout.setBackgroundColor(fragment.getActivity().getResources().getColor(R.color.arsenalRed));
        }else {
            linearLayout.setBackgroundColor(fragment.getActivity().getResources().getColor(R.color.chelseaBlue));
        }

        textViewName = (TextView) v.findViewById(R.id.textViewName);
        textViewPosition = (TextView) v.findViewById(R.id.textViewPosition);
        textViewNumber = (TextView) v.findViewById(R.id.textViewNumber);
        imageViewPhoto = (ImageView) v.findViewById(R.id.imageViewPhoto);

        textViewName.setText(players.get(position).getName());
        textViewPosition.setText(players.get(position).getPosition());
        textViewNumber.setText(players.get(position).getNumber());
        imageViewPhoto.setBackgroundResource(players.get(position).getPhoto());

        return v;
    }

    @Override
    public Filter getFilter() {
        if(customFilter==null){
            customFilter = new CustomFilter();
        }
        return customFilter;
    }

    class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();

            if(constraint!=null&&constraint.length()>0){
                constraint=constraint.toString().toUpperCase();
                ArrayList<RowModel> filters = new ArrayList<>();

                for(int i=0; i<filteredPlayers.size();i++){
                    if(filteredPlayers.get(i).getName().toUpperCase().contains(constraint)){
                        filters.add(new RowModel(filteredPlayers.get(i).getName(), filteredPlayers.get(i).getPosition(), filteredPlayers.get(i).getNumber(), filteredPlayers.get(i).getPhoto()));
                    }
                    if(filteredPlayers.get(i).getPosition().toUpperCase().contains(constraint)){
                        filters.add(new RowModel(filteredPlayers.get(i).getName(), filteredPlayers.get(i).getPosition(), filteredPlayers.get(i).getNumber(), filteredPlayers.get(i).getPhoto()));
                    }
                    if(filteredPlayers.get(i).getNumber().toUpperCase().contains(constraint)){
                        filters.add(new RowModel(filteredPlayers.get(i).getName(), filteredPlayers.get(i).getPosition(), filteredPlayers.get(i).getNumber(), filteredPlayers.get(i).getPhoto()));
                    }

                }
                filterResults.count = filters.size();
                filterResults.values = filters;
            } else{
                filterResults.count = filteredPlayers.size();
                filterResults.values = filteredPlayers;
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            players = (ArrayList<RowModel>) results.values;
            notifyDataSetChanged();
        }
    }


}
