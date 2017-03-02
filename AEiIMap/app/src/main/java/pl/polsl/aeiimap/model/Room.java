package pl.polsl.aeiimap.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aleksandrabienioszek on 02.03.2017.
 */

public class Room implements Parcelable {

    private int id;
    private String name;
    private String owner;
    private String description;
    private String imagePath;
    private int type;


    protected Room(Parcel in) {
        id = in.readInt();
        name = in.readString();
        owner = in.readString();
        description = in.readString();
        imagePath = in.readString();
        type = in.readInt();
    }

    public static final Creator<Room> CREATOR = new Creator<Room>() {
        @Override
        public Room createFromParcel(Parcel in) {
            return new Room(in);
        }

        @Override
        public Room[] newArray(int size) {
            return new Room[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(owner);
        parcel.writeString(description);
        parcel.writeString(imagePath);
        parcel.writeInt(type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
