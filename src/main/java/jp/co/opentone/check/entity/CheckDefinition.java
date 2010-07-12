package jp.co.opentone.check.entity;

import java.io.Serializable;

public class CheckDefinition implements Serializable {

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = -7844315383242333216L;

    public Long id;
    public String name;
    public String description;
    public Account createdBy;
}
