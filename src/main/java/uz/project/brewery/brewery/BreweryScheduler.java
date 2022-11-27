package uz.project.brewery.brewery;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import uz.project.brewery.elastic.ElasticService;

@Component
@EnableScheduling
@Log4j2
@AllArgsConstructor
public class BreweryScheduler {

    private final BreweryService breweryService;
    private final ElasticService elasticService;

    @Scheduled(cron = "0 * * * * *")
    public void add() {
        elasticService.addData(breweryService.get());
    }

}
