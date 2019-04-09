package masterung.th.in.androidthai.mytutorial;

import android.os.Parcel;
import android.os.Parcelable;

class ListVideoModel implements Parcelable {

    private String Detail, Duration, Image, Name;

    public ListVideoModel() {
    }

    public ListVideoModel(String detail, String duration, String image, String name) {
        Detail = detail;
        Duration = duration;
        Image = image;
        Name = name;
    }

    protected ListVideoModel(Parcel in) {
        Detail = in.readString();
        Duration = in.readString();
        Image = in.readString();
        Name = in.readString();
    }

    public static final Creator<ListVideoModel> CREATOR = new Creator<ListVideoModel>() {
        @Override
        public ListVideoModel createFromParcel(Parcel in) {
            return new ListVideoModel(in);
        }

        @Override
        public ListVideoModel[] newArray(int size) {
            return new ListVideoModel[size];
        }
    };

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Detail);
        dest.writeString(Duration);
        dest.writeString(Image);
        dest.writeString(Name);
    }
}