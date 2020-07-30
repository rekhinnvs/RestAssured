package testData;

import mapsPojo.Location;
import mapsPojo.MapAddPlace;

import java.util.ArrayList;

public class MapsData {

    MapAddPlace addPlace;
    Location location;
    public MapAddPlace addAddress() {
        addPlace = new MapAddPlace();
        location = new Location();

        //Create a Map object with the required field.
        location.setLat("-38.383434");
        location.setLng("33.427349");

        addPlace.setLocation(location);
        addPlace.setAccuracy(45);
        addPlace.setName("BackLine house");
        addPlace.setPhone_number("(+91) 880 261 3937");
        addPlace.setAddress("30, side layout, cohen 24");

        ArrayList<String> typesList = new ArrayList<String>();
        typesList.add("type 1");
        typesList.add("type 2");
        addPlace.setTypes(typesList);
        return addPlace;
    }

}
