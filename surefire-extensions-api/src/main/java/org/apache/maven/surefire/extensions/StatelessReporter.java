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
 *
 * @author <a href="mailto:tibordigana@apache.org">Tibor Digana (tibor17)</a>
 * @since 3.0.0-M4
 * @param <T> Generic type of event type
 * @param <C> mojo config
 */
public abstract class StatelessReporter<T extends EventObject, C extends StatelessReportMojoConfiguration>
{
    private boolean disableXmlReport;
    private SourceNameType useFileName;
    private SourceNameType useTestCaseClassName;
    private SourceNameType useTestCaseMethodName;

    /**
     * Creates reporter.
     *
     * @return reporter object
     */
    public abstract StatelessReportEventListener<T> createStatelessReportEventListener( C configuration );

    public boolean isDisableXmlReport()
    {
        return disableXmlReport;
    }

    public void setDisableXmlReport( boolean disableXmlReport )
    {
        this.disableXmlReport = disableXmlReport;
    }

    public SourceNameType getUseFileName()
    {
        return useFileName;
    }

    public void setUseFileName( SourceNameType useFileName )
    {
        this.useFileName = useFileName;
    }

    public SourceNameType getUseTestCaseClassName()
    {
        return useTestCaseClassName;
    }

    public void setUseTestCaseClassName( SourceNameType useTestCaseClassName )
    {
        this.useTestCaseClassName = useTestCaseClassName;
    }

    public SourceNameType getUseTestCaseMethodName()
    {
        return useTestCaseMethodName;
    }

    public void setUseTestCaseMethodName( SourceNameType useTestCaseMethodName )
    {
        this.useTestCaseMethodName = useTestCaseMethodName;
    }

    @Override
    public String toString()
    {
        return "StatelessReporter{"
                + "disableXmlReport=" + disableXmlReport
                + ", useFileName=" + useFileName
                + ", useTestCaseClassName=" + useTestCaseClassName
                + ", useTestCaseMethodName=" + useTestCaseMethodName
                + '}';
    }
}
