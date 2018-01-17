package vn.plusplusc.ecommerce.database.model;

import java.io.Serializable;
import java.util.Objects;
/**
*
* @author manhcuong
*/
public class SupplierAttributeDetailPK implements Serializable {

    private Long supplierId;
    private Long attributeId;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.supplierId);
        hash = 29 * hash + Objects.hashCode(this.attributeId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SupplierAttributeDetailPK other = (SupplierAttributeDetailPK) obj;
        if (!Objects.equals(this.supplierId, other.supplierId)) {
            return false;
        }
        if (!Objects.equals(this.attributeId, other.attributeId)) {
            return false;
        }
        return true;
    }

}
