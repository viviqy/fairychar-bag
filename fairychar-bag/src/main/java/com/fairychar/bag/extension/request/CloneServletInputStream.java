package com.fairychar.bag.extension.request;

import org.apache.catalina.connector.CoyoteInputStream;
import org.apache.catalina.connector.InputBuffer;

/**
 * @author chiyo <br>
 * @since 3.0.1
 */
public class CloneServletInputStream extends CoyoteInputStream {

    public CloneServletInputStream(InputBuffer ib) {
        super(ib);
    }

}
