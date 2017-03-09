package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.statistics.Statistics;
import hu.odrin7.bga.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController
@RequestMapping("/statistics")
public class StatisticsRestController {

    @Autowired
    private StatisticsService statisticsService;

    public StatisticsRestController() {
    }

    @PostConstruct
    public void fillData() {
        statisticsService.fillData();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Statistics> getStatistics() {
        return statisticsService.getStatistics();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Statistics saveStatistic(@RequestBody Statistics statistic) {
        return statisticsService.saveStatistic(statistic);
    }

    @RequestMapping(value = "/{statisticId}", method = RequestMethod.DELETE)
    public Statistics deleteStatistic(@PathVariable("statisticId") Long statisticId) {
        return statisticsService.deleteStatistic(statisticId);
    }

}
