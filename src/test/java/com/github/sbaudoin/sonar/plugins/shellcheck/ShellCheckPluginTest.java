/**
 * Copyright (c) 2018-2019, Sylvain Baudoin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.sbaudoin.sonar.plugins.shellcheck;

import junit.framework.TestCase;
import org.sonar.api.Plugin;
import org.sonar.api.SonarQubeSide;
import org.sonar.api.internal.SonarRuntimeImpl;
import org.sonar.api.utils.Version;

public class ShellCheckPluginTest extends TestCase {
    public void testExtensionCounts1() {
        Plugin.Context context = new Plugin.Context(SonarRuntimeImpl.forSonarQube(Version.create(6, 2), SonarQubeSide.SERVER));
        new ShellCheckPlugin().define(context);
        assertEquals(6, context.getExtensions().size());
    }

    public void testExtensionCounts2() {
        System.setProperty(ShellCheckPlugin.ADD_SHELL_LANGUAGE_PROPERTY, "false");
        Plugin.Context context = new Plugin.Context(SonarRuntimeImpl.forSonarQube(Version.create(6, 2), SonarQubeSide.SERVER));
        new ShellCheckPlugin().define(context);
        assertEquals(5, context.getExtensions().size());
    }

    public void testExtensionCounts3() {
        System.setProperty(ShellCheckPlugin.ADD_SHELL_LANGUAGE_PROPERTY, "True");
        Plugin.Context context = new Plugin.Context(SonarRuntimeImpl.forSonarQube(Version.create(6, 2), SonarQubeSide.SERVER));
        new ShellCheckPlugin().define(context);
        assertEquals(6, context.getExtensions().size());
    }

    public void testExtensionCounts4() {
        System.setProperty(ShellCheckPlugin.ADD_SHELL_LANGUAGE_PROPERTY, "something");
        Plugin.Context context = new Plugin.Context(SonarRuntimeImpl.forSonarQube(Version.create(6, 2), SonarQubeSide.SERVER));
        new ShellCheckPlugin().define(context);
        assertEquals(5, context.getExtensions().size());
    }
}
