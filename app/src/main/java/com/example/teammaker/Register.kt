package com.example.teammaker

class Register(){
    private var nTeams : Int = 1;
    private var teams = ArrayList<Team>();
    private var name : String? = "";
    private var nPlayers : Int = 0;

    fun addTeam(team: Team) {
        this.teams.add(team);
    }
    fun getTeam(pos: Int): Team {
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
    fun setNPlayer(nPlayers: Int) {
        this.nPlayers = nPlayers;
    }
    fun getNPlayer(): Int {
        return nPlayers;
    }

}