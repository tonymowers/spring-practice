package ch.alika.springpractice.controller;

import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.dto.MoodChangeRequestDTO;
import ch.alika.springpractice.dto.MoodOverviewDTO;
import ch.alika.springpractice.service.IMoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MoodServiceController {

    private IMoodService moodService;

    @Autowired
    public MoodServiceController(IMoodService moodService) {
        this.moodService = moodService;
    }

    @RequestMapping(value = "/mood/overview", method = RequestMethod.GET)
    public ResponseEntity<MoodOverviewDTO> getMoodOverview() {
        log.debug("Mood overview GET");

        return new ResponseEntity<>(MoodOverviewDTO.from(moodService.getMoodOverview()), HttpStatus.OK);
    }

    @RequestMapping(value = "/mood/current", method = RequestMethod.GET)
    public ResponseEntity<Mood> getCurrentMood() {
        log.debug("Mood current GET");

        return new ResponseEntity<>(moodService.getCurrentMood(), HttpStatus.OK);
    }

    @RequestMapping(value = "/mood/current", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCurrentMood(
            @RequestBody MoodChangeRequestDTO moodChange
    ) {
        final String newMoodId = moodChange.getNewMoodId();
        log.debug(String.format("Mood current PUT newMoodId = [%s]", newMoodId));

        moodService.setCurrentMoodById(newMoodId);
        return new ResponseEntity<>("Current mood updated successfully", HttpStatus.OK);
    }
}
