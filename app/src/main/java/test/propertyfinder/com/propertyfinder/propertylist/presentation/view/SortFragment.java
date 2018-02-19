package test.propertyfinder.com.propertyfinder.propertylist.presentation.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.propertyfinder.com.propertyfinder.R;
import test.propertyfinder.com.propertyfinder.propertylist.Model.Property;
import test.propertyfinder.com.propertyfinder.propertylist.Model.SortDef;
import test.propertyfinder.com.propertyfinder.propertylist.presentation.presenter.AllPropertiesContract;
import test.propertyfinder.com.propertyfinder.propertylist.presentation.presenter.PropertyListPresenter;
import test.propertyfinder.com.propertyfinder.propertylist.presentation.view.adapter.EndlessScrollListener;
import test.propertyfinder.com.propertyfinder.propertylist.presentation.view.adapter.PropertyListAdapter;

/**
 * Sort Selection Fragment
 */
public class SortFragment extends Fragment {

    public static final String TAG = SortFragment.class.getCanonicalName();

    public SortFragment() {
    }

    public static SortFragment newInstance() {
        return new SortFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sort, container, false);

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.fragment_sort_radiogroup);

        @SortDef String sortDef = PropertyListPresenter.getSortSelection();

        switch (sortDef) {
            case SortDef.BED_ASC:
                radioGroup.check(R.id.fragment_sort_ba);
                break;
            case SortDef.BED_DESC:
                radioGroup.check(R.id.fragment_sort_bd);
                break;
            case SortDef.PRICE_ASC:
                radioGroup.check(R.id.fragment_sort_pa);
                break;
            case SortDef.PRICE_DESC:
                radioGroup.check(R.id.fragment_sort_pd);
                break;

        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.fragment_sort_ba:
                        PropertyListPresenter.setSortSelection(SortDef.BED_ASC);
                        break;
                    case R.id.fragment_sort_bd:
                        PropertyListPresenter.setSortSelection(SortDef.BED_DESC);
                        break;
                    case R.id.fragment_sort_pa:
                        PropertyListPresenter.setSortSelection(SortDef.PRICE_ASC);
                        break;
                    case R.id.fragment_sort_pd:
                        PropertyListPresenter.setSortSelection(SortDef.PRICE_DESC);
                        break;
                }
            }
        });

        getActivity().setTitle(getResources().getString(R.string.sort_selection));

        return view;
    }
}
