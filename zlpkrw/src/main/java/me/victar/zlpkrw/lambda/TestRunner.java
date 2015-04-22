package me.victar.zlpkrw.lambda;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.google.common.collect.Lists;

public class TestRunner {

	public static void main(String[] args) {
		List<Person> sampleList = initTestData();
		printPersons(sampleList, p->p.getGender()==Person.Sex.MALE && p.getAge()>18&&p.getAge()<25, p->p.getEmailAddress(), email-> System.out.println(email));
	}



	public static void printPersons(List<Person> roster, Predicate<Person>  tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
            	String data = mapper.apply(p);
                block.accept(data);
            }
        }
	}

	private static List<Person> initTestData() {
		List<Person> sampleList = Lists.newArrayList();

		Person person1 = new Person("Victar", "victar@gmail.com", LocalDate.of(
				1985, 6, 25), Person.Sex.MALE);
		Person person2 = new Person("Katya", "katya@gmail.com", LocalDate.of(
				1987, 10, 7), Person.Sex.FEMALE);
		Person person3 = new Person("Dmitry", "dmitry@gmail.com", LocalDate.of(
				1991, 6, 25), Person.Sex.MALE);
		Person person4 = new Person("Dude", "dude@gmail.com", LocalDate.of(
				1995, 6, 25), Person.Sex.MALE);
		sampleList.add(person1);
		sampleList.add(person2);
		sampleList.add(person3);
		sampleList.add(person4);

		return sampleList;
	}
}
