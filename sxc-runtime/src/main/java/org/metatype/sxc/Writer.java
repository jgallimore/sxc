package org.metatype.sxc;

import org.metatype.sxc.util.XmlFactories;
import org.metatype.sxc.util.XoXMLStreamWriter;
import org.metatype.sxc.util.XoXMLStreamWriterImpl;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.OutputStream;
import java.util.Map;

public abstract class Writer {
    protected Context context;

    public Writer(Context context) {
        this.context = context;
    }

    public void write(OutputStream is, Object o) throws Exception {
        XMLStreamWriter w = getXMLOutputFactory().createXMLStreamWriter(is);
        write(w, o);
        w.close();
    }

    protected XMLOutputFactory getXMLOutputFactory() {
        return XmlFactories.getXof();
    }
    
    public void write(XMLStreamWriter xsr, Object o) throws Exception {
        write(new XoXMLStreamWriterImpl(xsr), o);
    }
    
    public void write(XMLStreamWriter xsr, Object o,  Map<String, Object> properties) throws Exception {
        write(new XoXMLStreamWriterImpl(xsr), o, properties);
    }    
    
    public void write(XoXMLStreamWriter xw, Object o) throws Exception {
    	write(xw, o, null);
    }
    
    public abstract void write(XoXMLStreamWriter xw, Object o, Map<String, Object> properties) throws Exception;
}
