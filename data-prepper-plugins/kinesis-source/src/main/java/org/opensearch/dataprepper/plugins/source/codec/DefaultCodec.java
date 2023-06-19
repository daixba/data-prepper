/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.plugins.source.codec;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.opensearch.dataprepper.model.codec.InputCodec;
import org.opensearch.dataprepper.model.event.Event;
import org.opensearch.dataprepper.model.log.JacksonLog;
import org.opensearch.dataprepper.model.record.Record;
import org.opensearch.dataprepper.plugins.source.KinesisSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;


/**
 * A default InputCodec implementation for Kinesis Source
 * This codec parse line by line and then covert that to json output.
 */
public class DefaultCodec implements InputCodec {

    private static final Logger LOG = LoggerFactory.getLogger(KinesisSource.class);

    private static final ObjectMapper mapper = new ObjectMapper();


    @Override
    public void parse(InputStream inputStream, Consumer<Record<Event>> eventConsumer) throws IOException {

        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            LOG.debug("Codec to parse line message: " + line);
            JsonNode jsonNode = mapper.readTree(line);
            Record<Event> eventRecord = new Record<>(JacksonLog.builder().withData(jsonNode).build());
            eventConsumer.accept(eventRecord);
        }


    }
}
