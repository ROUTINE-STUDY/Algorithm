package Programmers.오픈채팅방;

import java.util.*;

class User {
    private String nickName;

    public User(String nickName) {
        this.nickName = nickName;
    }

    public void changeNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }
}

public class Sanghoo {

    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, User> commands = new LinkedHashMap<>();

        for (String command : record) {
            String[] arr = command.split(" ");
            if(arr.length == 2) {
                continue;
            }

            String initCommand = arr[0];
            String userId = arr[1];
            String nickName = arr[2];

            if("Enter".equals(initCommand)) {
                commands.put(userId, new User(nickName));
            } else if ("Change".equals(initCommand)) {
                commands.get(userId).changeNickName(nickName);
            }
        }

        List<String> answerList = new ArrayList<>();
        for (String command : record) {
            String[] arr = command.split(" ");
            String initCommand = arr[0];
            String userId = arr[1];
            String nickName = commands.get(userId).getNickName();

            if("Enter".equals(initCommand)) {
                answerList.add(nickName + "님이 들어왔습니다.");
            } else if ("Leave".equals(initCommand)) {
                answerList.add(nickName + "님이 나갔습니다.");
            }
        }

        answer = answerList.toArray(new String[0]);
        return answer;
    }

}
