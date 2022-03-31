package c2tc.batch.malladmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MalladminController {
	
	@Autowired
	private MalladminService service;
	
	//Retrive All the rows from Database
	@GetMapping("/malladmins")
	public List<Malladmin> list()
	{
		return service.listAll();
	}
	
	//Retrive specific Records from Database
	@GetMapping("/malladmins/{id}")
	public ResponseEntity<Malladmin>get (@PathVariable Integer id)
	{
		Malladmin malladmin = service.get(id);	
		return new ResponseEntity<Malladmin> (malladmin,HttpStatus.OK);
	}
	
	//Create a row in database
	@PostMapping("/malladmins")
	public void add(@RequestBody Malladmin malladmin)
	{
		service.save(malladmin);
	}
	
	//Update Operation - record in database
	@PutMapping("/malladmins/{id}")
	public ResponseEntity<?>update(@RequestBody Malladmin malladmin,@PathVariable Integer id)
	{
		try {
			Malladmin existMalladmin = service.get(id);
			service.save(malladmin);
			return new ResponseEntity<Malladmin>(malladmin,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Deleting Operation
	@DeleteMapping("/malladmins/{id}")
	public void delete(@PathVariable Integer id)
	{
		service.delete(id);
	}
	

}
