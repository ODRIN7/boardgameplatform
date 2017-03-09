package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
import hu.odrin7.bga.domain.statistics.Statistics;
import hu.odrin7.bga.domain.statistics.StatisticsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StatisticsServiceImpl implements  StatisticsService{

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private StatisticsRepository statisticsRepository;

    public StatisticsServiceImpl() {
    }

    @Override
    public void fillData() {
        List<Statistics> statistics = this.getStatistics();
        if (statistics.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                Statistics post = new Statistics("Sample message post title #" + i, "Sample message post content #" + i);
                statisticsRepository.save(post);
                log.warn(post.toString());
            }
        }
    }

    @Override
    public List<Statistics> getStatistics() {
        return Lists.newArrayList(statisticsRepository.findAll());
    }

    @Override
    public Statistics saveStatistic(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    @Override
    public Statistics deleteStatistic(Long statisticId) {
        Statistics blogPost = statisticsRepository.findOne(statisticId);
        if (blogPost != null) {
            statisticsRepository.delete(blogPost);
        }
        return blogPost;
    }
}
