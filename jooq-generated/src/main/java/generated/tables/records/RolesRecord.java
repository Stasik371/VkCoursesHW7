/*
 * This file is generated by jOOQ.
 */
package generated.tables.records;


import generated.tables.Roles;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RolesRecord extends UpdatableRecordImpl<RolesRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.roles.id</code>.
     */
    public RolesRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.roles.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.roles.role</code>.
     */
    public RolesRecord setRole(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.roles.role</code>.
     */
    public String getRole() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Roles.ROLES.ID;
    }

    @Override
    public Field<String> field2() {
        return Roles.ROLES.ROLE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getRole();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getRole();
    }

    @Override
    public RolesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public RolesRecord value2(String value) {
        setRole(value);
        return this;
    }

    @Override
    public RolesRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RolesRecord
     */
    public RolesRecord() {
        super(Roles.ROLES);
    }

    /**
     * Create a detached, initialised RolesRecord
     */
    public RolesRecord(Integer id, String role) {
        super(Roles.ROLES);

        setId(id);
        setRole(role);
    }

    /**
     * Create a detached, initialised RolesRecord
     */
    public RolesRecord(generated.tables.pojos.Roles value) {
        super(Roles.ROLES);

        if (value != null) {
            setId(value.getId());
            setRole(value.getRole());
        }
    }
}