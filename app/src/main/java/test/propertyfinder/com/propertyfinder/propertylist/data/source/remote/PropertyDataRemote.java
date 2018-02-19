package test.propertyfinder.com.propertyfinder.propertylist.data.source.remote;

import android.util.Log;

import common.PropertyFinderApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.propertyfinder.com.propertyfinder.propertylist.Model.SortDef;
import test.propertyfinder.com.propertyfinder.propertylist.data.PropertyDataSource;

import static common.PropertyFinderApi.BASE_URL;

/**
 * Implementation of Property Data Source for Remote
 */
public class PropertyDataRemote implements PropertyDataSource {

    private static PropertyDataRemote INSTANCE;
    private Retrofit retrofit;

    public static PropertyDataRemote getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PropertyDataRemote();
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private PropertyDataRemote() {

        // Construct Retrofit
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);
        OkHttpClient okHttpClient = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)//BASE_URL) // Base Url or Domain
                .addConverterFactory(GsonConverterFactory.create()) // Serializer
                .client(okHttpClient) // For logging
                .build();

    }


    @Override
    public void getProperties(int page, @SortDef String sortDef, final LoadCoachesCallback callback) {
        PropertyFinderApi apiService = retrofit.create(PropertyFinderApi.class);

        Call<PropertyResponse> call = apiService.getProperties(page, sortDef);
        call.enqueue(new Callback<PropertyResponse>() {
            @Override
            public void onResponse(Call<PropertyResponse> call, Response<PropertyResponse> response) {
                Log.d("Network", response.message());
                callback.onPropertiesLoaded(response.body().getData());
            }

            @Override
            public void onFailure(Call<PropertyResponse> call, Throwable t) {
                Log.e("Network", t.getMessage());
                callback.onNoData();
            }
        });
    }
}
