package org.semanticweb.owl.explanation.telemetry;

/*
 * Copyright (C) 2010, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Author: Matthew Horridge<br>
 * The University of Manchester<br>
 * Information Management Group<br>
 * Date: 14-Mar-2010
 */
public class TelemetryObjectWrapper implements TelemetryObject {

    private Object object;

    private String preferredName;

    public TelemetryObjectWrapper(Object object, String serialisationName) {
        this.object = object;
        preferredName = serialisationName;
    }

    @Override
    public String getPreferredSerialisedName() {
        return preferredName;
    }

    @Override
    public void serialise(OutputStream outputStream) {
        PrintWriter pw = new PrintWriter(outputStream);
        pw.print(object);
        pw.flush();
    }

    @Override
    public boolean isSerialisedAsXML() {
        return false;
    }

}
