package jp.co.opentone.check.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account implements Serializable {

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = 3161530757962463192L;

    public Long id;
    public String username;
    public String password;
}
