package Main.Observers;

import Main.Observable.Subject;

public interface Observer {
    void update(Subject subject);
}
