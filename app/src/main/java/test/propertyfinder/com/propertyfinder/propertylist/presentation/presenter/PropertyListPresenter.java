package test.propertyfinder.com.propertyfinder.propertylist.presentation.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.List;

import test.propertyfinder.com.propertyfinder.propertylist.Model.Property;
import test.propertyfinder.com.propertyfinder.propertylist.Model.SortDef;
import test.propertyfinder.com.propertyfinder.propertylist.data.PropertyDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Presenter
 */
public class PropertyListPresenter implements AllPropertiesContract.Presenter {

    // Attached View
    private final AllPropertiesContract.View view;

    private PropertyDataSource propertyDataSource;

    public static @SortDef
    String sortSelection = SortDef.PRICE_ASC;

    public @SortDef
    String searchedSort = null;

    public PropertyListPresenter(@NonNull AllPropertiesContract.View view, @NonNull PropertyDataSource propertyDataSource) {

        this.view = checkNotNull(view, "Attach view cannot be null");
        this.propertyDataSource = checkNotNull(propertyDataSource, "coachDataSourceMain cannot be null");

        this.view.setPresenter(this);
    }


    @Override
    public void loadProperties(int page) {
        view.showProgress(true);

        if (searchedSort != sortSelection)
            view.clearRecyclerAdapter();

        propertyDataSource.getProperties(page, sortSelection, new PropertyDataSource.LoadCoachesCallback() {
            @Override
            public void onPropertiesLoaded(List<Property> properties) {
                view.showProperties(properties);
                view.showProgress(false);

                searchedSort = sortSelection;
            }

            @Override
            public void onNoData() {
                Toast.makeText((Activity) view, "No Data Found", Toast.LENGTH_SHORT).show();
                view.showProgress(false);
            }
        });
    }

    @Override
    public void start() {
        loadProperties(0);
    }

    public static String getSortSelection() {
        return sortSelection;
    }

    public static void setSortSelection(String sortSelection) {
        PropertyListPresenter.sortSelection = sortSelection;
    }
}
