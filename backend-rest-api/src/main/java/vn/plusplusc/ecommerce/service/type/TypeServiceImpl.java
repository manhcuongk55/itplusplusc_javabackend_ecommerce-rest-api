package vn.plusplusc.ecommerce.service.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.Type;
import vn.plusplusc.ecommerce.repository.TypeRepository;
@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	TypeRepository repository;
	

	@Override
	public Type getTypeById(Long id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Override
	public Iterable<Type> getAllTypes() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	

}
