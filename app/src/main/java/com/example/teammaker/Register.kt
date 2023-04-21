package com.example.teammaker
import android.os.Parcel
import android.os.Parcelable

class Register() : Parcelable {
    private var nTeams : Int = 0;
    private var teams = ArrayList<Team>();
    private var name : String? = "";

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
    }

    fun addTeam(team: Team) {
        this.teams.add(team);
    }
    fun getPlayer(pos: Int): Team {
        return teams[pos];
    }
    fun getNTeams(): Int? {
        return nTeams;
    }
    fun minusTeam(){
        this.nTeams--;
    }
    fun plusTeam(){
        this.nTeams++;
    }
    fun getName(): String?{
        return this.name;
    }

    fun setName(name : String){
        this.name = name;
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(nTeams)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Register> {
        override fun createFromParcel(parcel: Parcel): Register {
            return Register(parcel)
        }

        override fun newArray(size: Int): Array<Register?> {
            return arrayOfNulls(size)
        }
    }
}