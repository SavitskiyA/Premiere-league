package elementrdtesttask.com.elementrdtesttask;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ListAdapter listAdapter;
    private ArrayList<RowModel> rowModels;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmenttwo_layout, null);
        listView = (ListView) v.findViewById(R.id.listView);
        setHasOptionsMenu(true);
        listView.setOnItemClickListener(this);
        listAdapter = new ListAdapter(this, getPlayerModels());
        listView.setAdapter(listAdapter);
        return v;
    }


    private ArrayList<RowModel> getPlayerModels() {
        rowModels = new ArrayList<>();
        List<String> names = Arrays.asList(getActivity().getResources().getStringArray(R.array.arsenalNames));
        List<String> positions = Arrays.asList(getActivity().getResources().getStringArray(R.array.arsenalPositions));
        List<String> numbers = Arrays.asList(getActivity().getResources().getStringArray(R.array.arsenalNumbers));
        TypedArray photos = getActivity().getResources().obtainTypedArray(R.array.arsenalPhotos);

        for (int i = 0; i < names.size(); i++) {
            rowModels.add(new RowModel(names.get(i), positions.get(i), numbers.get(i), photos.getResourceId(i,0)));
        }
        return rowModels;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listAdapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this.getContext(), rowModels.get(position).getName()+ " was pressed", Toast.LENGTH_SHORT).show();
    }
}
