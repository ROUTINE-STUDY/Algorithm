import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int[] pivot = new int[2];
        Set<Route> set = new HashSet<>();

        for (char c : dirs.toCharArray()) {
            Route r = new Route(pivot);
            boolean isInRange = false;
            switch (c) {
                case 'U' :
                    if (r.startPoint[1] + 1 <= 5) {
                        r.endPoint[0] = r.startPoint[0];
                        r.endPoint[1] = r.startPoint[1] + 1;
                        isInRange = true;
                    }
                    break;
                case 'D' :
                    if (r.startPoint[1] - 1 >= -5) {
                        r.endPoint[0] = r.startPoint[0];
                        r.endPoint[1] = r.startPoint[1] - 1;
                        isInRange = true;
                    }
                    break;
                case 'L' :
                    if (r.startPoint[0] - 1 >= -5) {
                        r.endPoint[0] = r.startPoint[0] - 1;
                        r.endPoint[1] = r.startPoint[1];
                        isInRange = true;
                    }
                    break;
                case 'R' :
                    if (r.startPoint[0] + 1 <= 5) {
                        r.endPoint[0] = r.startPoint[0] + 1;
                        r.endPoint[1] = r.startPoint[1];
                        isInRange = true;
                    }
                    break;
            }

            if (isInRange) {
                set.add(r);
                pivot = new int[]{r.endPoint[0], r.endPoint[1]};
            }
        }

        return set.size();
    }
}

class Route {
    int[] startPoint;
    int[] endPoint;
    Route(int[] startPoint) {
        this.startPoint = startPoint;
        endPoint = new int[2];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Route) {
            Route r = (Route) obj;
            if (((this.startPoint[0] == r.startPoint[0]) && (this.startPoint[1] == r.startPoint[1]) && (this.endPoint[0] == r.endPoint[0]) && (this.endPoint[1] == r.endPoint[1]))
                    || ((this.startPoint[0] == r.endPoint[0]) && (this.startPoint[1] == r.endPoint[1]) && (this.endPoint[0] == r.startPoint[0]) && (this.endPoint[1] == r.startPoint[1]))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint[0]+startPoint[1]+endPoint[0]+endPoint[1]);
    }
}
