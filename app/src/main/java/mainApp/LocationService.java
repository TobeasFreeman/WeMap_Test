//package mainApp;
//
//import android.Manifest;
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.design.widget.Snackbar;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.util.Log;
//import android.view.View;
//
//public class LocationService implements LocationListener {
//
//    //The minimum distance to change updates in meters
//    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 10 meters
//
//    //The minimum time beetwen updates in milliseconds
//    private static final long MIN_TIME_BW_UPDATES = 0;//1000 * 60 * 1; // 1 minute
//
//    private final static boolean forceNetwork = false;
//
//    private static LocationService instance = null;
//
//    private LocationManager locationManager;
//    public Location location;
//    public double longitude;
//    public double latitude;
//    boolean isGPSEnabled;
//    boolean isNetworkEnabled;
//    boolean locationServiceAvailable;
//
//
//    /**
//     * Singleton implementation
//     * @return
//     */
//    public static LocationService getLocationManager(Context context)     {
//        if (instance == null) {
//            instance = new LocationService(context);
//        }
//        return instance;
//    }
//
//    /**
//     * Local constructor
//     */
//    private LocationService( Context context )     {
//
//        this.initLocationService(context);
//        System.out.println("LocationService created");
//    }
//
//
//
//    /**
//     * Sets up location service after permissions is granted
//     */
//    @TargetApi(23)
//    private void initLocationService(Context context) {
//
//
//        if ( Build.VERSION.SDK_INT >= 23 &&
//                ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
//                ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return  ;
//        }
//
//        try   {
//            this.longitude = 0.0;
//            this.latitude = 0.0;
//            this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//
//                if (MainActivity.) {
//                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
//                            MIN_TIME_BW_UPDATES,
//                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
//                    if (locationManager != null)   {
//                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                        updateCoordinates();
//                    }
//                }
//
//                if (isGPSEnabled)  {
//                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
//                            MIN_TIME_BW_UPDATES,
//                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
//
//                    if (locationManager != null)  {
//                        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//                        String coord = updateCoordinates();
//                    }
//                }
//            }
//        } catch (Exception ex)  {
//            System.out.println( "Error creating location service: " + ex.getMessage() );
//
//        }
//    }
//
//
//    private String updateCoordinates() {
//        Double lon = location.getLongitude();
//        Double lat = location.getLatitude();
//        System.out.println(String.valueOf(lon)+'/'+String.valueOf(lat));
//        return String.valueOf(lon)+'/'+String.valueOf(lat);
//    }
//
//
//    @Override
//    public void onLocationChanged(Location location)     {
//        // do stuff here with location object
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//
//    }
//
//}