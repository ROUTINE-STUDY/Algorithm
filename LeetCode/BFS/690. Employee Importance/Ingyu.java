import java.util.*;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Queue<Employee> q = new LinkedList<>();
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee emp : employees) {
            if (emp.id == id) {
                q.offer(emp);
            }
            map.put(emp.id, emp);
        }

        int total = 0;

        while (!q.isEmpty()) {
            Employee emp = q.poll();
            total += emp.importance;
            Iterator<Integer> it = emp.subordinates.iterator();
            while (it.hasNext()) {
                q.offer(map.get(it.next()));
            }
        }

        return total;
    }
}