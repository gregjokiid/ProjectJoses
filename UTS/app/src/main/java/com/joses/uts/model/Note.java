package com.joses.uts.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private int id;
    private String tournament;
    private String description;
    private String date;
    private String platform;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.tournament);
        dest.writeString(this.description);
        dest.writeString(this.date);
        dest.writeString(this.platform);
    }

    public Note() {
    }

    public Note(int id, String tournament, String description, String date, String platform) {
        this.id = id;
        this.tournament = tournament;
        this.description = description;
        this.date = date;
        this.platform = platform;
    }

    private Note(Parcel in) {
        this.id = in.readInt();
        this.tournament = in.readString();
        this.description = in.readString();
        this.date = in.readString();
        this.platform = in.readString();
    }

    public static final Parcelable.Creator<Note> CREATOR = new Parcelable.Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel source) {
            return new Note(source);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
