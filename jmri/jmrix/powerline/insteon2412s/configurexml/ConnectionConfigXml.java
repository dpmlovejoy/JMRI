package jmri.jmrix.powerline.insteon2412s.configurexml;

import jmri.InstanceManager;
import jmri.jmrix.configurexml.AbstractSerialConnectionConfigXml;
import jmri.jmrix.powerline.insteon2412s.ConnectionConfig;
import jmri.jmrix.powerline.insteon2412s.SpecificDriverAdapter;

/**
 * Handle XML persistence of layout connections by persisting
 * the SerialDriverAdapter (and connections). Note this is
 * named as the XML version of a ConnectionConfig object,
 * but it's actually persisting the SerialDriverAdapter.
 * <P>
 * This class is invoked from jmrix.JmrixConfigPaneXml on write,
 * as that class is the one actually registered. Reads are brought
 * here directly via the class attribute in the XML.
 *
 * @author Bob Jacobsen Copyright: Copyright (c) 2003, 2006, 2007, 2008
 * @version $Revision: 1.3 $
 */
public class ConnectionConfigXml extends AbstractSerialConnectionConfigXml {

    public ConnectionConfigXml() {
        super();
    }

    protected void getInstance() {
        adapter = new SpecificDriverAdapter();
    }

    protected void getInstance(Object object) {
        adapter = ((ConnectionConfig)object).getAdapter();
    }

    protected void register() {
        InstanceManager.configureManagerInstance().registerPref(new ConnectionConfig(adapter));
    }
     
    // initialize logging
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ConnectionConfigXml.class.getName());

}