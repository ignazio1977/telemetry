package org.semanticweb.owl.explanation.telemetry;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Before;
import org.junit.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OntologyConfigurator;
import org.semanticweb.owlapi.rdf.rdfxml.renderer.XMLWriterNamespaceManager;


/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date:
 *         04/06/2014
 */
public class TelemetryXMLWriteTestCase {

    private PrintWriter baseWriter;
    private ByteArrayOutputStream out;
    private XMLWriterNamespaceManager nsm;
    private TelemetryXMLWriter writer;

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
        baseWriter = new PrintWriter(out);
        nsm = new XMLWriterNamespaceManager("http://base.com/stuff/");
        writer = new TelemetryXMLWriter(baseWriter, nsm, "http://base.com/stuff",
            new OntologyConfigurator());
    }

    @Test
    public void shouldWriteElement() {
        writer.writeStartElement(IRI.create("experiment"));
        writer.writeEndElement();
        baseWriter.flush();
        assertThat(out.toString(StandardCharsets.UTF_8).trim(), is("<experiment/>"));
    }

    @Test
    public void shouldWriteAttribute() {
        writer.writeStartElement(IRI.create("experiment"));
        writer.writeAttribute("name", "ExperimentName");
        writer.writeEndElement();
        baseWriter.flush();
        assertThat(out.toString(StandardCharsets.UTF_8).trim(),
            is("<experiment name=\"ExperimentName\"/>"));
    }
}
