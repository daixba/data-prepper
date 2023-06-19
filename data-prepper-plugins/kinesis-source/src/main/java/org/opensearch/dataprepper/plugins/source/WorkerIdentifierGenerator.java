/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.plugins.source;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Generate a unique ID to represent a consumer application instance.
 */
public class WorkerIdentifierGenerator {

    private static final String hostName;

    static {
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (final UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @return Default to use host name.
     */
    public String generate() {
        return hostName;
    }
}
