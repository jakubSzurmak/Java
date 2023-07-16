package pl.edu.pg.eti.ksg.oop.lab2.throughthewoods;

//import jdk.internal.org.jline.utils.ShutdownHooks;

import java.util.HashMap;
import java.util.Map;

public class TaskEntity implements RouteElement{

    private final TaskTypes tasksField;

    private final Map<Participant,Double> participantsInTask = new HashMap<>();

    public TaskEntity(TaskTypes tasksField){
        this.tasksField = tasksField;
    }

    @Override
    public Iterable<Participant> getParticipants(){
        return participantsInTask.keySet();
    }

    @Override
    public void addParticipant(Participant u) {
        participantsInTask.put(u, 1.0);
    }

    public TaskTypes getTaskField(){
        return tasksField;
    }

    public Map<Participant, Double> getParticipantsInTask() {return participantsInTask;}

    @Override
    public void removeParticipant(Participant p){participantsInTask.remove(p);}

    @Override
    public int getParticipantsCountOnRoute(){return participantsInTask.size();}
}
