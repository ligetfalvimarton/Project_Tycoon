package Model;

import Sources.Images;
import java.awt.Point;

/**
 * Minden építhető elem gyűjtőosztálya
 */
public class Buildable extends Unit{
    private static int ID;
    private int level;
    private int buildPrice;
    private int happiness;
    private int cost;
    private int income;
    private int sizeX;
    private int sizeY;
    private int capacity;
    private int queueCap;
    private int roundSpan;
    private int visitorCount;
    private int upgradeCost;
    private boolean workerHome;
    
    /**
     * Teljes kontruktor
     * @param upgradeCost
     * @param buildPrice
     * @param happiness
     * @param cost
     * @param income
     * @param sizeX
     * @param sizeY
     * @param position
     * @param usable
     * @param type
     * @param imageID 
     */
    
    public Buildable(int buildPrice, int upgradeCost, int happiness, int cost, int income, int sizeX, int sizeY, Point position, boolean usable, String type, Images imageID) {
        super(position, usable, type, imageID);
        this.buildPrice = buildPrice;
        this.upgradeCost = upgradeCost;
        this.happiness = happiness;
        this.cost = cost;
        this.income = income;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        level = 1;
        capacity = 10;
        roundSpan = 20;
        queueCap = 10;
        visitorCount = 0;
        workerHome = true;
        
        ID = ++ID;
    }

    /**
     * UnitType-hoz alkalmakodó konstruktor.
     * @param position
     * @param usable
     * @param type
     * @param imageID
     * @param sizeX
     * @param sizeY 
     */
    public Buildable(Point position, boolean usable, String type, Images imageID,int sizeX,int sizeY) {
        super(position, usable, type, imageID);
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        
        ID = ++ID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBuildPrice() {
        return buildPrice;
    }

    public void setBuildPrice(int buildPrice) {
        this.buildPrice = buildPrice;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    } 

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getQueueCap() {
        return queueCap;
    }

    public void setQueueCap(int queueCap) {
        this.queueCap = queueCap;
    }

    public int getRoundSpan() {
        return roundSpan;
    }

    public void setRoundSpan(int roundSpan) {
        this.roundSpan = roundSpan;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public boolean getWorkerHome() {
        return workerHome;
    }

    public void setWorkerHome(boolean workerHome) {
        this.workerHome = workerHome;
    }
}
