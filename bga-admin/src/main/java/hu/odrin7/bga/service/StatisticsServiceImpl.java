package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
import hu.odrin7.bga.domain.statistics.Statistics;
import hu.odrin7.bga.domain.statistics.StatisticsRepository;
import hu.odrin7.bga.seq.dao.SequenceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatisticsServiceImpl implements  StatisticsService{

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final StatisticsRepository statisticsRepository;
    private final SequenceDao sequenceDao;
    private static final String STATISTICS_SEQ_KEY = "statistics";

    @Autowired
    public StatisticsServiceImpl(StatisticsRepository statisticsRepository,
                                 SequenceDao sequenceDao) {
        this.statisticsRepository = statisticsRepository;
        this.sequenceDao = sequenceDao;
    }

    @Override
    public void fillData() {
        List<Statistics> statistics = this.getStatistics();
        if (statistics.isEmpty()) {
            sequenceDao.saveNewKey(STATISTICS_SEQ_KEY, 600);
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
