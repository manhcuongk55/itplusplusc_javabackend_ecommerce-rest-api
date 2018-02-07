package vn.plusplusc.ecommerce.service.type;

import vn.plusplusc.ecommerce.database.model.Type;

public interface TypeService {
  Type getTypeById(Long id);
  Iterable<Type> getAllTypes();
}
