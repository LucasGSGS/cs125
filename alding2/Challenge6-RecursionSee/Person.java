//UIUC CS125 FALL 2013 MP. File: Person.java, CS125 Project: Challenge6-RecursionSee, Version: 2013-11-05T16:03:10-0600.767323587
/**
 * @author alding2
 *
 */
public class Person
{
private final String name;
private final int age;
private final char gender;
private final Person child1; //left child
private final Person child2; //right child

public Person(String name, int age, char gender, Person c1, Person c2)
{
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.child1 = c1;
    this.child2 = c2;
}

public String toString()
{
    return name+"*"+age+"*"+gender;
}

public String getName() 
{
	return name;
}

public int getAge() 
{
	return age;
}

public char getGender() 
{
	return gender;
}

public boolean equals(Person p)
{
	return (this.name.equals(p.name)) &&
			(this.age==p.age) &&
			(this.gender==p.gender);
}


public void print() 
{
   System.out.println(this);
   if(child1 != null)
       child1.print();
   if(child2 != null)
       child2.print();
   
}

public int count() // total person count including this object
{
	int count = 1;
	if (child1 != null) count += child1.count();
	if (child2 != null) count += child2.count();
	return count;
}
public int countGrandChildren() // but not greatGrandChildren
{
	int count = 0;
	if (child1 != null) {
		if (child1.child1 != null) count += 1;
		if (child1.child2 != null) count += 1;
	} 
	if (child2 != null) {
		if (child2.child1 != null) count += 1;
		if (child2.child2 != null) count += 1;
	}
	return count;
}


public int countMaxGenerations()
{
	int oldest = 1;
	if (child1 != null) oldest = Math.max(child1.countMaxGenerations() + 1, oldest);
	if (child2 != null) oldest = Math.max(child2.countMaxGenerations() + 1, oldest);
	return oldest;
}

public int countGender(char gen)
{
	int count = 0;
	if (gender == gen) count++;
	if (child1 != null) {
		count += child1.countGender(gen);
	} 
	if (child2 != null) {
		count += child2.countGender(gen);
	}
	return count;
}

public Person search(String theName, int maxGen)
{
	Person p = null;
	if (name.equals(theName)) return this;
	if (maxGen > 0) {
		if (child1 != null) p = child1.search(theName, maxGen-1);
		if (child2 != null && p == null) p = child2.search(theName, maxGen-1);
	}
	return p;
}

} // end of class
