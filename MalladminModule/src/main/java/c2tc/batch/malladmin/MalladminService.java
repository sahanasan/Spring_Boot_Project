package c2tc.batch.malladmin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MalladminService {
	
@Autowired
private MalladminRepository repository;

	public List<Malladmin> listAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	public Malladmin get(Integer id)
	{
		return repository.findById(id).get();
	}
	public void save(Malladmin malladmin)
	{
		repository.save(malladmin);
		
	}
	public void delete(Integer id)
	{
		repository.deleteById(id);
		
	}

}
