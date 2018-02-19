package test.propertyfinder.com.propertyfinder.propertylist.data.source.remote;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import test.propertyfinder.com.propertyfinder.propertylist.Model.Property;

/**
 * Response from Endpoint
 */
public class PropertyResponse {

    @Nullable
    @SerializedName("res")
    @Expose
    private List<Property> data = null;

    @Nullable
    @SerializedName("total")
    @Expose
    private Integer total;

    @Nullable
    public List<Property> getData() {
        return data;
    }

    public void setData(@Nullable List<Property> data) {
        this.data = data;
    }
}
