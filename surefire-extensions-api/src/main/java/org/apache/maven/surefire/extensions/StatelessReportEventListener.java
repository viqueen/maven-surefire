package org.apache.maven.surefire.extensions;

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

import java.util.EventListener;
import java.util.EventObject;

/**
 * Creates a report upon handled event "<em>testSetCompleted</em>".
 * <br>
 * Defaults to <em>org.apache.maven.plugin.surefire.report.StatelessXmlReporter</em>.
 *
 * author <a href="mailto:tibordigana@apache.org">Tibor Digana (tibor17)</a>
 * @since 3.0.0-M4
 * @param <T> Generic type of event type
 */
public interface StatelessReportEventListener<T extends EventObject>
        extends EventListener
{
    /**
     * Event handled after the test class has been completed and the state of report is final.
     * <br>
     * The {@code event} (of type <em>org.apache.maven.plugin.surefire.extensions.StatelessReporterEvent</em>)
     * wraps <em>WrappedReportEntry</em> and <em>TestSetStats</em> from the module <em>maven-surefire-common</em>.
     * <br>
     * The {@link EventObject#getSource()} may access <em>TestSetRunListener</em> object or returns <tt>null</tt>.
     *
     * @param event event wrapper (type can be changed between major or minor versions)
     */
     void testSetCompleted( T event );
}
