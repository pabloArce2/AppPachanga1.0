package com.example.teammaker

class register (nTeams: Int){
    private var nTeams : Int = 0;
    private var teams = ArrayList<team>();
    fun addTeam(team: team) {
        this.teams.add(team);
    }
    fun getPlayer(pos: Int): team {
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

}