package org.bonn.se.ws15.uebung8.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bonn.se.ws15.uebung8.dtos.UserStoryDTO;

/**
 * Created by Nils on 03.12.2015.
 */
public class UserStoryModel implements Serializable {
    private List<UserStoryDTO> stories = new ArrayList<UserStoryDTO>();

    private static UserStoryModel instance;

    private UserStoryModel() {
    }

    public void addStory(UserStoryDTO newStory) {
        this.stories.add(newStory);
        Collections.sort(this.stories);
    }

    public String dump() {
        String dump = "Priorität\tTitel\tMehrwert\tAufwand\tRisiko\tStrafe\n";
        for (UserStoryDTO us : stories) {
            dump += us.getPriority() + "\t" + us.getTitle() + "\t" + us.getValue() + "\t" + us.getEffort() + "\t"
                    + us.getRisk() + "\t" + us.getPenalty() + "\n";
        }
        return dump;
    }

    public int getCount() {
        return this.stories.size();
    }

    public List<UserStoryDTO> exportUserStories() {
        return stories;
    }

    public void importUserStories(List<UserStoryDTO> l) {
        stories = l;
    }

    public static UserStoryModel getInstance() {
        synchronized (UserStoryModel.class) {
            if (instance == null)
                instance = new UserStoryModel();
        }
        return instance;
    }
}
