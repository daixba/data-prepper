/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.plugins.source.metrics;

import org.opensearch.dataprepper.metrics.PluginMetrics;
import software.amazon.kinesis.metrics.MetricsFactory;
import software.amazon.kinesis.metrics.MetricsScope;

public class MicrometerMetricFactory implements MetricsFactory {

    final PluginMetrics pluginMetrics;

    public MicrometerMetricFactory(PluginMetrics pluginMetrics) {
        this.pluginMetrics = pluginMetrics;
    }

    public MetricsScope createMetrics() {
        return new MicrometerFilterMetricsScope(pluginMetrics);
    }
}
