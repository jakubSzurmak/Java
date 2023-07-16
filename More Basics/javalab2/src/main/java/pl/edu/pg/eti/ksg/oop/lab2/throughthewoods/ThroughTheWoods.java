package pl.edu.pg.eti.ksg.oop.lab2.throughthewoods;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author TB
 */
public class ThroughTheWoods {
    private final String name;
    private final PrintStream microphone, spaceInTheWoods;
    private final Commentator commentator;
    private final List<RouteElement> routeElements;
    private final Set<Participant> participants;
    private final List<Participant> finish;
    
    
    public ThroughTheWoods(String name, PrintStream microphone, PrintStream spaceInTheWoods) {
        this.name = name;
        this.microphone = microphone;
        this.spaceInTheWoods = spaceInTheWoods;
        this.commentator = new Commentator(microphone);
        this.routeElements = new LinkedList<>();
        this.participants = new HashSet<>();
        this.finish = new LinkedList<>();
    }

    public void addRouteElement(RouteElement e) {
        routeElements.add(e);
    }

    public void clearRoute() {
        routeElements.clear();
    }
    
    public Iterable<RouteElement> getRouteElements()
    {
        return routeElements;
    }

    public void addParticipant(Participant u) {
        participants.add(u);
    }

    public void clearParticipantsList() {
        participants.clear();
    }

    public Iterable<Participant> getParticipants() {
        return participants;
    }
    
    public void runCompetitions()
    {
        commentator.inaugurateTheRun(name, participants);
        
        for(Participant p : participants)
        {
            p.sayTo(spaceInTheWoods);
        }
        
        commentator.announceStart(participants.size(), routeElements.size());
        
        for(Participant p : participants)
        {
            moveParticipantToRouteElement(p, 0);
        }

        boolean anyParicipantIsOnRoute;
        int roundNumber = 1;
        do
        {
            commentator.announceNewTurn(roundNumber);
            anyParicipantIsOnRoute = false;
            for(int iterator = routeElements.size() - 1; iterator >= 0; iterator--)
            {
                boolean anyParticipantsOnElement = strugglesWithRouteElement(iterator) > 0;
                anyParicipantIsOnRoute = anyParicipantIsOnRoute || anyParticipantsOnElement;
            }
            roundNumber++;
        }
        while(anyParicipantIsOnRoute );
    }
    
    private void moveParticipantToRouteElement(Participant u, int i) {
        if(i < routeElements.size())
        {
            routeElements.get(i).addParticipant(u);
        }
        else
        {
            commentator.announceFinishCross(u);
            finish.add(u);
        }
    }
        
    private int strugglesWithRouteElement(int routeElementIndex)
    {

        RouteElement re = routeElements.get(routeElementIndex);
        HashSet<Participant> toRemove = new HashSet<>();
        int participantsCount = 0;
        if(re instanceof Terrain)
        {
            Terrain t = (Terrain) re;
            for(Participant p : t.getParticipants())
            {   
                commentator.reportTerrain(routeElementIndex+1, p, t.getTerrainType());
                double speed = p.movementSpeed(t.getTerrainType());

                double currentAdvance = t.getParticipantsInTerrain().get(p);

                currentAdvance += speed * 1;

                if(currentAdvance < 1.0)
                    t.getParticipantsInTerrain().put(p, currentAdvance);
                else
                {
                    toRemove.add(p);
                    moveParticipantToRouteElement(p,routeElementIndex + 1);

                }
                participantsCount++;
            }
        }
        else if(re instanceof TaskEntity)
        {
            TaskEntity t = (TaskEntity) re;
            participantsCount = t.getParticipantsInTask().size();
            for(Participant p : t.getParticipants())
            {
                commentator.reportTask(routeElementIndex+1, p, t.getTaskField());
                boolean answer =p.solveTask(t.getTaskField());
                if(answer){
                    toRemove.add(p);
                    moveParticipantToRouteElement(p,routeElementIndex+1);
                    participantsCount -= 1;
                }
            }
        }

        for(Participant p : toRemove)
        {
            re.removeParticipant(p);
        }
        return participantsCount;
    }
}
