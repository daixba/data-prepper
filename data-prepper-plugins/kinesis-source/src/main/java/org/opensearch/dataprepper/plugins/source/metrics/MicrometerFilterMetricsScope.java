/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.plugins.source.metrics;

import com.google.common.collect.ImmutableSet;
import org.opensearch.dataprepper.metrics.PluginMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.cloudwatch.model.StandardUnit;
import software.amazon.kinesis.metrics.FilteringMetricsScope;
import software.amazon.kinesis.metrics.MetricsLevel;

public class MicrometerFilterMetricsScope extends FilteringMetricsScope {

    private static final Logger LOG = LoggerFactory.getLogger(MicrometerFilterMetricsScope.class);


    private final PluginMetrics pluginMetrics;


    public MicrometerFilterMetricsScope(final PluginMetrics pluginMetrics) {
        super(MetricsLevel.SUMMARY, ImmutableSet.of(METRICS_DIMENSIONS_ALL));
        this.pluginMetrics = pluginMetrics;
    }

    @Override
    public void addData(String name, double value, StandardUnit unit) {
        // TODO: report metrics.
    }


    @Override
    public void end() {
        // TODO: Update this
    }
}
