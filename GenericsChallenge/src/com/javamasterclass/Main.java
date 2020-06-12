package com.javamasterclass;

public class Main {

    public static void main(String[] args) {
        //
        // Create a generic class to implement a league table for a sport.
        // The class should allow teams to be added to the list, and store
        // a list of teams that belong to the league.
        // Your class should have a method to print out the teams in order,
        // with the team at the top of the league printed first.
        // Only teams of the same type should be added to any particular
        // instance of the league class - the program should fail to compile
        // if an attempt is made to add an incompatible team.
        //

        League<Team<FootballPlayer>> footballLeague = new League<>("NFL");
        Team<FootballPlayer> montreal = new Team<>("Montreal");
        Team<FootballPlayer> calgary = new Team<>("Calgary");
        Team<FootballPlayer> toronto = new Team<>("Toronto");
        Team<FootballPlayer> vancouver = new Team<>("Vancouver");
        Team<BaseballPlayer> baseballTeam = new Team<>("Toronto Blue Jays");

        toronto.matchResult(vancouver, 1, 0);
        toronto.matchResult(montreal, 3, 8);
        montreal.matchResult(vancouver, 2, 1);

        footballLeague.add(montreal);
        footballLeague.add(calgary);
        footballLeague.add(toronto);
        footballLeague.add(vancouver);
//        footballLeague.add(baseballTeam);
        footballLeague.showLeagueTable();
    }
}
