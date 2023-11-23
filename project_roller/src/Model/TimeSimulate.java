package Model;

import View.GameField;
import java.io.IOException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Eltelt időt számlálja illetve naponta növeli a büdzsét
 */
public class TimeSimulate extends Thread{
    private LocalTime dateTime;
    private String date;
    private int daysPassed;
    private long toAdd;
    private int timeGap;
    private boolean inGame;
    
    private GameField gameField;

    /**
     * Alap konstruktor
     */
    public TimeSimulate() {
        dateTime = LocalTime.of(0, 0, 0);
        daysPassed = 1;
        FormatDate();
        toAdd = 1;
        timeGap = 50;
        inGame = true;
    }
    
    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    /**
     * Kezeli a timer-t, naponta növeli a megfelelő összeggel illetve
     * 24 óránként növeli a napokat.
     */
    @Override
    public void run() {
       while(inGame){
            LocalTime prevTime = dateTime;
            dateTime = dateTime.plusMinutes(toAdd);
            if(prevTime.getHour() == 23 && dateTime.getHour() == 0){
                daysPassed += 1;
            }
            FormatDate();
           try {
               gameField.setDateText(date);
           } catch (IOException ex) {
               Logger.getLogger(TimeSimulate.class.getName()).log(Level.SEVERE, null, ex);
           }
            gameField.setMoneyText();
            try {
                sleep(timeGap);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Idő múlásának sebességét változtatja
     */
    public void FasterTime(){
        PauseTimer();
        toAdd = 1;
        timeGap = 10;
        ResumeTimer();
    }

    /**
     * Idő múlásának sebességét változtatja
     */
    public void StopTime(){
        PauseTimer();
        toAdd = 0;
        ResumeTimer();
    }

    /**
     * Idő múlásának sebességét változtatja
     */
    public void NormalTime(){
        PauseTimer();
        toAdd = 1;
        timeGap=50;
        ResumeTimer();
    }
    
    /**
     * Visszaállítja az időt nullára
     */
    public void resetTime(){
        dateTime = LocalTime.of(0, 0, 0);
        daysPassed = 1;
    }

    /**
     * Eltelt idő kellemes nézetté formálása
     */
    private void FormatDate(){
        String hour = dateTime.getHour()/10 == 0 ? "0" + dateTime.getHour() : ""+dateTime.getHour();
        String minute = dateTime.getMinute()/10 == 0 ? "0" + dateTime.getMinute() : ""+dateTime.getMinute();

        date = daysPassed + ". nap, " + hour  + ":" + minute;
    }

    /**
     * Megallitja a timert, hogy bizonyos modositasokat lehessen vegrehajtani
     */
    public void PauseTimer(){
        inGame = false;
    }
     /**
      * Folytatja a timert
      */
    public void ResumeTimer(){
        inGame = true;
    }

    public String getDate() {
        return date;
    }

    public LocalTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getDaysPassed() {
        return daysPassed;
    }

    public void setDaysPassed(int daysPassed) {
        this.daysPassed = daysPassed;
    }

    public long getToAdd() {
        return toAdd;
    }

    public void setToAdd(long toAdd) {
        this.toAdd = toAdd;
    }

    public int getTimeGap() {
        return timeGap;
    }

    public void setTimeGap(int timeGap) {
        this.timeGap = timeGap;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
}
