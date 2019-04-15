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

import java.util.EventObject;

/**
 * Extension for stateless reporter.
 * Signatures can be changed between major or minor versions.
 *
 * @author <a href="mailto:tibordigana@apache.org">Tibor Digana (tibor17)</a>
 * @since 3.0.0-M4
 * @param <E> Generic type of event type
 * @param <C> mojo config
 */
public abstract class StatelessReporter<E extends EventObject, C extends StatelessReportMojoConfiguration>
{
    /**
     * {@code false} by default
     */
    private boolean disable;

    /**
     * Version of reporter. It is version <em>3.0</em> used by default in XML reporter.
     */
    private String version = "3.0";

    /**
     * Creates reporter.
     *
     * @return reporter object
     */
    public abstract StatelessReportEventListener<E> createStatelessReportEventListener( C configuration );

    public abstract Object clone( ClassLoader target );

    public boolean isDisable()
    {
        return disable;
    }

    public void setDisable( boolean disable )
    {
        this.disable = disable;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion( String version )
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "StatelessReporter{"
                + "version=" + version
                + ", disable=" + disable
                + '}';
    }
}
