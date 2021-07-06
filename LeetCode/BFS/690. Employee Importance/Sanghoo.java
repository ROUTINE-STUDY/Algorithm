package BFS.Employee_Importance;

import java.util.*;

/**
 * https://leetcode.com/problems/employee-importance/
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

}

public class Sanghoo {

    // BFS 어렵습니당.. 자꾸 보니까 조금 감이 잡히는것도 하네요
    public static int getImportance(List<Employee> employees, int id) {
        int res = 0;
        Queue<Employee> queue = new ArrayDeque();
        HashMap<Integer, Employee> hs = new HashMap();

        // employees List를 돌며 root 노드를 찾아 큐에 삽입합니다.
        // 위에 선언한 맵에 모든 employee들을 넣어주는 작업도 진행하는데, 고유 아이디로 쉽게 추출하기위해 추가하였습니다.
        // 맵은 처음에 계속 반복문으로 찾으려다보니 너무 효율이 안좋아서 선택했습니다.
        for(Employee em : employees) {
            hs.put(em.id, em);

            if(em.id == id) {
                queue.offer(em);
            }
        }

        // 지난번 기초 BFS 문제인 Maximum Depth of Binary Tree 의 코드를 보고 작성해보았습니다.
        // 기본적인 bfs 흐름은 같다고 생각합니다.
        while(!queue.isEmpty()) {

            for(int i=0; i<queue.size(); i++) {
                Employee em =  queue.poll();    // 노드를 꺼내서

                for(int sub : em.subordinates) {
                    queue.offer(hs.get(sub));
                }

                // 현재 노드의 importance를 더해줍니다.
                res += em.importance;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList(2);
        a.add(2);
        a.add(3);

        Employee em1 = new Employee(1,5, a);
        Employee em2 = new Employee(2,3, new ArrayList<>());
        Employee em3 = new Employee(3,3, new ArrayList<>());
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(em1);
        employees.add(em2);
        employees.add(em3);

        System.out.println(getImportance(employees, 1));
    }
}
