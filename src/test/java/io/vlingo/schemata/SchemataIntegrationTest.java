// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.schemata;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.fail;

@Ignore("Ignored by default as tests in here require a schemata server to be running at the address defined in the pom.")
public class SchemataIntegrationTest {

    @Test
    public void pulledSchemaIsCompiled() {
        String consumedSchemaClass = "schemata.event.SchemaDefined";

        try {
            // we don't instantiate directly, so the test can compile w/o a schemata server
            Class schemaClass = this.getClass().getClassLoader().loadClass(consumedSchemaClass);
            schemaClass.newInstance();

        } catch (ClassNotFoundException e) {
            fail("Class " + consumedSchemaClass + " could not be found. Either the schemata reference is missing in the pom or it has not been pulled.");
        } catch (IllegalAccessException | InstantiationException e) {
            fail("Class " + consumedSchemaClass + " could not be instantiated. Did schemata deliver broken code?");
        }

    }
}
