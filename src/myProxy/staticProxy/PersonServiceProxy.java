package myProxy.staticProxy;

public class PersonServiceProxy implements PersonService{
	
	//目标类
	private PersonService personService = new PersonServiceImpl();
	
	//增强类
	private Transaction transaction = new Transaction();
	
	@Override
	public void savePerson() {
		transaction.beginTransaction();
		personService.savePerson();
		transaction.commit();
	}
 
	@Override
	public void updatePerson() {
		transaction.beginTransaction();
		personService.updatePerson();
		transaction.commit();
	}
 
	@Override
	public void deletePerson() {
		transaction.beginTransaction();
		personService.deletePerson();
		transaction.commit();
	}
 
}