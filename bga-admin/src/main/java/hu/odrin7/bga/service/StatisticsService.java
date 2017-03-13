package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.statistics.Statistics;

import java.util.List;

public interface StatisticsService {

    void fillData();
    List<Statistics> getStatistics();
    Statistics saveStatistic(Statistics blogPost);
    Statistics deleteStatistic(Long postId);
}
