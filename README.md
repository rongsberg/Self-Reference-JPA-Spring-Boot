# Self Reference using JPA in Spring Boot

- Removed @GenericGenerator in entity class as I don't have the generator class
- updated controller class just get it work in my dev environment, may not be related to your original question:

```
if (deptInput.getParentDepartment() != null) {
			Optional<Department> parentDepartment = departmentRepository.findById(deptInput.getParentDepartment().getId());
			deptInput.setParentDepartment(parentDepartment.isPresent()? parentDepartment.get(): null);

		}
		
		```
- Removed a few logging statement as I'm too lazy to fix compilation error.