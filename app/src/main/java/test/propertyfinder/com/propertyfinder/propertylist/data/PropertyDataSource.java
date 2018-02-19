package test.propertyfinder.com.propertyfinder.propertylist.data;

import java.util.List;

import test.propertyfinder.com.propertyfinder.propertylist.Model.Property;
import test.propertyfinder.com.propertyfinder.propertylist.Model.SortDef;

/**
 * Interface Representing a Data Source
 * <p>
 * Can be implemented by a Remote or a Local Data source
 */
public interface PropertyDataSource {

    // Callback for Remote call
    interface LoadCoachesCallback {
        void onPropertiesLoaded(List<Property> coaches);

        void onNoData();
    }

    void getProperties(int page, @SortDef String sortDef, LoadCoachesCallback callback);

}
