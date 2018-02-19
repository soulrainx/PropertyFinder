package test.propertyfinder.com.propertyfinder.propertylist.presentation.presenter;

import java.util.List;

import common.BasePresenter;
import common.BaseView;
import test.propertyfinder.com.propertyfinder.propertylist.Model.Property;

/**
 * Represent Contract for Actions Presenter will perform called by View and Vice versa
 */
public interface AllPropertiesContract {

    // Operations performed by View
    interface View extends BaseView<Presenter> {

        void showProperties(List<Property> coaches);

        void showProgress(boolean show);

        void clearRecyclerAdapter();

    }

    // Operations Presenter should perform
    interface Presenter extends BasePresenter {

        void loadProperties(int page);
    }
}
