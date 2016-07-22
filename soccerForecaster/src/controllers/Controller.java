package controllers;

import models.Match;
import models.SoccerForecaster;
import sun.applet.Main;
import views.IoManager;

public class Controller {
    
    private IoManager io;
    private SoccerForecaster sf;
    
    public Controller(){
        io = new IoManager();
        sf = new SoccerForecaster();
    }
    
    public void start(){
        boolean menu = true;
        while (menu) {
            io.showMenu();
            switch (io.getOption()) {
                case 0:
                    sf.registerTeam(io.askForNewTeam());
                    break;
                case 1:
                    Match choosenMatch = io.showForecasterMenu(sf.getTeamList());
                    int winPos = sf.getWinner(choosenMatch);
                    if (winPos != -1) {
                        io.showResults(choosenMatch, sf.getWinner(choosenMatch));
                    }else{
                        io.showEqualsTeamError();
                    }
                    break;
                case 2:
                    menu = false;
                    break;
                default:
                    io.showOptionError();
            }
        }  
    }
    
    public static void main(String[] args) {
        Controller c = new Controller();
        c.start();
    }
}
