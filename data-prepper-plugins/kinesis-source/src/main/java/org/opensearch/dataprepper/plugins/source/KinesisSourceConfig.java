/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.plugins.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.opensearch.dataprepper.model.configuration.PluginModel;
import org.opensearch.dataprepper.plugins.source.configuration.AwsAuthenticationOptions;
import software.amazon.kinesis.common.InitialPositionInStream;


public class KinesisSourceConfig {

    @JsonProperty("stream_name")
    @NotNull
    @Valid
    private String streamName;

    @JsonProperty("aws")
    @NotNull
    @Valid
    private AwsAuthenticationOptions awsAuthenticationOptions;


    @JsonProperty("codec")
    private PluginModel codec;


    @JsonProperty("initial_position")
    private InitialPositionInStream initialPosition = InitialPositionInStream.LATEST;


    @JsonProperty("consumer_strategy")
    private ConsumerStrategy consumerStrategy = ConsumerStrategy.POLLING;


    public KinesisSourceConfig() {
    }

    public KinesisSourceConfig(String streamName, AwsAuthenticationOptions awsAuthenticationOptions, PluginModel codec, InitialPositionInStream initialPosition, ConsumerStrategy consumerStrategy) {
        this.streamName = streamName;
        this.awsAuthenticationOptions = awsAuthenticationOptions;
        this.codec = codec;
        this.initialPosition = initialPosition;
        this.consumerStrategy = consumerStrategy;
    }

    public String getStreamName() {
        return streamName;
    }

    public AwsAuthenticationOptions getAwsAuthenticationOptions() {
        return awsAuthenticationOptions;
    }

    public PluginModel getCodec() {
        return codec;
    }

    public InitialPositionInStream getInitialPosition() {
        return initialPosition;
    }

    public ConsumerStrategy getConsumerStrategy() {
        return consumerStrategy;
    }

    enum ConsumerStrategy {

        POLLING("Polling"),

        ENHANCED_FAN_OUT("Fan-Out");

        private final String value;

        ConsumerStrategy(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }
    }
}
