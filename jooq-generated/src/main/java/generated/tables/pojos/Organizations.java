/*
 * This file is generated by jOOQ.
 */
package generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Organizations implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;

    public Organizations(Organizations value) {
        this.name = value.name;
    }

    public Organizations(
        String name
    ) {
        this.name = name;
    }

    /**
     * Getter for <code>public.organizations.name</code>.
     */
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Organizations other = (Organizations) obj;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Organizations (");

        sb.append(name);

        sb.append(")");
        return sb.toString();
    }
}
