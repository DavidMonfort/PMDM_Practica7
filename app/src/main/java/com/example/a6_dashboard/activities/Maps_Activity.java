package com.example.a6_dashboard.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.a18_mapas.databinding.ActivityMapsBinding;
import com.example.a6_dashboard.R;

public class Maps_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //le devimos que l
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(this, R.raw.style_json)
            );
            if (!success){
                Log.e("mapas", "Existe el recurso pero no lo cargamos bien");
            }
        }catch (Resources.NotFoundException e){
            Log.e("mapas", "No existe le recurso json");
        }


        mMap = googleMap;

        // puedo Selecco0nar el tipo de mapa que queremos en nuestra app
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // me creo la ubicacion de teruel
        LatLng teruel  = new LatLng(40.336139,-1.107440);

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions()
                .position(teruel)
                .title("Marker en teruel")
                //Para cambiarle el color
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        );
        //nOS CREAMOS EL OBJETO LATlONG DE LAS TRES OFICNINAS QUE VAMOS A AÑADIR
        LatLng oficina1 = new LatLng(40.336139,-1.104079);
        LatLng oficina2 = new LatLng(40.331565,-1.107254);
        LatLng oficina3 = new LatLng(40.332114,-1.108394);
        //LAS AÑADIMOS
        mMap.addMarker(
                new MarkerOptions()
                        .position(oficina1)
                        .title("oficina 1")
                        .snippet("tlfo: 987654321")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        );
        mMap.addMarker(
                new MarkerOptions()
                        .position(oficina2)
                        .title("oficina 3")
                        .snippet("tlfo: 9786542541")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        );
        mMap.addMarker(
                new MarkerOptions()
                        .position(oficina3)
                        .title("oficina 3")
                        .snippet("tlfo: 987542365")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLng(teruel));
    }
}