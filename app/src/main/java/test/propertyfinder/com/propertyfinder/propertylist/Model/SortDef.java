package test.propertyfinder.com.propertyfinder.propertylist.Model;


import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;
import static test.propertyfinder.com.propertyfinder.propertylist.Model.SortDef.BED_ASC;
import static test.propertyfinder.com.propertyfinder.propertylist.Model.SortDef.PRICE_ASC;
import static test.propertyfinder.com.propertyfinder.propertylist.Model.SortDef.PRICE_DESC;

@Retention(SOURCE)
@StringDef({PRICE_DESC, PRICE_ASC, BED_ASC, BED_ASC})
public @interface SortDef {

    /**
     * -Price descending
     * -Price ascending
     * -Beds descending
     * -Beds ascending
     */

    String PRICE_DESC = "pd";
    String PRICE_ASC = "pa";
    String BED_DESC = "bd";
    String BED_ASC = "ba";
}
