package pl.polsl.aeiimap.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aleksandrabienioszek on 02.03.2017.
 */

public class Map implements Parcelable {

    public static final Creator<Map> CREATOR = new Creator<Map>() {
        @Override
        public Map createFromParcel(Parcel in) {
            return new Map(in);
        }

        @Override
        public Map[] newArray(int size) {
            return new Map[size];
        }
    };
    private Floor[] floors = new Floor[10];

    protected Map(Parcel in) {
        floors = in.createTypedArray(Floor.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(floors, i);
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }
}
