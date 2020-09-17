package com.qs.leedcode;

import java.util.*;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/2 15:41
 */
public class GetImportance {

	static class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;

		public Employee() {
		}
	};

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Employee employee1 = new Employee();
		employee1.id = 1;
		employee1.importance = 30;
		List<Integer> subordinates = new ArrayList<>();
		subordinates.add(2);
		subordinates.add(3);
		employee1.subordinates = subordinates;

		Employee employee2 = new Employee();
		employee2.id = 2;
		employee2.importance = 10;

		Employee employee3 = new Employee();
		employee3.id = 3;
		employee3.importance = 12;
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		System.out.println(getImportance(employees, 1));
		sum();
		// 5*4*3*2*1
		System.out.println("factorial:" + factorial(5));
		System.out.println(1000==1000);
		System.out.println(100==100);
	}

	private static void  sum() {
		System.out.println("累计和：" + count(5));
	}

	private static int factorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}

	private static int count(int a) {
		if (a < 1) {
			return a;
		}
		return count(a - 1) + a;
	}

	public static int getImportance(List<Employee> employees, int id) {
		// bfs
		Queue<Employee> queue = new LinkedList<>();
		if (employees.size() == 0) {
			return 0;
		}
		int sumImportance = 0;
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).id == id) {
				queue.offer(employees.get(i));
			}
		}
		HashMap<Integer, Employee> empMap = new HashMap<>();
		for (Employee employee : employees) {
			if (!empMap.containsKey(employee.id)) {
				empMap.put(employee.id, employee);
			}
		}
		while (!queue.isEmpty()) {
			Employee e = queue.poll();
			sumImportance += e.importance;
			if (e.subordinates!=null && e.subordinates.size() != 0) {
				List<Employee> subordinates = getSubordinates(empMap, e.subordinates);
				for (Employee subordinate : subordinates) {
					queue.offer(subordinate);
				}
			}
		}
		return sumImportance;
	}

	public static List<Employee> getSubordinates(HashMap<Integer, Employee> empMap,List<Integer> subordinates) {
	    List<Employee> re =	new ArrayList<Employee>();
		if (subordinates.size() == 0) {
			return re;
		}
		for (Integer empId : subordinates) {
			if (empMap.containsKey(empId)) {
				re.add(empMap.get(empId));
			}
		}
		return re;
	}




}
