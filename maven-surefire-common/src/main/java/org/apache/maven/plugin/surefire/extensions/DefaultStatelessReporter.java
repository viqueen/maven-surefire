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

import org.apache.maven.plugin.surefire.report.StatelessXmlReporter;
import org.apache.maven.surefire.extensions.SourceNameType;
import org.apache.maven.surefire.extensions.StatelessReportEventListener;
import org.apache.maven.surefire.extensions.StatelessReporter;

import static org.apache.maven.surefire.extensions.SourceNameType.DEFAULT;
import static org.apache.maven.surefire.extensions.SourceNameType.PHRASED;

/**
 * Default implementation for extension of {@link StatelessXmlReporter} in plugin.
 *
 * author <a href="mailto:tibordigana@apache.org">Tibor Digana (tibor17)</a>
 * @since 3.0.0-M4
 */
public class DefaultStatelessReporter
        extends StatelessReporter<StatelessReporterEvent, DefaultStatelessReportMojoConfiguration>
{

    @Override
    public StatelessReportEventListener<StatelessReporterEvent> createStatelessReportEventListener(
            DefaultStatelessReportMojoConfiguration configuration )
    {
        return new StatelessXmlReporter( configuration.getReportsDirectory(),
                configuration.getReportNameSuffix(),
                configuration.isTrimStackTrace(),
                configuration.getRerunFailingTestsCount(),
                configuration.getTestClassMethodRunHistory(),
                configuration.getXsdSchemaLocation(),
                getUseFileName(),
                getUseTestCaseClassName(),
                getUseTestCaseMethodName() );
    }

    @Override
    public Object clone( ClassLoader target )
    {
        try
        {
            Class<?> cls = target.loadClass( getClass().getName() );
            Object clone = cls.newInstance();

            cls.getMethod( "setDisableXmlReport", boolean.class )
                    .invoke( clone, isDisableXmlReport() );

            Class<?> enumCls = target.loadClass( SourceNameType.class.getName() );
            Object[] enums = enumCls.getEnumConstants();
            assert enums.length == 2 : "'SourceNameType' should have two enum constants {DEFAULT, PHRASED}.";
            Enum<?> defaultSourceName = findEnumByName( enums, DEFAULT.name() );
            Enum<?> phrasedSourceName = findEnumByName( enums, PHRASED.name() );
            cls.getMethod( "setUseFileName", enumCls )
                    .invoke( clone, getUseFileName() == DEFAULT ? defaultSourceName : phrasedSourceName );
            cls.getMethod( "setUseTestCaseClassName", enumCls )
                    .invoke( clone, getUseTestCaseClassName() == DEFAULT ? defaultSourceName : phrasedSourceName );
            cls.getMethod( "setUseTestCaseMethodName", enumCls )
                    .invoke( clone, getUseTestCaseMethodName() == DEFAULT ? defaultSourceName : phrasedSourceName );

            return clone;
        }
        catch ( ReflectiveOperationException e )
        {
            throw new IllegalStateException( e.getLocalizedMessage() );
        }
    }

    private static Enum<?> findEnumByName( Object[] enums, String name )
    {
        for ( Object e : enums )
        {
            Enum<?> foundEnum = (Enum<?>) e;
            if ( name.equals( foundEnum.name() ) )
            {
                return foundEnum;
            }
        }
        throw new IllegalStateException( "Could not find enum " + name );
    }
}
