package pl.edu.pg.eti.ksg.oop.lab2.throughthewoods;

/**
 *
 * @author TB
 */
public interface RouteElement {
    Iterable<Participant> getParticipants();
    void addParticipant(Participant u);
    void removeParticipant(Participant u);
    int getParticipantsCountOnRoute();
}
