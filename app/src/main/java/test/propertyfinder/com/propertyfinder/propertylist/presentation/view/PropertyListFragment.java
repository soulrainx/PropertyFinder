package test.propertyfinder.com.propertyfinder.propertylist.presentation.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.propertyfinder.com.propertyfinder.R;
import test.propertyfinder.com.propertyfinder.propertylist.Model.Property;
import test.propertyfinder.com.propertyfinder.propertylist.presentation.presenter.AllPropertiesContract;
import test.propertyfinder.com.propertyfinder.propertylist.presentation.view.adapter.EndlessScrollListener;
import test.propertyfinder.com.propertyfinder.propertylist.presentation.view.adapter.PropertyListAdapter;

/**
 * Property List activity
 */
public class PropertyListFragment extends Fragment implements AllPropertiesContract.View {

    public static final String TAG = PropertyListFragment.class.getCanonicalName();

    private RecyclerView recyclerView;
    private PropertyListAdapter mAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private EndlessScrollListener endlessScrollListener;

    AllPropertiesContract.Presenter presenter;

    ArrayList<Property> properties = new ArrayList<>();

    public PropertyListFragment() {
    }

    public static PropertyListFragment newInstance() {
        return new PropertyListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_property_list, container, false);
        recyclerView = view.findViewById(R.id.property_list_rv);
        swipeRefreshLayout = view.findViewById(R.id.property_list_swipe_refresh);

        mAdapter = new PropertyListAdapter(properties, getResources());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // Retain an instance so that you can call `resetState()` for fresh searches
        endlessScrollListener = new EndlessScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                presenter.loadProperties(page);
            }
        };
        // Adds the scroll listener to RecyclerView
        recyclerView.addOnScrollListener(endlessScrollListener);

        getActivity().setTitle("List");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void showProperties(List<Property> properties) {
        mAdapter.appendData(properties);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void clearRecyclerAdapter() {
        properties.clear();
    }

    @Override
    public void showProgress(boolean show) {
        swipeRefreshLayout.setRefreshing(show);
    }

    @Override
    public void setPresenter(AllPropertiesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
