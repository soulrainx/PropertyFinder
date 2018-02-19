package common;


import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import test.propertyfinder.com.propertyfinder.propertylist.data.source.remote.PropertyResponse;

public interface PropertyFinderApi {

    String BASE_URL = "https://www.propertyfinder.ae/";

    /**
     * i.e. https://www.propertyfinder.ae/mobileapi?page=3&order=pd
     * <p>
     * Query String param page[0,1,2,3..]
     * <p>
     * Query String param order pd pa bd ba
     * <p>
     * -Price descending
     * -Price ascending
     * -Beds descending
     * -Beds ascending
     */
    @NonNull
    @GET("mobileapi")
    Call<PropertyResponse> getProperties(@Query("page") int pageNumber, @Query("order") String order);
}
