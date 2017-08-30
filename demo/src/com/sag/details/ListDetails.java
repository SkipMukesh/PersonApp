package com.sag.details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sag.getset.Person;

@SuppressWarnings("unused")
public class ListDetails {

	private static HashMap<Integer, Person> psn = getDetail(); 

	public ListDetails() {

		if (psn == null) {

			psn = new HashMap<Integer, Person>(); 

			psn.put(1, new Person(1, "mani", 21, "mani@work.com")); 
			psn.put(2, new Person(2, "kavi", 25, "kavi@work.com"));
			psn.put(3, new Person(3, "raj", 27, "raj@work.com"));
			psn.put(4, new Person(4, "ram", 18, "ram@work.com"));
		}
	}

	public List<Person> getDetails() { 

		return new ArrayList<Person>(psn.values()); 
	}

	public Person getOne(int pndtl) { 
		return psn.get(pndtl);
	}

	public Person addOne(Person pndtl) { 
		pndtl.setPsnId(psn.size() + 1);
		psn.put(pndtl.getPsnId(), pndtl);
		return pndtl;
	}

	public Person editOne(Person pndtl) { 
		if (pndtl.getPsnId() <= 0) {
			return null;
		}
		psn.put(pndtl.getPsnId(), pndtl);
		return pndtl;
	}

	public Person deleteOne(int pndtl) { 
		return psn.remove(pndtl);
	}

	public static HashMap<Integer, Person> getDetail() { 
		return psn;
	}

}
