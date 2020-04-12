package ch.alika.springpractice.dto;

import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.service.MoodOverview;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class MoodOverviewDTO {
    @NonNull private Mood currentMood;
    @NonNull private Mood defaultMood;
    @NonNull private List<Mood> allMoods;

    public static MoodOverviewDTO from(MoodOverview moodOverview) {
        return new MoodOverviewDTO(
                moodOverview.getCurrentMood(),
                moodOverview.getDefaultMood(),
                moodOverview.getAllMoods());
    }
}
