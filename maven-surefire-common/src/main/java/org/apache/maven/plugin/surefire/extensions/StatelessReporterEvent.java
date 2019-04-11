package org.apache.maven.plugin.surefire.extensions;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.plugin.surefire.report.TestSetStats;
import org.apache.maven.plugin.surefire.report.WrappedReportEntry;

import java.util.EventObject;

/**
 * author <a href="mailto:tibordigana@apache.org">Tibor Digana (tibor17)</a>
 * @since 3.0.0-M4
 */
public final class StatelessReporterEvent extends EventObject
{
    private final WrappedReportEntry testSetReportEntry;
    private final TestSetStats testSetStats;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public StatelessReporterEvent( Object source, WrappedReportEntry testSetReportEntry, TestSetStats testSetStats )
    {
        super( source );
        this.testSetReportEntry = testSetReportEntry;
        this.testSetStats = testSetStats;
    }

    public WrappedReportEntry getTestSetReportEntry()
    {
        return testSetReportEntry;
    }

    public TestSetStats getTestSetStats()
    {
        return testSetStats;
    }
}
