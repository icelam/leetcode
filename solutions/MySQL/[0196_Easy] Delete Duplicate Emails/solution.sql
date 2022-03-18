DELETE Person FROM Person, Person Reference
WHERE Person.Email = Reference.Email AND Person.Id > Reference.Id;
