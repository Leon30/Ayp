package views;

import java.util.Scanner;
import models.Match;
import models.Nacionality;
import models.Player;
import models.Round;
import models.Team;
import models.Tournament;

public class IoManager {
    
    private Scanner scanner;

    public IoManager() {
        this.scanner = new Scanner(System.in);
    }
    
    public Player askForNewPlayer(){
        System.out.println("Ingrese el nombre: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Ingrese la media: ");
        double av = scanner.nextDouble();
        System.out.println("Ingrese la forma: ");
        double shape = scanner.nextDouble();
        return new Player(name, av, shape, askForNacionality());
    }
    
    public int askForTeam(Team[] teamList){
        printTeams(teamList);
        System.out.println("Ingrese la posicion:");
        return scanner.nextInt();
    }
    
    public Team askForNewTeam(){
        System.out.println("Ingrese el nombre: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Ingrese los partidos ganados: ");
        int wm = scanner.nextInt();
        Team newTeam = new Team(name, askForTournament(), wm);
        System.out.println("Equipo regitrado.");
        newTeam = askForPlayers(newTeam);
        return newTeam;
    }
    
    public Tournament askForTournament(){
        boolean correctTour = false;
        while (!correctTour) {
            System.out.println("Ingrese el torneo: ");
            String trn = scanner.nextLine();
            Tournament[] b = Tournament.values();
            String[] s = new String[b.length];
            for (int i = 0; i < b.length; i++) {
                s[i] = b[i].toString();
            }
            for (String string : s) {
                if (trn.equals(string)) {
                    return Tournament.valueOf(trn);
                }
            }
            System.out.println("Torneo incorrecto.");
        }
        return null;
    }
    
    public Round askForRound(){
        boolean correctRound = false;
        while (!correctRound) {
            System.out.println("Ingrese la ronda: ");
            String trn = scanner.nextLine();
            Round[] b = Round.values();
            String[] s = new String[b.length];
            for (int i = 0; i < b.length; i++) {
                s[i] = b[i].toString();
            }
            for (String string : s) {
                if (trn.equals(string)) {
                    correctRound = true;
                    return Round.valueOf(trn);
                }
            }
            System.out.println("Ronda incorrecta.");
        }
        return null;
    }
    
    public Nacionality askForNacionality(){
        boolean correctNacionality = false;
        while (!correctNacionality) {
            System.out.println("Ingrese la nacionalidad: ");
            String trn = scanner.nextLine();
            Nacionality[] b = Nacionality.values();
            String[] s = new String[b.length];
            for (int i = 0; i < b.length; i++) {
                s[i] = b[i].toString();
            }
            for (String string : s) {
                if (trn.equals(string)) {
                    correctNacionality = true;
                    return Nacionality.valueOf(trn);
                }
            }
            System.out.println("Nacionalidad incorrecta.");
        }
        return null;
    }
    
    public void printTeams(Team[] teamList){
        for (int i = 0; i < 10; i++) {
            if (teamList[i] != null) {
                System.out.println("(" + i + ") " + teamList[i]);
            }
        }
    }
    
    public void showMenu(){
        System.out.println("0: Registrar equipo. 1: Pronosticar encuentro. 2: Salir");
    }
    
    public Match showForecasterMenu(Team [] teamList){
        Team [] teams = new Team[2];
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.println("Primer equipo:");
            }else{
                System.out.println("Segundo equipo:");
            }
            System.out.println("0: Nuevo equipo. 1: Equipo existente.");
            switch (scanner.nextInt()) {
                case 0:
                    teams[i] = askForNewTeam();
                    break;
                case 1:
                    teams[i] = teamList[askForTeam(teamList)];
                    break;
                default:
                    System.out.println("Opcion Incorrecta.");
                    showForecasterMenu(teamList);
            }
        }
        return new Match(teams, askForTournament(), askForRound());
    }
    
    public int getOption(){
        return scanner.nextInt();
    }
    
    public void showResults(Match m, int pos){
        System.out.println("El equipo " + m.getTeams()[pos].getName() + " ganara");
    }

    public Team askForPlayers(Team t) {
        boolean addPlayerMenu = false;
        while (!addPlayerMenu) {
            System.out.println("0: Agregar jugador. 1: Terminar.");
            if (scanner.nextInt() == 0) {
                t.addPlayer(askForNewPlayer());
            }else{
                addPlayerMenu = true;
            }
        }
        return t;
    }
    
    public void showEqualsTeamError(){
        System.out.println("Los equipos son iguales!");
    }
    
    public void showOptionError(){
        System.out.println("Opcion incorrecta.");
    }
}
