package it.polimi.yasper.core.quering.operators.r2s;

import it.polimi.yasper.core.quering.response.InstantaneousResponse;

/**
 * Created by riccardo on 05/09/2017.
 */
public class Istream implements RelationToStreamOperator {
    private final int i;
    private InstantaneousResponse last_response;

    public Istream(int i) {
        this.i = i;
    }

    public static RelationToStreamOperator get() {
        return new Istream(1);
    }

    @Override
    public InstantaneousResponse eval(InstantaneousResponse new_response) {
        if (last_response == null) {
            return last_response = new_response;
        } else {
            InstantaneousResponse diff = new_response.difference(last_response);
            last_response = new_response;
            return diff;
        }
    }
}
