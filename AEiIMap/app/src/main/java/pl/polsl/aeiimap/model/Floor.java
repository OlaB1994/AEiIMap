package pl.polsl.aeiimap.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by aleksandrabienioszek on 02.03.2017.
 */

public class Floor implements Parcelable {

    public static final Creator<Floor> CREATOR = new Creator<Floor>() {
        @Override
        public Floor createFromParcel(Parcel in) {
            return new Floor(in);
        }

        @Override
        public Floor[] newArray(int size) {
            return new Floor[size];
        }
    };
    private int id;
    private ArrayList<Room> rooms = new ArrayList<>();

    protected Floor(Parcel in) {
        id = in.readInt();
        rooms = in.createTypedArrayList(Room.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeTypedList(rooms);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoomById(String id) {
        for (Room room : rooms) {
            if (room.getId().equals(id))
                return room;
        }
        return new Room();
    }
}
