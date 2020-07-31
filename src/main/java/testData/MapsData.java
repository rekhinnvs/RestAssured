package testData;

import mapsPojo.Location;
import mapsPojo.MapAddPlace;

import java.util.ArrayList;

public class MapsData {

    MapAddPlace addPlace;
    Location location;
    public MapAddPlace addAddress(String accuracy, String name, String address) {
        addPlace = new MapAddPlace();
        location = new Location();

        //Create a Map object with the required field.
        location.setLat("-38.383434");
        location.setLng("33.427349");

        addPlace.setLocation(location);
        addPlace.setAccuracy(Integer.parseInt(accuracy));
        addPlace.setName(name);
        addPlace.setPhone_number("(+91) 880 261 3937");
        addPlace.setAddress(address);

        ArrayList<String> typesList = new ArrayList<String>();
        typesList.add("type 1");
        typesList.add("type 2");
        addPlace.setTypes(typesList);
        return addPlace;
    }

}
