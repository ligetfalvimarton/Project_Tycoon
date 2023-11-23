package Model;

import Sources.VisitorState;
import java.util.ArrayList;
import java.util.List;

public class VisitorSimulation {

    private List<Visitor> visitors;
    private int prevDaily = 0;
    private int prevCapacity = 0;
    private int capacity = 0;
    private int sumHappiness = 0;
    private int dailyVisitors;
    private GameModel gameModel;

    /**
     * Konstruktor.
     * @param gameModel 
     */
    public VisitorSimulation(GameModel gameModel) {
        visitors = new ArrayList<>();
        dailyVisitors = prevDaily;
        this.gameModel = gameModel;
    }

    /**
     * Napi látogatók kigenerálása.
     * @param happiness
     * @param built 
     */
    public void generateDailyVisitors(int happiness, List<Buildable> built) {
        prevDaily = dailyVisitors*5;
        prevCapacity = capacity;
        capacity = 0;
        Visitor.setId(0);
        sumHappiness = 0;

        for (Buildable b : built) {
            capacity += b.getCapacity();
        }
        if (happiness >= 0 && happiness <= 50) {
            dailyVisitors = (int) (prevDaily * 0.98);
        } else if (happiness > 50 && happiness <= 75) {
            dailyVisitors = (int) (prevDaily + capacity - prevCapacity + 5);
        } else if (happiness > 75 && happiness <= 87) {
            dailyVisitors = (int) (prevDaily * 1.01 + (capacity - prevCapacity) * 2);
        } else if (happiness > 87 && happiness <= 100) {
            dailyVisitors = (int) (prevDaily * 1.02 + (capacity - prevCapacity) * 2);
        }
        dailyVisitors = dailyVisitors / 5;
        dailyVisitors = dailyVisitors > 50 ? 50 : dailyVisitors;
        //generate the visitors list
        for (int i = 0; i < dailyVisitors; i++) {
            if(gameModel.getSites().size() > 0){
                visitors.add(new Visitor(true, gameModel.getHappiness(), gameModel.getSites().size(),gameModel, this));  
            }
        }
    }

    /**
     * Szimuláció futtatása, személyek igényei szerint.
     */
    public void Simulate() {
        sortVisitors();
        List<Visitor> toRemove = new ArrayList<>();
        for (Visitor v : visitors) {

            if (v.getOnGame() <= v.getToVisit().size()-1) {
                int toVisitID = v.getToVisit().get(0);
                Buildable temp = gameModel.getSites().get(toVisitID);
                switch (v.getState()) {
                    case WAITING:
                        if (temp.getVisitorCount() < temp.getCapacity() - 1) {

                            v.setHappinessLevel(v.getHappinessLevel() + temp.getHappiness() >= 100
                                        ? 100 : v.getHappinessLevel() + temp.getHappiness());

                            gameModel.getSites().get(toVisitID).setVisitorCount(temp.getVisitorCount() + 1);

                        } else if (temp.getVisitorCount() < temp.getCapacity() + temp.getQueueCap() - 1) {
                            //sorball

                            gameModel.getSites().get(toVisitID).setVisitorCount(temp.getVisitorCount() + 1);
                        }
                        
                        break;
                    case INQUEUE:
                        v.setState(VisitorState.PLAYING);

                        v.setHappinessLevel(v.getHappinessLevel() + temp.getHappiness() >= 100
                                    ? 100 : v.getHappinessLevel() + temp.getHappiness());
                        break;
                    case PLAYING:
                        int money = gameModel.getMoney() + gameModel.getSites().get(v.getToVisit().get(0)).getIncome();
                        gameModel.setMoney(money);
                        
                        if (v.getToVisit().size() <= 0) {

                            v.setState(VisitorState.LEAVING);
                            toRemove.add(v);

                        }

                        gameModel.getSites().get(toVisitID).setVisitorCount(temp.getVisitorCount() - 1);
                        
                        v.nextPath();
                        break;
                    case LEAVING:
                        toRemove.add(v);
                        break;
                    default:
                        v.setState(VisitorState.WAITING);
                        break;
                }

            }
        }
        
        for (Visitor v : toRemove) {
            sumHappiness += v.getHappinessLevel();
            visitors.remove(v);
        }
    }
    
    public void headHome(){
        for(int i=0;i<visitors.size(); i++){
            visitors.get(i).nextPath();
        }
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    /**
     * Látogatók rendezése meglátogatni kivánt épületek szerint.
     */
    private void sortVisitors() {
        List<Visitor> temp = new ArrayList<>();
        List<Visitor> oldList = new ArrayList<>();
        oldList.addAll(visitors);

        for (Visitor v : visitors) {
            if (v.getState() == VisitorState.PLAYING) {
                temp.add(v);
                oldList.remove(v);
            }
        }
        temp.addAll(oldList);
        visitors = temp;
    }

    /**
     * Lista kiürítése.
     */
    public void emptyVisitors() {
        int size = visitors.size();
        for (Visitor v : visitors) {
            for (int id : v.getToVisit()) {
                v.setHappinessLevel(v.getHappinessLevel() - gameModel.getSites().get(id).getHappiness());
            }
            sumHappiness += v.getHappinessLevel();
        }
        sumHappiness = (int) ((sumHappiness / dailyVisitors) - gameModel.getHappiness());
        gameModel.setHappiness((int) (gameModel.getHappiness() + ((sumHappiness >= 0) ? 1 : -1)));
    }

    public void setPrevDaily(int prevDaily) {
        this.prevDaily = prevDaily;
    }

    public int getPrevCapacity() {
        return prevCapacity;
    }

    public void setPrevCapacity(int prevCapacity) {
        this.prevCapacity = prevCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSumHappiness() {
        return sumHappiness;
    }

    public void setSumHappiness(int sumHappiness) {
        this.sumHappiness = sumHappiness;
    }

    public int getDailyVisitors() {
        return dailyVisitors;
    }

    public void setDailyVisitors(int dailyVisitors) {
        this.dailyVisitors = dailyVisitors;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }
}

