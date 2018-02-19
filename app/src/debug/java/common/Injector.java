package common;


import android.content.Context;
import android.support.annotation.NonNull;

import test.propertyfinder.com.propertyfinder.propertylist.data.PropertyDataSource;
import test.propertyfinder.com.propertyfinder.propertylist.data.source.remote.PropertyDataRemote;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Injector
 *
 * Having this utility Injector on a Different Source Set than Main
 * can help us to inject different values for the Data source for
 * example different Data source now from a local Db etc
 */
public class Injector {

    public static PropertyDataSource providePropertyDataSource(@NonNull Context context) {
        checkNotNull(context);
        return PropertyDataRemote.getInstance();
    }
}
