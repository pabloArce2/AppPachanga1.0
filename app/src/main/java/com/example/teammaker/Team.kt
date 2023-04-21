package com.example.teammaker

class Team(private var nPlayer: Int) {
    private var players = ArrayList<String>()

    fun addPlayer(name: String) {
        players.add(name);
    }
    fun getPlayer(pos: Int): String {
        return players[pos];
    }
    fun setNPlayer(nPlayer: Int) {
        this.nPlayer = nPlayer;
    }
    fun getNPlayer(): Int {
        return nPlayer;
    }
}
