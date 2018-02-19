package test.propertyfinder.com.propertyfinder.propertylist.presentation.view.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import test.propertyfinder.com.propertyfinder.R;
import test.propertyfinder.com.propertyfinder.propertylist.Model.Property;


/**
 * Adapter for RV Properties
 */
public class PropertyListAdapter extends RecyclerView.Adapter<PropertyListAdapter.PropertyItemViewHolder> {

    ArrayList<Property> properties;

    WeakReference<Resources> resourcesWeakReference;

    public PropertyListAdapter(ArrayList<Property> properties, Resources resourcesWeakReference) {
        this.properties = properties;
        this.resourcesWeakReference = new WeakReference<Resources>(resourcesWeakReference);
    }

    @Override
    public PropertyItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.property_list_row, parent, false);

        return new PropertyItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PropertyItemViewHolder holder, int position) {

        Resources resources = resourcesWeakReference.get();

        Property property = properties.get(position);

        holder.price.setText(resources.getString(R.string.property_list_price_txt, property.getPrice().toString()));
        holder.bedroom.setText(resources.getQuantityString(R.plurals.property_list_numberOfBedrooms, property.getBedrooms(), property.getBedrooms()));
        holder.bathroom.setText(resources.getQuantityString(R.plurals.property_list_numberOfBathrooms, property.getBathrooms(), property.getBathrooms()));
        Glide.with(holder.imageView).load(property.getThumbnail_big()).apply(RequestOptions.centerCropTransform()).apply(RequestOptions.placeholderOf(R.drawable.placeholderimage)).into(holder.imageView);

    }

    public void appendData(List<Property> moreProperties) {
        properties.addAll(moreProperties);
    }

    @Override
    public int getItemCount() {
        return properties.size();
    }

    public class PropertyItemViewHolder extends RecyclerView.ViewHolder {
        public TextView price, bedroom, bathroom;
        public ImageView imageView;

        public PropertyItemViewHolder(View view) {
            super(view);
            price = view.findViewById(R.id.property_list_price);
            bedroom = view.findViewById(R.id.property_list_bedroom);
            bathroom = view.findViewById(R.id.property_list_bath);
            imageView = view.findViewById(R.id.property_list_thumb);
        }
    }
}


