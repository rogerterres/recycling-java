package com.javamasterclass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        /*
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);
//        items.add("roger");
        items.add(4);
        items.add(5);

        printDoubled(items);
    }

    private static void printDoubled(ArrayList<Integer> n) {
//        for (Object i : n) {
//            System.out.println((Integer) i * 2);
//        }
        for (int i : n) {
            System.out.println(i * 2);
     }
        */

        FootballPlayer tom = new FootballPlayer("Tom");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer ronaldo = new SoccerPlayer("Ronaldo");

        Team<FootballPlayer> montreal = new Team<>("Montreal");
        montreal.addPlayer(tom);
//        impactMontreal.addPlayer(pat);
//        impactMontreal.addPlayer(ronaldo);
        System.out.println(montreal.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Toronto Blue Jays");
        baseballTeam.addPlayer(pat);

//        Team<String> brokenTeam = new Team<>("This won't work");
//        brokenTeam.addPlayer("no-one");

        Team<SoccerPlayer> brokenTeam = new Team<>("Club Athletico Paranaense");
        brokenTeam.addPlayer(ronaldo);

        Team<FootballPlayer> calgary = new Team<>("Calgary");
        FootballPlayer banks = new FootballPlayer("Gordon");
        montreal.addPlayer(banks);

        Team<FootballPlayer> toronto = new Team<>("Toronto");
        Team<FootballPlayer> vancouver = new Team<>("Vancouver");

        toronto.matchResult(vancouver, 1, 0);
        toronto.matchResult(montreal, 3, 8);

        montreal.matchResult(vancouver, 2, 1);
//        montrealImpact.matchResult(baseballTeam, 1, 1);

        System.out.println("Rankings");
        System.out.println(montreal.getName() + " : " + montreal.ranking());
        System.out.println(toronto.getName() + " : " + toronto.ranking());
        System.out.println(vancouver.getName() + " : " + vancouver.ranking());
        System.out.println(calgary.getName() + " : " + calgary.ranking());

        System.out.println(montreal.compareTo(toronto));
        System.out.println(montreal.compareTo(vancouver));
        System.out.println(vancouver.compareTo(toronto));
        System.out.println(toronto.compareTo(montreal));
        System.out.println(calgary.compareTo(vancouver));
    }
}
