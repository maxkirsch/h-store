/* This file is part of VoltDB.
 * Copyright (C) 2008-2010 VoltDB L.L.C.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package org.voltdb.sqlgenerator;

import org.voltdb.compiler.VoltProjectBuilder;


public class SimpleProjectBuilder extends VoltProjectBuilder {
    public static final Class<?> PROCEDURES[] = new Class<?>[] {
        StubProcedure.class
    };

    private String m_filename = null;

    public SimpleProjectBuilder(String filename) {
        super("simple");
        m_filename = filename;
    }

    public void addDefaultProcedures() {
        addProcedures(PROCEDURES);
    }

    public void addDefaultPartitioning() {
        addTablePartitionInfo("P1", "ID");
    }

    public void addDefaultSchema() {
        addSchema(getClass().getResource(m_filename));
    }
}
