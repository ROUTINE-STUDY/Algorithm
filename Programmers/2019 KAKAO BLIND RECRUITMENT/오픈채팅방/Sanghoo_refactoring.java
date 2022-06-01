package Programmers.오픈채팅방.refacotry;

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

class Command {
    private String command;
    private String userId;

    public Command(String command, String userId) {
        this.command = command;
        this.userId = userId;
    }

    public String getCommand() {
        return command;
    }

    public String getUserId() {
        return userId;
    }
}

public class Sanghoo {

    public static String[] solution(String[] records) {
        String[] answer = {};
        Map<String, User> userMap = new LinkedHashMap<>();
        List<Command> commandList = new ArrayList<>();

        final String ENTER_FORMAT = "%s님이 들어왔습니다.";
        final String LEAVE_FORMAT = "%s님이 나갔습니다.";

        for (String record : records) {
            String[] arr = record.split(" ");
            String command = arr[0];
            String userId = arr[1];
            String nickName = "";

            if("Enter".equals(command)) {
                nickName = arr[2];
                userMap.put(userId, new User(nickName));
                commandList.add(new Command(command, userId));
            } else if ("Leave".equals(command)) {
                commandList.add(new Command(command, userId));
            } else if ("Change".equals(command)) {
                nickName = arr[2];
                userMap.get(userId).changeNickName(nickName);
            }
        }

        answer = new String[commandList.size()];
        for (int i = 0; i < commandList.size(); i++) {
            String userId = commandList.get(i).getUserId();
            String command = commandList.get(i).getCommand();

            answer[i] = String.format("Enter".equals(command) ? ENTER_FORMAT : LEAVE_FORMAT, userMap.get(userId).getNickName());
        }

        return answer;
    }

}
